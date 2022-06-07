package com.idat.MayoServicioPrueba.model;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Proveedores")
public class Proveedor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProveedor;
	
	private String proveedor;
	private String direccion;
	

	//Relacion de uno a uno**
	//se inserta la anotación
	//se inserta la anotacion @JoinColumn
	@OneToOne
	@JoinColumn(name = "id_producto", 
				nullable = false, 
				unique = true, 
				foreignKey = @ForeignKey(foreignKeyDefinition = 
				"foreign key(id_producto) references Productos(id_producto)"))
	//Codigo para definir el foreign key de id_producto en la clase Productos
	private Producto producto;

	public Integer getIdProveedor() {
		return idProveedor;
	}
	public void setIdProveedor(Integer idProveedor) {
		this.idProveedor = idProveedor;
	}
	public String getProveedor() {
		return proveedor;
	}
	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
}