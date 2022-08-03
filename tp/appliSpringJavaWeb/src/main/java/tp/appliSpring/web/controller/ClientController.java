package tp.appliSpring.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tp.appliSpring.core.entity.Client;
import tp.appliSpring.core.service.ServiceClient;

@Controller  //cas particulier de @Component (pour crontroller web de spring mvc)
public class ClientController {
	
	@Autowired
	private ServiceClient serviceClient;
	
	@RequestMapping("/initLogin")
	public String initLogin(Model model) {
		return "login"; //pour demander la vue jsp/login.jsp
	}
	
	@RequestMapping("/verifLogin")
	public String verifLogin(Model model,@RequestParam(name="numClient") Long numClient) {
		Client clientAvecSesComptes = serviceClient.rechercherClientAvecComptesByNum(numClient);
		model.addAttribute("client", clientAvecSesComptes);
		return "clientComptes"; //pour demander la vue jsp/clientComptes.jsp
	}

}
