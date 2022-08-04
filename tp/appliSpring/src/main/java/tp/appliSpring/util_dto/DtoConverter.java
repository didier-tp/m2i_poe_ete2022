package tp.appliSpring.util_dto;

import java.util.ArrayList;
import java.util.List;

import tp.appliSpring.core.entity.Compte;
import tp.appliSpring.dto.CompteEssentiel;

public class DtoConverter {

	public static List<CompteEssentiel> comptesToComptesEssentiels(List<Compte> comptes){
		List<CompteEssentiel> comptesEssentiels = new ArrayList<>();
		for(Compte compte : comptes) {
			comptesEssentiels.add(new CompteEssentiel(compte.getNumero(),compte.getLabel(),compte.getSolde()));
		}
		return comptesEssentiels;
	}
}
