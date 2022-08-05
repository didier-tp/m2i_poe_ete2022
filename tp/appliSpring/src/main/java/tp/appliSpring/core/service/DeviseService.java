package tp.appliSpring.core.service;

import java.util.List;

import tp.appliSpring.core.entity.Devise;

//si problème remontées d'exception héritant de runtimeException
public interface DeviseService {
	
	Devise rechercherDeviseParCode(String code);
	List<Devise> rechercherToutesDevises();
	void supprimerDeviseParCode(String code);
	void sauvegarderDevise(Devise d); //save or update;
	boolean existeOuPas(String code); 
    //...
}
