package com.idat.MayoServicioPrueba.service;

import java.util.List;

import com.idat.MayoServicioPrueba.model.Producto;

public interface ProductoService {

	void guardarProducto(Producto producto);
	void actualizarProducto(Producto producto);
	void eliminarProducto(Integer id);
	List<Producto> listarProducto();
	Producto obtenerProductoId(Integer id);
}
