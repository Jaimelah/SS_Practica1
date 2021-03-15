package es.unican.ss.practica1Parser;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.xml.bind.DatatypeConverter;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import es.unican.ss.exceptions.ErrorTarjeta;
import es.unican.ss.practica1Banco.Banco;
import es.unican.ss.practica1Banco.Cliente;
import es.unican.ss.practica1Banco.CuentaAhorro;
import es.unican.ss.practica1Banco.CuentaValores;
import es.unican.ss.practica1Banco.DepositoPlazoFijo;
import es.unican.ss.practica1Banco.ProductoBancario;
import es.unican.ss.practica1Banco.Tarjeta;
import es.unican.ss.practica1Banco.TipoCuentaAhorro;
import es.unican.ss.practica1Banco.Valor;

public class BancoCustomHandler extends DefaultHandler{

	private Banco banco;

	private Cliente clienteActual=null;

	private CuentaValores cuentaActual=null;


	public BancoCustomHandler() {
		this.banco=new Banco();
	}

	@Override
	public void startDocument() {
		System.out.println("Comienzo de documento");
	}
	@Override
	public void endDocument() {
		System.out.println("Fin de documento");
	}
	@Override
	public void startElement(String uri, String localName, String qName, Attributes atts) {
		if(qName.toUpperCase().equals("P:CLIENTE")) {
			clienteActual=new Cliente(atts.getValue("idUsuario"), atts.getValue("nombre")
					, atts.getValue("apellido1")
					, atts.getValue("apellido2")
					, atts.getValue("DNI"));
			System.out.println(clienteActual);
		}else if(qName.toUpperCase().equals("P:PRODUCTO")) {
			switch(atts.getValue("xsi:type").toUpperCase()) {
			case "P:CUENTAAHORRO":
				try {
					CuentaAhorro cuentaAhorro= new CuentaAhorro(atts.getValue("numeroCuenta")
							, new SimpleDateFormat("yyyy-MM-dd").parse(atts.getValue("fechaApertura"))
							, Double.parseDouble(atts.getValue("saldo"))
							, TipoCuentaAhorro.valueOf(atts.getValue("tipo")));
					clienteActual.getProductos().add(cuentaAhorro);
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case "P:CUENTAVALORES":
				try {
					cuentaActual=new CuentaValores(new SimpleDateFormat("yyyy-MM-dd").parse(atts.getValue("fechaApertura")) 
							,atts.getValue("numeroCuenta")
							,new ArrayList<Valor>());
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case "P:DEPOSITOPLAZOFIJO":
				try {
					DepositoPlazoFijo deposito=new DepositoPlazoFijo(Double.parseDouble(atts.getValue("importeDepositado"))
							,atts.getValue("tipoInteres") 
							,new SimpleDateFormat("yyyy-MM-dd").parse(atts.getValue("fechaVencimiento")));
					clienteActual.getProductos().add(deposito);
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				break;
			case "P:TARJETA":
				try {
					CuentaAhorro cuenta=null;
					for(ProductoBancario c:clienteActual.getProductos() ) {
						if(c instanceof CuentaAhorro) {
							if(((CuentaAhorro) c).getNumeroCuenta().equals(atts.getValue("numeroCuenta"))) {
								cuenta=(CuentaAhorro) c;
							}else {
								throw new ErrorTarjeta("No Se ha encontrado la cuenta de ahorro para asignar a la Tarjeta");
							}
						}
					}
					Tarjeta tarjeta=new Tarjeta(atts.getValue("numeroTarjeta")
							, new SimpleDateFormat("yyyy-MM-dd").parse(atts.getValue("fechaCaducidad"))
							, Integer.parseInt(atts.getValue("CVC"))
							, atts.getValue("numeroCuenta")
							, cuenta);
					clienteActual.getProductos().add(tarjeta);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				
				break;
			default:
				System.out.println("----___---___--__--_-_-___--_-_-__ no soy nada: "+qName+" "+atts.getValue(""));
				break;
			}
		}else if(qName.toUpperCase().equals("P:VALORCUENTA")) {
			Valor valor=new Valor(atts.getValue("nombreEntidad")
					,Integer.parseInt(atts.getValue("numeroAcciones"))
					,Double.parseDouble(atts.getValue("ultimoValorCotizado")));
			cuentaActual.getValores().add(valor);
		}else{
			System.out.println("No cliente u otro");
		}

	}
	@Override
	public void endElement(String uri, String localName, String qName) {
		if(qName.toUpperCase().equals("P:CLIENTE")) {
			if(clienteActual.getProductos().size()>2) {
				banco.getClientes().add(clienteActual);
			}
			this.clienteActual=null;
		}else if(qName.toUpperCase().equals("P:VALORCUENTA")) {
			clienteActual.getProductos().add(cuentaActual);
			System.out.println("Se acaba cuenta valores: "+cuentaActual);
			this.cuentaActual=null;
		}else if(qName.toUpperCase().equals("P:BANCO")) {
			System.out.println(this.banco);
		}
	}
	@Override
	public void characters(char[] ch, int start, int length) {

	}

}
