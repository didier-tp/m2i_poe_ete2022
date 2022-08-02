package tp.appliSpring.core.service;

import java.util.List;

import tp.appliSpring.core.entity.Compte;

public interface ServiceCompte {
	Compte rechercherCompteParNumero(long numCompte);
	List<Compte> rechercherComptesPourClient(long numClient);
	//...
	void supprimerCompte(long numCompte);
	Compte sauvegarderNouveauCompte(Compte compte);//create /insert into /persist
	void mettreAJourCompte(Compte compte); //update
	
	void effectuerVirement(double montant,long numCptDeb , long numCptCred);
	//...
}
