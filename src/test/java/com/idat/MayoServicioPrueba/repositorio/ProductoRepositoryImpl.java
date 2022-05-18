package com.idat.MayoServicioPrueba.repositorio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.idat.MayoServicioPrueba.model.Productos;

@Repository
public class ProductoRepositoryImpl implements ProductoRepository {
	
	public List<Productos> listar = new ArrayList<Productos>();

	@Override
	public void guardarProducto(Productos producto) {
		// TODO Auto-generated method stub
		listar.add(null);

	}

	@Override
	public void actualizarProducto(Productos producto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminarProducto(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Productos> listarProductos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Productos obtenerProductos(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
