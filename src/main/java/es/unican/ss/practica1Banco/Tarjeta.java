package es.unican.ss.practica1Banco;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
@XmlAccessorType(XmlAccessType.NONE)
public class Tarjeta extends ProductoBancario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@XmlAttribute(name="numeroTarjeta", required=true)
	protected int numeroTarjeta;
	@XmlAttribute(name="fechaCaducidad", required=true)
	protected Date fechaCaducidad;
	@XmlAttribute(name="cvc", required = true)
	protected int cvc;
	@XmlAttribute(name="numeroCuenta", required=true)
	protected int numeroCuenta;
	
	public Tarjeta() {
	}
	public Tarjeta(int numeroTarjeta, Date fechaCaducidad, int cvc, int numeroCuenta) {
		this.numeroTarjeta = numeroTarjeta;
		this.fechaCaducidad = fechaCaducidad;
		this.cvc = cvc;
		this.numeroCuenta = numeroCuenta;
	}
	public int getNumeroTarjeta() {
		return numeroTarjeta;
	}
	public void setNumeroTarjeta(int numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}
	public Date getFechaCaducidad() {
		return fechaCaducidad;
	}
	public void setFechaCaducidad(Date fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}
	public int getCvc() {
		return cvc;
	}
	public void setCvc(int cvc) {
		this.cvc = cvc;
	}
	public int getNumeroCuenta() {
		return numeroCuenta;
	}
	public void setNumeroCuenta(int numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}
	
	
	
	
	

}
