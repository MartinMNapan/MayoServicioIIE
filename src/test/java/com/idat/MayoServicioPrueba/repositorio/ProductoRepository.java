package com.idat.MayoServicioPrueba.repositorio;

import java.util.List;

import com.idat.MayoServicioPrueba.model.Productos;

public interface ProductoRepository {
	
	void guardarProducto(Productos producto);
	void actualizarProducto(Productos producto);
	void eliminarProducto(Integer id);
	
	List<Productos> listarProductos();
	Productos obtenerProductos(Integer id);

}
