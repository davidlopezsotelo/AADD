package GestionFicheros;

import java.io.IOException;
import java.util.jar.Attributes;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Acceso_xmlSax {

	public static void main(String[] args) 
			throws ParserConfigurationException, SAXException{

		SAXParserFactory factory = SAXParserFactory.newInstance();
		
		SAXParser saxParser = factory.newSAXParser();
		
		SaxHelper handler = new SaxHelper();
		
		try {
			saxParser.parse("C:\\Users\\David-Pc\\git\\AADD\\AccesoADatos\\src\\GestionFicheros\\coches.xml", handler);
		} catch (SAXException e) {

			e.printStackTrace();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
}
	
	public static class SaxHelper extends DefaultHandler
	{

	boolean esMarca = false;
	boolean esModelo = false;
	boolean esColor = false;
	boolean esMatriculacion = false;
	
	public void startElement(String uri, String localName, String elementos, Attributes atributos) throws SAXException {
		System.out.println("Inicio del elemento :" + elementos);
				switch (elementos) 
				{
					case "marca":esMarca = true;
							break;
					case "modelo":esModelo = true;
							break;
					case "color":esColor = true;
							break;
					case "matriculacion":esMatriculacion = true;
							break;
					default:break;
			  }
	 }
	
	public void characters(char ch[], int inicio, int length) throws SAXException {
		
		if (esMarca) {
		System.out.println("Marca: " + new String(ch, inicio, length));
		esMarca = false;
		return;
		}
		if (esModelo) {
		System.out.println("Modelo: " + new String(ch, inicio, length));
		esModelo = false;
		return;
		}
		if (esColor) {
		System.out.println("Color: " + new String(ch, inicio, length));
		esColor = false;
		return;
		}
		if (esMatriculacion) {
		System.out.println("Matriculacion: " + new String(ch, inicio, length));
		esMatriculacion = false;
		return;
		}
		}
	
	public void endElement(String uri, String localName, String elementos) throws SAXException {
		System.out.println("Fin del elemento: " + elementos);
		}


	}
}


