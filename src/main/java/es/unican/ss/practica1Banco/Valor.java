package es.unican.ss.practica1Banco;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
@XmlAccessorType(XmlAccessType.NONE)
public class Valor implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@XmlAttribute(name = "nombreEntidad",required=true)
	protected String nombreEntidad;
	@XmlAttribute(name="numeroAcciones", required=true)
	protected int numeroAcciones;
	@XmlAttribute(name="ultimoValorCotizado", required=true)
	protected double ultimoValorCotizado;
	
	public Valor() {
	}
	
	public Valor(String nombreEntidad, int numeroAcciones, double ultimoValorCotizado) {
		this.nombreEntidad = nombreEntidad;
		this.numeroAcciones = numeroAcciones;
		this.ultimoValorCotizado = ultimoValorCotizado;
	}
	
	public String getNombreEntidad() {
		return nombreEntidad;
	}
	public void setNombreEntidad(String nombreEntidad) {
		this.nombreEntidad = nombreEntidad;
	}
	public int getNumeroAcciones() {
		return numeroAcciones;
	}
	public void setNumeroAcciones(int numeroAcciones) {
		this.numeroAcciones = numeroAcciones;
	}
	public double getUltimoValorCotizado() {
		return ultimoValorCotizado;
	}
	public void setUltimoValorCotizado(double ultimoValorCotizado) {
		this.ultimoValorCotizado = ultimoValorCotizado;
	}
	
	
	
	
	
}
