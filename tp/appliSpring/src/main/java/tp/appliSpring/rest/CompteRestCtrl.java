package tp.appliSpring.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tp.appliSpring.core.entity.Compte;
import tp.appliSpring.core.service.ServiceCompte;
import tp.appliSpring.dto.CompteEssentiel;

@RestController  //composant spring de type "RestController"
@RequestMapping(value="/api-bank/compte" , headers="Accept=application/json")
public class CompteRestCtrl {
	
	@Autowired
	private ServiceCompte serviceCompte;
	
	public List<CompteEssentiel> comptesToComptesEssentiels(List<Compte> comptes){
		List<CompteEssentiel> comptesEssentiels = new ArrayList<>();
		for(Compte compte : comptes) {
			comptesEssentiels.add(new CompteEssentiel(compte.getNumero(),compte.getLabel(),compte.getSolde()));
		}
		return comptesEssentiels;
	}

	//URL: http://localhost:8080/appliSpring/api-bank/compte/1
	@GetMapping("/{numero}")
	public CompteEssentiel getCompteByNum(@PathVariable("numero")Long num) {
		Compte compte = serviceCompte.rechercherCompteParNumero(num);
		CompteEssentiel compteEssentiel = new CompteEssentiel(compte.getNumero(),compte.getLabel(),compte.getSolde());
		return compteEssentiel;
	}
	
	//URL:      http://localhost:8080/appliSpring/api-bank/compte
	// ou bien  http://localhost:8080/appliSpring/api-bank/compte?numClient=1
	@GetMapping("")
	public List<CompteEssentiel> getComptesByCriteria(@RequestParam(name="numClient",required=false)Long numClient) {
         if(numClient!=null)
        	 return comptesToComptesEssentiels(serviceCompte.rechercherComptesPourClient(numClient));
         else
        	 return comptesToComptesEssentiels(serviceCompte.rechercherTousLesComptes());
	}
}
