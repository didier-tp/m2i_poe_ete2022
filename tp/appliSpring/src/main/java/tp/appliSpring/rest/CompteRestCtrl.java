package tp.appliSpring.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tp.appliSpring.core.entity.Compte;
import tp.appliSpring.core.service.ServiceCompte;

@RestController  //composant spring de type "RestController"
@RequestMapping(value="/api-bank/compte" , headers="Accept=application/json")
public class CompteRestCtrl {
	
	@Autowired
	private ServiceCompte serviceCompte;

	//URL: http://localhost:8080/appliSpring/api-bank/compte/1
	@GetMapping("/{numero}")
	public Compte getCompteByNum(@PathVariable("numero")Long num) {
		return serviceCompte.rechercherCompteParNumero(num);
	}
}
