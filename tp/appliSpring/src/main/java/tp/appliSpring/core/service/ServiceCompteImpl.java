package tp.appliSpring.core.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tp.appliSpring.core.dao.DaoClient;
import tp.appliSpring.core.dao.DaoCompte;
import tp.appliSpring.core.entity.Client;
import tp.appliSpring.core.entity.Compte;
import tp.appliSpring.core.exception.SoldeInsuffisantException;

@Service //@Service = @Component de type service métier
//@Transactional //en placant @Transactional sur le haut de la classe = bonne pratique , on évite des oublis 
public class ServiceCompteImpl implements ServiceCompte {
	//à compléter
	
	private DaoCompte daoCompte; //dépendance à injecter
	
	private DaoClient daoClient; //dépendance à injecter
	
	/* @Autowired */
	public ServiceCompteImpl(DaoCompte daoCompte,DaoClient daoClient){
		//injection possible via constructeur (comme angular)
		this.daoCompte = daoCompte;
		this.daoClient = daoClient;
	}

	@Override
	public Compte rechercherCompteParNumero(long numCompte) {
		return daoCompte.findById(numCompte).orElse(null); //ou bien .get() ou bien ..
	}
	
	
	//sans @Transactional
	public void effectuerVirementSansTransaction(double montant, long numCptDeb, long numCptCred) {
	
		//sans transaction globale au niveau du service , daoCompte.findById() 
		//execute une minuscule petite transaction commité/fermée
		//et cptDeb est à l'état détaché
		Compte cptDeb = this.daoCompte.findById(numCptDeb).get();
		cptDeb.setSolde(cptDeb.getSolde() - montant);
		this.daoCompte.save(cptDeb);//on appelle explicitement .save() pour sauvegarder en base les modifications
		                            //effectuées sur l'objet à l'état détache de JPA/Hibernate
		//sans transaction globale au niveau du service , daoCompte.save() modifie définitivement l'état de la base
		//ça ne pourra plus être annulé
		
		Compte cptCred= this.daoCompte.findById(numCptCred).get();
		cptCred.setSolde(cptCred.getSolde() + montant);
		this.daoCompte.save(cptCred);
	}
	
	@Override
	@Transactional(/*propagation = Propagation.REQUIRED*/) //REQUIRED par defaut
	public void effectuerVirement(double montant, long numCptDeb, long numCptCred) {
		try {
			// transaction globale initialisée dès le début de l'exécution de effectuerVirement
			Compte cptDeb = this.daoCompte.findById(numCptDeb).get(); //le dao exécute son code dans la grande transaction
			//commencée par le service sans la fermer et l'objet cptDeb remonte à l'état persistant
			
			if(cptDeb.getSolde() < montant)
				throw new SoldeInsuffisantException("compte a débiter qui a un solde insuffisant : " + cptDeb);
			
			cptDeb.setSolde(cptDeb.getSolde() - montant);
			//this.daoCompte.save(cptDeb); //appel de .save() possible et dans ce cas base modifiée temporairement seulement
			                               //avec rollback ultérieur possible en cas d'exception
			
			//A faire en TP:
			Operation opDebit = new Operation(null,-montant,"debit lie au virement",new Date(),cptDeb);
			daoOperation.save(opDebit);
			
			
			//idem pour compte à créditer
			Compte cptCred= this.daoCompte.findById(numCptCred).get();
			cptCred.setSolde(cptCred.getSolde() + montant);
			//this.daoCompte.save(cptCred)

			//idem pour operation credit
			
			//en fin de transaction réussie (sans exception) , toutes les modification effectuées sur les objets
			//à l'état persistant seront répercutées en base (.save() automatiques)
		} catch (Exception e) {
			throw new RuntimeException("echec virement " + e.getMessage() , e); //rollback se fait de façon fiable
			//ou bien throw new ClasseExceptionPersonnaliseeHeritanttDeRuntimeException("echec virement" , e);
		}
	}

	@Override
	public List<Compte> rechercherComptesPourClient(long numClient) {
		Client clientAvecSesComptes = this.daoClient.findClientByIdWithComptes(numClient);
		return clientAvecSesComptes.getComptes();
	}

	@Override
	public void supprimerCompte(long numCompte) {
		 daoCompte.deleteById(numCompte);
	}

	@Override
	public Compte sauvegarderNouveauCompte(Compte compte) {
		daoCompte.save(compte);
		return compte;
	}

	@Override
	public void mettreAJourCompte(Compte compte) {
		if(daoCompte.existsById(compte.getNumero()))
		    daoCompte.save(compte);
		else 
			throw new RuntimeException("cannot update not existing compte :" + compte.toString());
	}

	
	
}