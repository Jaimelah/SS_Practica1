package es.unican.ss.practica1Banco;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
@XmlAccessorType(XmlAccessType.NONE)
public class DepositoPlazoFijo extends ProductoBancario implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@XmlAttribute(name="importeDepositado", required = true)
	protected double importeDepositado;
	@XmlAttribute(name="tipoInteres", required = true)
	protected String tipoInteres;
	@XmlAttribute(name="fechaVencimiento", required = true)
	protected Date fechaVencimiento;
	
	public DepositoPlazoFijo() {
	}
	public DepositoPlazoFijo(double importeDepositado, String tipoInteres, Date fechaVencimiento) {
		this.importeDepositado = importeDepositado;
		this.tipoInteres = tipoInteres;
		this.fechaVencimiento = fechaVencimiento;
	}
	public double getImporteDepositado() {
		return importeDepositado;
	}
	public void setImporteDepositado(double importeDepositado) {
		this.importeDepositado = importeDepositado;
	}
	public String getTipoInteres() {
		return tipoInteres;
	}
	public void setTipoInteres(String tipoInteres) {
		this.tipoInteres = tipoInteres;
	}
	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}
	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	@Override
	public String toString() {
		return "\nDepositoPlazoFijo [importeDepositado=" + importeDepositado + ", tipoInteres=" + tipoInteres
				+ ", fechaVencimiento=" + fechaVencimiento + "]";
	}
	
}
