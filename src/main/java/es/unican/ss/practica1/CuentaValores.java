package es.unican.ss.practica1;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class CuentaValores extends ProductoBancario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@XmlAttribute(name="accionesEnBolsa", required=true)
	protected int accionesEnBolsa;
	@XmlAttribute(name="fechaApertura", required=true)
	protected Date fechaApertura;
	@XmlAttribute(name="numeroCuenta", required=true)
	protected int numeroCuenta;
	@XmlElement(name = "valor", required = true)
	protected List<Valor>valores;
		
	public CuentaValores() {
	}
	public CuentaValores(int accionesEnBolsa, Date fechaApertura, int numeroCuenta, List<Valor> valores) {
		this.accionesEnBolsa = accionesEnBolsa;
		this.fechaApertura = fechaApertura;
		this.numeroCuenta = numeroCuenta;
		this.valores = valores;
	}
	public int getAccionesEnBolsa() {
		return accionesEnBolsa;
	}
	public void setAccionesEnBolsa(int accionesEnBolsa) {
		this.accionesEnBolsa = accionesEnBolsa;
	}
	public Date getFechaApertura() {
		return fechaApertura;
	}
	public void setFechaApertura(Date fechaApertura) {
		this.fechaApertura = fechaApertura;
	}
	public int getNumeroCuenta() {
		return numeroCuenta;
	}
	public void setNumeroCuenta(int numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}
	public List<Valor> getValores() {
		return valores;
	}
	public void setValores(List<Valor> valores) {
		this.valores = valores;
	}
	
	
	

}
