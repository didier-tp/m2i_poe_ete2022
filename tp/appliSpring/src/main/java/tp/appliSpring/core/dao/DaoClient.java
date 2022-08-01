package tp.appliSpring.core.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tp.appliSpring.core.entity.Client;

public interface DaoClient  extends JpaRepository<Client,Long>{
         
	//méthodes de recherche spécifiques aux Clients
	//qui respectent des conventions de nommage (code des requetes généré automatiquement)
    List<Client> findByNom(String nom); //findByNom car il existe Client.nom (SELECT c FROM Client c WHERE c.nom = ?1)
    List<Client> findByNomIgnoreCase(String nom);
    List<Client> findByNomOrderByPrenom(String nom);
    List<Client> findByNomLike(String motifNom); //motifNom = T% pour rechercher personne avec nom qui commence par T
}