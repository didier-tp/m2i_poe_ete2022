package tp.appliSpring.core.service;

import java.util.List;

import org.springframework.stereotype.Service;

import tp.appliSpring.core.dao.DaoClient;
import tp.appliSpring.core.dao.DaoCompte;
import tp.appliSpring.core.entity.Client;
import tp.appliSpring.core.entity.Compte;

@Service //@Service = @Component de type service métier
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
		return daoCompte.findById(numCompte).get(); //ou bien .orElse(null) ou bien ..
	}
	
	@Override
	public void effectuerVirement(double montant, long numCptDeb, long numCptCred) {
		// on remonte en mémoire tout l'objet compteDeb selon son numero (via daoCompte)
		// on débite de l'argent sur ce compte
		// on sauvegarde en base le compte modifié
		Compte cptDeb = this.daoCompte.findById(numCptDeb).get();
		cptDeb.setSolde(cptDeb.getSolde() - montant);
		this.daoCompte.save(cptDeb);
		
		//idem pour compte à créditer
		Compte cptCred= this.daoCompte.findById(numCptCred).get();
		cptCred.setSolde(cptCred.getSolde() + montant);
		this.daoCompte.save(cptCred);
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