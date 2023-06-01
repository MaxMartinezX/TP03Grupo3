package ar.edu.unju.edm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PrincipalController {


	 @GetMapping({"/","/index","/Home"})
		public ModelAndView solicitarPrincipal() {			
		
			ModelAndView principal = new ModelAndView("index");
		
			return principal;
		}
}
