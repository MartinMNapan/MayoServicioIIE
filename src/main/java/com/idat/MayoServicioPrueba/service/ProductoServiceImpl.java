package com.idat.MayoServicioPrueba.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.MayoServicioPrueba.dto.ProductoDTORequest;
import com.idat.MayoServicioPrueba.dto.ProductoDTOResponse;
import com.idat.MayoServicioPrueba.model.Producto;
import com.idat.MayoServicioPrueba.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService {
	
	@Autowired
	private ProductoRepository repository;

	@Override
	public void guardarProducto(ProductoDTORequest producto) {
		
		Producto p = new Producto();
		p.setNombreProducto(producto.getNombre());
		p.setDescripcion(p.getDescripcion());
		p.setPrecio(producto.getPrecioProducto());
		p.setStock(producto.getStockProducto());
		// TODO Auto-generated method stub
		repository.save(p);
	}

	@Override
	public void actualizarProducto(ProductoDTORequest producto) {
		// TODO Auto-generated method stub
		
		Producto p = new Producto();
		p.setIdProducto(producto.getId());
		p.setNombreProducto(producto.getNombre());
		p.setDescripcion(p.getDescripcion());
		p.setPrecio(producto.getPrecioProducto());
		p.setStock(producto.getStockProducto());
		
		repository.saveAndFlush(p);

	}

	@Override
	public void eliminarProducto(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);

	}

	@Override
	public List<ProductoDTOResponse> listarProducto() {
		
		 List<ProductoDTOResponse> listar = new ArrayList<>();
		 ProductoDTOResponse dto = null;
		 List<Producto> p = repository.findAll();
		 for(Producto producto : p) {
			 dto = new ProductoDTOResponse();
			 listar.add(dto);
		}
		return listar;
	}

	@Override
	public ProductoDTOResponse obtenerProductoId(Integer id) {
		// TODO Auto-generated method stub
		
		Producto producto = repository.findById(id).orElse(null);
		ProductoDTOResponse dto = new ProductoDTOResponse();
		
		dto.setDescripcionProducto(producto.getDescripcion());
		dto.setNombre(producto.getNombreProducto());
		dto.setPrecioProducto(producto.getPrecio());
		dto.setStockProducto(producto.getStock());
		dto.setId(producto.getIdProducto());
		
		return dto;
	}

}
