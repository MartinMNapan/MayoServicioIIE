package com.idat.MayoServicioPrueba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.idat.MayoServicioPrueba.model.Producto;
import com.idat.MayoServicioPrueba.model.Proveedor;
import com.idat.MayoServicioPrueba.service.ProductoService;
import com.idat.MayoServicioPrueba.service.ProveedorService;

@Controller
@RequestMapping(path = "/proveedor/v1")
public class ProveedorController {
	
	@Autowired
	private ProveedorService service;
		
	@RequestMapping("/listar")
	public @ResponseBody ResponseEntity<List<Proveedor>> listar(){
		return new ResponseEntity<List<Proveedor>>(service.listarProveedor(), HttpStatus.OK);
	}
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody Proveedor proveedor){
		service.guardarProveedor(proveedor);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

}
	