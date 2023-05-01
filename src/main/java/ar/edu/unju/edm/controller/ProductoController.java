package ar.edu.unju.edm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.edm.model.Producto;
import ar.edu.unju.edm.util.ListadoProductos;
@Controller
public class ProductoController {
	@GetMapping("/producto")
	public ModelAndView solicitarProducto() {
		
		Producto unProducto= new Producto();
		ModelAndView producto = new ModelAndView("formulario");
		producto.addObject("formulario", unProducto);
		
		return producto;
	}
	
	@PostMapping("/guardarProducto")
	public ModelAndView mostrarProducto(@ModelAttribute ("formulario") Producto nuevoProducto) {
		
		nuevoProducto.setEstado(true);
		ListadoProductos.getListado().add(nuevoProducto);
		ModelAndView listadoFinal= new ModelAndView("mostrarListado");
		listadoFinal.addObject("listado", ListadoProductos.getListado());
		
		return listadoFinal;
	}
	
}

