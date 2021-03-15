package es.unican.ss.practica1Banco;

import java.io.Serializable; 
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlSchemaType;
@XmlAccessorType(XmlAccessType.NONE)
public class Tarjeta extends ProductoBancario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@XmlAttribute(name="numeroTarjeta", required=true)
	protected String numeroTarjeta;
	@XmlAttribute(name="fechaCaducidad", required=true)
	protected Date fechaCaducidad;
	@XmlAttribute(name="cvc", required = true)
	protected int cvc;
	@XmlAttribute(name="numeroCuenta", required=true)
	protected String numeroCuenta;
	@XmlIDREF
	@XmlAttribute(name = "refCuentaAhorro", required = true)
	protected CuentaAhorro refCuentaAhorro;
	
	public Tarjeta() {
	}

	public Tarjeta(String numeroTarjeta, Date fechaCaducidad, int cvc, String numeroCuenta, CuentaAhorro refCuentaAhorro) {
		this.numeroTarjeta = numeroTarjeta;
		this.fechaCaducidad = fechaCaducidad;
		this.cvc = cvc;
		this.numeroCuenta = numeroCuenta;
		this.refCuentaAhorro = refCuentaAhorro;
	}


	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}
	public void setNumeroTarjeta(String numeroTarjeta) {
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
	public String getNumeroCuenta() {
		return numeroCuenta;
	}
	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public CuentaAhorro getRefCuentaAhorro() {
		return refCuentaAhorro;
	}

	public void setRefCuentaAhorro(CuentaAhorro refCuentaAhorro) {
		this.refCuentaAhorro = refCuentaAhorro;
	}

	@Override
	public String toString() {
		return "\nTarjeta [numeroTarjeta=" + numeroTarjeta + ", fechaCaducidad=" + fechaCaducidad + ", cvc=" + cvc
				+ ", numeroCuenta=" + numeroCuenta + ", refCuentaAhorro=" + refCuentaAhorro + "]";
	}
	
}
