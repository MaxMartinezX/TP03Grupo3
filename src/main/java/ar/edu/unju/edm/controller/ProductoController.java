package ar.edu.unju.edm.controller;

import org.apache.juli.logging.LogFactory;
import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unju.edm.model.Producto;
import ar.edu.unju.edm.service.IProductoService;
import ar.edu.unju.edm.util.ListadoProductos;
import ar.edu.unju.edm.controller.*;
@Controller
public class ProductoController {

	private static final Log GRUPO3 = LogFactory.getLog(ProductoController.class);
	
	//Inyeccion de dependencias
	@Autowired
	Producto unProducto;
	
	@Autowired
	@Qualifier("servicioEnLista")

	IProductoService unServicio;
	
	@GetMapping("/producto")
	public ModelAndView solicitarProducto() {

		ModelAndView producto = new ModelAndView("formulario");
		producto.addObject("formulario", unProducto);
		
		return producto;
	}
	
	@PostMapping("/guardarProducto")
	public ModelAndView mostrarProducto(@ModelAttribute ("formulario") Producto nuevoProducto) {
		
		GRUPO3.warn("Mostrando el nuevo producto " + nuevoProducto.getNombre());
		
		unServicio.cargarProducto(nuevoProducto);
		
		ModelAndView listadoFinal= new ModelAndView("mostrarListado");
		listadoFinal.addObject("listado", ListadoProductos.getListado());
		
		return listadoFinal;
	}
	
	@GetMapping("/guardarProducto")
	public ModelAndView productos(Model model) {
	
		ModelAndView listadoFinal= new ModelAndView("mostrarListado");
		listadoFinal.addObject("listado", ListadoProductos.getListado());
		return listadoFinal;
	}
	
	@GetMapping("/eliminarProducto/{codigo}")
	@ResponseBody
	public ModelAndView borrarProducto(@PathVariable Integer codigo) {
		
		try {
			unServicio.eliminarProducto(codigo);
			GRUPO3.error("PASANDO...");
		} catch (Exception e) {
			GRUPO3.error("encontrando: producto NO encontrado");
		}
		ModelAndView listadoUWU = new ModelAndView("redirect:/guardarProducto");
		listadoUWU.addObject("listado", unServicio.listarProductos());
		
		return listadoUWU;
		}

	}
	


