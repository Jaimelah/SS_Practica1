package es.unican.ss.practica1Main;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import es.unican.ss.practica1Parser.BancoCustomHandler;

public class Practica1_5_Main {

	public static void main(String[]args) {
		try {
			SAXParserFactory factory= SAXParserFactory.newInstance();
			SAXParser parser=factory.newSAXParser();
			BancoCustomHandler handler=new BancoCustomHandler();
			parser.parse("src/main/resources/practica1_2.xml", handler);
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}


}
