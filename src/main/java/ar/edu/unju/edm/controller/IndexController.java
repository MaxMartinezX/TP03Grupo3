package ar.edu.unju.edm.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.edm.model.Producto;
import ar.edu.unju.edm.util.ListadoProductos;
@Controller
public class IndexController {
	
	private static final Log GRUPO3 = LogFactory.getLog(IndexController.class);
	
	@GetMapping({"/", "/index", "/home"})
	public ModelAndView solicitarHome() {
		
		ModelAndView principal = new ModelAndView("index");	
		GRUPO3.info("Ingresando a mostrar el index");
		return principal;
	}
}
