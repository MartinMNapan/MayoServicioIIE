package com.idat.MayoServicioPrueba.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.idat.MayoServicioPrueba.model.Productos;

//Agregando anotaciones
@Repository
public class ProductoRepositoryImpl implements ProductoRepository {

	public List<Productos> listar = new ArrayList<Productos>();
	
	@Override
	public void guardarProducto(Productos producto) {
		// TODO Auto-generated method stub
		listar.add(producto);
	}

	@Override
	public void actualizarProducto(Productos producto) {
		Productos p = obtenerProductoId(producto.getIdProducto());
		listar.remove(p);
		listar.add(producto);
	}

	@Override
	public void eliminarProducto(Integer id) {
		Productos p = obtenerProductoId(id);
		listar.remove(p);
	}

	@Override
	public List<Productos> listarProductos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Productos obtenerProductoId(Integer id) {
		
//		if(listar != null){
//			for (Productos productos : listar) {
//				if (productos.getIdProducto() == id)
//					return productos;				
//			}
//		}
//		return null;
		
	//Programando en flujos
	return listar.stream().filter(p -> p.getIdProducto()==id).findFirst().orElse(null);	
	}
}
