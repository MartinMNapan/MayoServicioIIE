package com.idat.MayoServicioPrueba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.idat.MayoServicioPrueba.model.Producto;
import com.idat.MayoServicioPrueba.service.ProductoService;

@Controller
@RequestMapping("/producto/v1")
public class ProductoController {
	
	@Autowired
	private ProductoService service;
	
	@RequestMapping("/listar")
	public @ResponseBody ResponseEntity<List<Producto>> listar(){
		return new ResponseEntity<List<Producto>>(service.listarProducto(), HttpStatus.OK);
	}
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody Producto producto) {
		service.guardarProducto(producto);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
		
		Producto p = service.obtenerProductoId(id);
		
		if(p != null) {
			service.eliminarProducto(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		service.eliminarProducto(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@RequestMapping(path = "/actualizar/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> actualizar(@RequestBody Producto producto) {
		Producto p = service.obtenerProductoId(producto.getIdProducto());
		if(p != null) {
			service.actualizarProducto(producto);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<Producto> obtenerId(@PathVariable Integer id) {
		Producto p = service.obtenerProductoId(id);
		if(p != null) {
			return new ResponseEntity<Producto>(service.obtenerProductoId(id),HttpStatus.OK);
		}
		return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
	}
}
