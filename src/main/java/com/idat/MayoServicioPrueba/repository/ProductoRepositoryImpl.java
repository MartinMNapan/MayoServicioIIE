package com.idat.MayoServicioPrueba.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.idat.MayoServicioPrueba.model.Producto;

@Repository
public class ProductoRepositoryImpl implements ProductoRepository {

	public List<Producto> listar = new ArrayList<Producto>();
	
	@Override
	public void guardarProducto(Producto producto) {
		// TODO Auto-generated method stub
		listar.add(producto);

	}

	@Override
	public void actualizarProducto(Producto producto) {
		// TODO Auto-generated method stub
		Producto p = obtenerProductoId(producto.getIdProducto());
		listar.remove(p);
		listar.add(producto);

	}

	@Override
	public void eliminarProducto(Integer id) {
		// TODO Auto-generated method stub
		Producto p = obtenerProductoId(id);
		listar.remove(p);
		

	}

	@Override
	public List<Producto> listarProducto() {
		// TODO Auto-generated method stub
		return listar;
	}

	@Override
	public Producto obtenerProductoId(Integer id) {
		// TODO Auto-generated method stub
		return listar.stream().filter(p ->p.getIdProducto()==id).findFirst().orElse(null);
	}

}
