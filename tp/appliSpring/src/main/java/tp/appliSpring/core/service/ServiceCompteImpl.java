package tp.appliSpring.core.service;

import java.util.List;

import org.springframework.stereotype.Service;

import tp.appliSpring.core.dao.DaoCompte;
import tp.appliSpring.core.entity.Compte;

@Service //@Service = @Component de type service métier
public class ServiceCompteImpl implements ServiceCompte {
	//à compléter
	
	private DaoCompte daoCompte; //dépendance à injecter

	@Override
	public Compte rechercherCompteParNumero(long numCompte) {
		return daoCompte.findById(numCompte).get(); //ou bien .orElse(null) ou bien ..
	}
	
	@Override
	public void effectuerVirement(double montant, long numCptDeb, long numCptCred) {
		// on remonte en mémoire tout l'objet compteDeb selon son numero (via daoCompte)
		// on débite de l'argent sur ce compte
		// on sauvegarde en base le compte modifié
		
		//idem pour compte à créditer
		
	}

	@Override
	public List<Compte> rechercherComptesPourClient(long numClient) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void supprimerCompte(long numCompte) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Compte sauvegarderNouveauCompte(Compte compte) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void mettreAJourCompte(Compte compte) {
		// TODO Auto-generated method stub
		
	}

	
	
}