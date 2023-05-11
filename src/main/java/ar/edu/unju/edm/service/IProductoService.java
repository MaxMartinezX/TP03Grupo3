package ar.edu.unju.edm.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Producto;

@Service
public interface IProductoService {
	
	public void cargarProducto (Producto nuevoProducto);
	public ArrayList<Producto> listarProducto();
	//necesitaria el codigo para mostrar ese producto
	public Producto mostrarUnProducto(Integer codigo);
	public Producto eliminarUnProducto(Integer codigo);
	public void eliminarTodosLosProductos();
	public Producto modificarUnProducto(Integer codigo);

}
