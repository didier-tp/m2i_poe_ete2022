package tp.appliSpring.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller  //cas particulier de @Component (pour crontroller web de spring mvc)
public class ClientController {
	
	@RequestMapping("/initLogin")
	public String initLogin(Model model) {
		return "login"; //pour demander la vue jsp/login.jsp
	}
	
	@RequestMapping("/verifLogin")
	public String verifLogin(Model model) {
		return "clientComptes"; //pour demander la vue jsp/clientComptes.jsp
	}

}
