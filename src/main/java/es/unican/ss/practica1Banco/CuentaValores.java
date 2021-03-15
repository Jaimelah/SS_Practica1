package es.unican.ss.practica1Banco;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
@XmlAccessorType(XmlAccessType.NONE)
public class CuentaValores extends ProductoBancario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@XmlAttribute(name="fechaApertura", required=true)
	protected Date fechaApertura;
	@XmlAttribute(name="numeroCuenta", required=true)
	protected String numeroCuenta;
	@XmlElement(name = "valor", required = true)
	protected List<Valor>valores;
		
	public CuentaValores() {
		valores=new ArrayList<Valor>();
	}
	public CuentaValores( Date fechaApertura, String numeroCuenta, List<Valor> valores) {
		this.fechaApertura = fechaApertura;
		this.numeroCuenta = numeroCuenta;
		this.valores = valores;
	}
	public Date getFechaApertura() {
		return fechaApertura;
	}
	public void setFechaApertura(Date fechaApertura) {
		this.fechaApertura = fechaApertura;
	}
	public String getNumeroCuenta() {
		return numeroCuenta;
	}
	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}
	public List<Valor> getValores() {
		return valores;
	}
	public void setValores(List<Valor> valores) {
		this.valores = valores;
	}
	@Override
	public String toString() {
		return "\nCuentaValores [fechaApertura=" + fechaApertura
				+ ", numeroCuenta=" + numeroCuenta + ", valores=" + valores + "]";
	}
}
