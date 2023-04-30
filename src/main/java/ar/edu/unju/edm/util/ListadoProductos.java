package ar.edu.unju.edm.util;

import java.util.List;
import ar.edu.unju.edm.model.Producto;
import java.util.ArrayList;

public class ListadoProductos {
	
	private static List<Producto> listado = new ArrayList<>();
	
	public ListadoProductos() {
		
	}

	public static List<Producto> getListado() {
		return listado;
	}
	
}