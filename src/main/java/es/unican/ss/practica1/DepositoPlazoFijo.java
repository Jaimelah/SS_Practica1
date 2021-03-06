package es.unican.ss.practica1;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlAttribute;

public class DepositoPlazoFijo extends ProductoBancario implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@XmlAttribute(name="importeDepositado", required = true)
	protected double importeDepositado;
	@XmlAttribute(name="importeDepositado", required = true)
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
	
	

}
