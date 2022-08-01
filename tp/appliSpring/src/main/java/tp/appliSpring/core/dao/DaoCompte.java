package tp.appliSpring.core.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tp.appliSpring.core.entity.Compte;

public interface DaoCompte extends JpaRepository<Compte,Long>{
    /*
     on hérite de plein de méthodes prédéfinies:
     .save() , .findById() , findAll() , deleteById()
     */
   // List<Compte> findBySoldeMin(double soldeMinimum); //pas bien : ne respecte pas convention de nommage
   List<Compte> findBySoldeGreaterThanEqual(double soldeMinimum); //mieux (avec spring-data) : respecte convention de nommage et requête générée automatiquement
}