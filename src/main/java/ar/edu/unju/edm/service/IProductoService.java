package ar.edu.unju.edm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Producto;

@Service
public interface IProductoService {

	public void cargarProducto(Producto unProducto);
	public void eliminarProducto(Integer unCodigo);
	public List<Producto> listarProductos();
	public Producto mostrarUnProducto(Integer codigo);
	public void eliminarTodosLosProductos();
	public Producto modificarUnProducto(Integer codigo);
	
}
