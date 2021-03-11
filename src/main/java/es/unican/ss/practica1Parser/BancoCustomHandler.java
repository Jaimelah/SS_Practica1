package es.unican.ss.practica1Parser;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.DatatypeConverter;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import es.unican.ss.practica1Banco.Banco;
import es.unican.ss.practica1Banco.Cliente;
import es.unican.ss.practica1Banco.CuentaAhorro;
import es.unican.ss.practica1Banco.TipoCuentaAhorro;

public class BancoCustomHandler extends DefaultHandler{

	private Banco banco;
	
	private Cliente clienteActual=null;
	
	
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
			clienteActual=new Cliente(atts.getValue("nombre")
					, atts.getValue("apellido1")
					, atts.getValue("apellido2")
					, atts.getValue("dni"));
	
		}else if(qName.toUpperCase().equals("P:PRODUCTO")) {
			switch(atts.getValue("xsi:type")) {
			case "p:CuentaAhorro":
				System.out.println("tenemos una cuenta de ahorro");
				try {
					System.out.println(DatatypeConverter.parseLong(atts.getValue("numeroCuenta")));
					System.out.println(new SimpleDateFormat("yyyy-MM-dd").parse(atts.getValue("fechaApertura")+" fecha"));
					System.out.println(Double.parseDouble(atts.getValue("saldo")));
					System.out.println(TipoCuentaAhorro.valueOf(atts.getValue("tipo")));
					
					CuentaAhorro cuentaAhorro= new CuentaAhorro(Long.parseLong(atts.getValue("numeroCuenta"))
							, new SimpleDateFormat("yyyy-MM-dd").parse(atts.getValue("fechaApertura"))
							, Double.parseDouble(atts.getValue("saldo"))
							, TipoCuentaAhorro.valueOf(atts.getValue("tipo")));
					clienteActual.getProductos().add(cuentaAhorro);
					System.out.println("Se ha añadido cuenta ahorro");
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case "p:CuentaValores":

				System.out.println("tenemos una cuenta de valores");
				break;
			case "p:DepositoPlazoFijo":

				System.out.println("tenemos un deposito de plazo fijo");
				break;
			case "p:Tarjeta":

				System.out.println("tenemos una tarjeta");
				break;
			default:
				break;
			}
		}else {
			System.out.println("No cliente u otro");
		}
		System.out.println("la lista de clientes queda asi:" + banco.getClientes());

	}
	@Override
	public void endElement(String uri, String localName, String qName) {
		if(qName.toUpperCase().equals("P:CLIENTE")) {
			banco.getClientes().add(clienteActual);
			this.clienteActual=null;
			System.out.println("-------------------Se ha acabado el cliente");
		}
	}
	@Override
	public void characters(char[] ch, int start, int length) {

	}

}
