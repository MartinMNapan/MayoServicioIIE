package com.idat.MayoServicioPrueba.repository;

import java.util.List;

import com.idat.MayoServicioPrueba.model.Producto;

public interface ProductoRepository {
	
	void guardarProducto(Producto producto);
	void actualizarProducto(Producto producto);
	void eliminarProducto(Integer id);
	List<Producto> listarProducto();
	Producto obtenerProductoId(Integer id);

}
