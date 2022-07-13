package com.idat.MayoServicioPrueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.MayoServicioPrueba.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	//Consultas como el selecy
	Usuario findByUsuario(String usuario);
	

}
