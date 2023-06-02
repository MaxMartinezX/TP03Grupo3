package ar.edu.unju.edm.controller;

import org.apache.juli.logging.LogFactory;

import java.io.IOException;
import java.util.Base64;

import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
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
	@Qualifier("servicioEnMySQL")
	IProductoService unServicio;
	
	@GetMapping("/producto")
	public ModelAndView solicitarProducto() {
		
		ModelAndView producto = new ModelAndView("formulario");
		producto.addObject("formulario", unProducto);
		producto.addObject("band", false);
		return producto;
	}
	
	
	
	@PostMapping(value="/guardarProducto", consumes="multipart/form-data")
	public ModelAndView mostrarProducto(@ModelAttribute ("formulario") Producto nuevoProducto, @RequestParam ("file") MultipartFile[] archivo ) throws IOException {
		
		ModelAndView listadoFinal= new ModelAndView("mostrarListado");
		
		GRUPO3.warn("Mostrando el nuevo producto " + nuevoProducto.getNombre());
		
		//para cargar la imagen
		try {
			byte[] contenido = archivo[0].getBytes();
			String base64 = Base64.getEncoder().encodeToString(contenido);
			nuevoProducto.setImagen(base64);
			unServicio.cargarProducto(nuevoProducto);
			
		}catch(Exception e) {
			listadoFinal.addObject("pasa por aqui", e.getMessage());
		}
		
		
		//listadoFinal.addObject("listado", ListadoProductos.getListado());
		listadoFinal.addObject("listado", unServicio.listarProductos());
		
		return listadoFinal;
	}
	
	@PostMapping(value="/modificarProducto", consumes="multipart/form-data")
	public ModelAndView modificarProducto(@ModelAttribute ("formulario") Producto nuevoProducto, @RequestParam ("file") MultipartFile[] archivo ) throws IOException {
		
		ModelAndView listadoFinal= new ModelAndView("mostrarListado");
		
		GRUPO3.warn("Mostrando el nuevo producto " + nuevoProducto.getNombre());
		
		try {
			byte[] contenido = archivo[0].getBytes();
			String base64 = Base64.getEncoder().encodeToString(contenido);
			nuevoProducto.setImagen(base64);
			unServicio.cargarProducto(nuevoProducto);
			
		}catch(Exception e) {
			listadoFinal.addObject("pasa por aqui", e.getMessage());
		}
		
		listadoFinal.addObject("listado", unServicio.listarProductos());
		
		return listadoFinal;
	}
	
	@GetMapping("/guardarProducto")
	public ModelAndView productos(Model model) {
	
		ModelAndView listadoFinal= new ModelAndView("mostrarListado");
		listadoFinal.addObject("listado", unServicio.listarProductos());
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
	
	@GetMapping("/modificarProducto/{codigo}")
	public ModelAndView getModificarProducto(@PathVariable(name = "codigo")  Integer codigo) {
		
		ModelAndView modelAndView = new ModelAndView("formulario");
		try {
			modelAndView.addObject("formulario", unServicio.mostrarUnProducto(codigo));
		}catch (Exception e) {
			modelAndView.addObject("modificacionDeProductoErrorMessage", e.getMessage());
		}
		
		//bandera
		modelAndView.addObject("band", true);
		return modelAndView;
	}
	
	}
	
	

