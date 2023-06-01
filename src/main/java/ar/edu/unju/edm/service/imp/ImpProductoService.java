package ar.edu.unju.edm.service.imp;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Producto;
import ar.edu.unju.edm.service.IProductoService;
import ar.edu.unju.edm.util.ListadoProductos;
@Service
@Qualifier("servicioEnLista")
public class ImpProductoService  implements IProductoService{

	@Override
	public void cargarProducto(Producto unProducto) {
		unProducto.setEstado(true);
		ListadoProductos.getListado().add(unProducto);
	}

	@Override
	public void eliminarProducto(Integer unCodigo) {
		for(int i=0; i<ListadoProductos.getListado().size(); i++) {
			if(ListadoProductos.getListado().get(i).getCodigo()==unCodigo) {
				ListadoProductos.getListado().remove(i);
				System.out.println("estamos en eliminar "+unCodigo);
			}
		}
	}

	@Override
	public List<Producto> listarProductos() {
		
		return ListadoProductos.getListado();
	}

	@Override
	public Producto mostrarUnProducto(Integer codigo) {

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
