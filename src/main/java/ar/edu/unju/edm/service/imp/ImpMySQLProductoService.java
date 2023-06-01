package ar.edu.unju.edm.service.imp;

import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Producto;
import ar.edu.unju.edm.repository.ProductoRepository;
//import ar.edu.unju.edm.repository.ProductoRepository;
import ar.edu.unju.edm.service.IProductoService;

import java.util.ArrayList;
import java.util.Optional;

import org.apache.juli.logging.Log;

@Service
@Qualifier("servicioEnMySQL")
public class ImpMySQLProductoService implements IProductoService{
	
	@Autowired
	ProductoRepository productoRepository;
	
	private static final Log GRUPO3 = LogFactory.getLog(ImpMySQLProductoService.class);

	@Override
	public void cargarProducto(Producto unProducto) {
		
		unProducto.setEstado(true);
		productoRepository.save(unProducto);
		
	}

	@Override
	public ArrayList<Producto> listarProductos() {
		
		return (ArrayList<Producto>) productoRepository.findByEstado(true);
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
	@Override
	public void eliminarProducto(Integer unCodigo) {
		//productoRepository.deleteById(unCodigo);
		Optional<Producto> auxiliar=Optional.of(new Producto());
		auxiliar= productoRepository.findById(unCodigo);
		auxiliar.get().setEstado(false);
		productoRepository.save(auxiliar.get());
	}
	
}
