package es.unican.ss.practica1Banco;

import java.io.Serializable; 

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlID;
@XmlAccessorType(XmlAccessType.NONE)
public abstract class ProductoBancario implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@XmlID
	@XmlAttribute(name="idProductoBancario", required = true)
	protected String idProductoBancario;

}
