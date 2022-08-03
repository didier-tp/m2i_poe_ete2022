package tp.appliSpring.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller  //cas particulier de @Component (pour crontroller web de spring mvc)
public class HelloWorldController {
	
	@RequestMapping("/helloWorld")
	public String helloWorld(Model model) {
		model.addAttribute("message", "Hello World!");
		return "showMessage"; //pour demander la vue jsp/showMessage.jsp
	}

}
