package es.unican.ss.practica1Banco;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
@XmlAccessorType(XmlAccessType.NONE)
public class Cliente implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@XmlID
	@XmlAttribute(name="idUsuario", required=true)
	protected String idUsuario;
	@XmlAttribute(name="nombre", required = true)
	protected String nombre;
	@XmlAttribute(name = "apellido1", required = true)
	protected String apellido1;
	@XmlAttribute(name="apellido2", required = false)
	protected String apellido2;
	@XmlAttribute(name="dni", required= true)
	protected String dni;
	@XmlElement(name="producto", required=true)
	protected List<ProductoBancario>productos;
	
	public Cliente() {
		this.productos=new ArrayList<>();
	}

	public Cliente(String idUsuario, String nombre, String apellido1, String apellido2, String dni) {
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.dni = dni;
		this.productos=new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public List<ProductoBancario> getProductos() {
		return productos;
	}

	public void setProductos(List<ProductoBancario> productos) {
		this.productos = productos;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	@Override
	public String toString() {
		return "Cliente [idUsuario=" + idUsuario + ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2="
				+ apellido2 + ", dni=" + dni + ", productos=" + productos + "]";
	}
	
}
