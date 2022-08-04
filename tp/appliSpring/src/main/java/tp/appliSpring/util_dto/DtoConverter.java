package tp.appliSpring.util_dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;

import tp.appliSpring.core.entity.Compte;
import tp.appliSpring.dto.CompteEssentiel;

public class DtoConverter {
	
	/*
	public static CompteEssentiel compteToCompteEssentiel(Compte compte) {
		return new CompteEssentiel(compte.getNumero(),compte.getLabel(),compte.getSolde());
	}
	*/
	
	/*
	 * NB: il existe des api complementaires spécialisées dans les conversions d'objets java (DTO ou ...)
	 * MapStruct : bonnes performances , Dozer : trop lent , ....
	 */
	
	public static CompteEssentiel compteToCompteEssentiel(Compte compte) {
		CompteEssentiel compteEssentiel= new CompteEssentiel();
		/*
		compteEssentiel.setNumero(compte.getNumero());
		compteEssentiel.setLabel(compte.getLabel());
		compteEssentiel.setSolde(compte.getSolde());
		*/
		BeanUtils.copyProperties(compte, compteEssentiel);//recopie de source vers destination 
		                                               //toutes les propriétés/attributs de mêmes noms
		return compteEssentiel;
	}
	
	public static Compte compteEssentielToCompte(CompteEssentiel compteEssentiel) {
		Compte compte= new Compte();
		BeanUtils.copyProperties(compteEssentiel, compte);
		return compte;
	}

	public static List<CompteEssentiel> comptesToComptesEssentiels(List<Compte> comptes){
		/*
		List<CompteEssentiel> comptesEssentiels = new ArrayList<>();
		for(Compte compte : comptes) {
			comptesEssentiels.add(compteToCompteEssentiel(compte));
		}
		return comptesEssentiels;
		*/
		return comptes.stream()
				.map(compte -> compteToCompteEssentiel(compte))
				.collect(Collectors.toList());
	}
}
