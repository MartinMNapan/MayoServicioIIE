package com.idat.MayoServicioPrueba.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "Producto")
@Entity
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProducto;
	private String nombreProducto;
	private String descripcion;
	private Double precio;
	private Integer stock;
	
	//Relacion de uno a uno**
	//se inserta la anotación
	@OneToOne(mappedBy = "producto")
	private Proveedor proveedor;
	
	//insertamos el list<> de la otra tabla unidda de muchos a muchos
	//Insertamos la anotacion
	//Dentro de JoinTable agregamos el JoinColums y el inverseJoinColums para
	//crear la nueva tabla name = "producto_cliente"
	//copiampos el cascade = {.....}
	@ManyToMany(cascade = {CascadeType.PERSIST ,CascadeType.MERGE})
	@JoinTable(
			name = "productos_cliente",
			joinColumns = @JoinColumn(
					name = "id_producto", 
					nullable = false, 
					unique = true, 
					foreignKey = @ForeignKey(foreignKeyDefinition = 
					"foreign key(id_producto) references Producto(id_producto)")
			
	    ),
		inverseJoinColumns = @JoinColumn(
				name = "id_cliente", 
				nullable = false, 
				unique = true, 
				foreignKey = @ForeignKey(foreignKeyDefinition = 
				"foreign key(id_cliente) references clientes(id_cliente)")
				)
			
	)
	private List<Cliente> cliente = new ArrayList<>();
	
	public Integer getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
}
