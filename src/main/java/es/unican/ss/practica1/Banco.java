package es.unican.ss.practica1;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name="Banco")
public class Banco implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@XmlElement(name="cliente",required=true)
	protected List<Cliente>clientes;
	
	public Banco() {
	}
	public Banco(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	public List<Cliente> getClientes() {
		return clientes;
	}
	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	

	
}
