package tp.appliSpring.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import tp.appliSpring.core.entity.Client;
import tp.appliSpring.core.service.ServiceClient;

@Controller  //cas particulier de @Component (pour crontroller web de spring mvc)
@SessionAttributes( value={"client"} )
//noms des "modelAttributes" qui sont EN PLUS récupérés/stockés
//en SESSION HTTP au niveau de la page de rendu
//--> visibles en requestScope ET en sessionScope
public class ClientController {
	
	@Autowired
	private ServiceClient serviceClient;
	
	@RequestMapping("/initLogin")
	public String initLogin(Model model) {
		return "login"; //pour demander la vue jsp/login.jsp
	}
	
	@RequestMapping("/virement")
	public String versVirement(Model model) {
		return "virement"; //pour demander la vue jsp/virement.jsp
	}
	
	@ModelAttribute("client")
	public Client addClientInModel() {
		return new Client(); //valeur par defaut
	}
	
	@RequestMapping("/verifLogin")
	public String verifLogin(Model model,@RequestParam(name="numClient",required =false ) Long numClient) {
		if(numClient == null) {
			model.addAttribute("message", "numClient doit être une valeur numerique (1 ou 2 ou ...)");
			return "login"; //si rien de saisie , on réinvite à mieux saisir
		}
		
		Client clientAvecSesComptes = serviceClient.rechercherClientAvecComptesByNum(numClient);
		model.addAttribute("client", clientAvecSesComptes); //V1 et V2
		return "clientComptes"; //pour demander la vue jsp/clientComptes.jsp
	}

}
