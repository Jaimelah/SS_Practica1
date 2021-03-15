package es.unican.ss.practica1Banco;

import java.io.Serializable; 
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name="Banco")
public class Banco implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@XmlElement(name="cliente",required=true)
	protected List<Cliente>clientes;
	
	public Banco() {
		clientes=new ArrayList<>();
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
	@Override
	public String toString() {
		String txt="Banco: \n";
		for(Cliente c : clientes) {
			txt+=c.getDni();
			Double saldoTotal=0.0;
			for(ProductoBancario p : c.getProductos()) {
				if(p instanceof CuentaAhorro) {
					saldoTotal+=((CuentaAhorro) p).getSaldo();
				}else if (p instanceof DepositoPlazoFijo) {
					saldoTotal+=((DepositoPlazoFijo) p).getImporteDepositado();
				}else if(p instanceof CuentaValores) {
					Double saldoCuentaValores=0.0;
					for(Valor v: ((CuentaValores) p).getValores()) {
						saldoCuentaValores+=(v.getNumeroAcciones()*v.getUltimoValorCotizado());
					}
					saldoTotal+=saldoCuentaValores;
				}else {}
			}
			txt+=" "+saldoTotal+"\n";
		}
		return txt;
	}
	

	
}
