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

import com.idat.MayoServicioPrueba.model.Item;
import com.idat.MayoServicioPrueba.service.ItemService;

@Controller
@RequestMapping(path = "item/v1")
public class ItemController {
	
	@Autowired
	private ItemService service;
	
	@RequestMapping("listar")
	public @ResponseBody ResponseEntity<List<Item>> listar(){
		return new ResponseEntity<List<Item>>(service.listarItem(),HttpStatus.OK);
	}
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody Item item){
		service.guardarItem(item);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

}
