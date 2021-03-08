package es.unican.ss.practica1Parser;


import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import es.unican.ss.practica1Banco.Banco;

public class BancoCustomHandler extends DefaultHandler{
	
	private Banco banco;
	
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
		switch (qName.toUpperCase()) {
		case "P:CLIENTE":
			if(banco.getClientes().contains())
			break;

		default:
			System.out.println("Se ha producido un error");
			break;
		}
		
	}
	@Override
	public void endElement(String uri, String localName, String qName) {
		
	}
	@Override
	public void characters(char[] ch, int start, int length) {
		
	}

}
