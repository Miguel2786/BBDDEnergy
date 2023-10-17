package proyectBBDDEnergy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class InitialController {
	
	@GetMapping({"/index","/",""})
	public String m1(Model model) {
		
		model.addAttribute("Headboard","BBDD Energy");
		return "/vista/index";
	}
	
	
}
