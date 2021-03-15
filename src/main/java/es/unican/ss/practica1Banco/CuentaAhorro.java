package es.unican.ss.practica1Banco;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
@XmlAccessorType(XmlAccessType.NONE)
public class CuentaAhorro extends ProductoBancario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@XmlAttribute(name="numeroCuenta", required=true)
	protected String numeroCuenta;
	@XmlAttribute(name="fechaApertura", required=true)
	protected Date fechaApertura;
	@XmlAttribute(name="saldo", required = true)
	protected double saldo;
	@XmlAttribute(name="tipo", required=true)
	protected TipoCuentaAhorro tipo;
	
	public CuentaAhorro() {
		super();
	}

	public CuentaAhorro(String numeroCuenta, Date fechaApertura, double saldo, TipoCuentaAhorro tipo) {
		this.numeroCuenta = numeroCuenta;
		this.fechaApertura = fechaApertura;
		this.saldo = saldo;
		this.tipo = tipo;
	}

	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public Date getFechaApertura() {
		return fechaApertura;
	}

	public void setFechaApertura(Date fechaApertura) {
		this.fechaApertura = fechaApertura;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public TipoCuentaAhorro getTipo() {
		return tipo;
	}

	public void setTipo(TipoCuentaAhorro tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "\nCuentaAhorro [numeroCuenta=" + numeroCuenta + ", fechaApertura=" + fechaApertura + ", saldo=" + saldo
				+ ", tipo=" + tipo + "]";
	}
	
}
