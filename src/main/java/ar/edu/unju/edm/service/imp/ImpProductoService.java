package ar.edu.unju.edm.service.imp;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Producto;
import ar.edu.unju.edm.service.IProductoService;

@Service
public class ImpProductoService implements IProductoService{

	@Override
	public void cargarProducto(Producto nuevoProducto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Producto> listarProducto() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Producto mostrarUnProducto(Integer codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Producto eliminarUnProducto(Integer codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarTodosLosProductos() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Producto modificarUnProducto(Integer codigo) {
		// TODO Auto-generated method stub
		return null;
	}

}