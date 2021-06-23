package GestionFicheros;

import java.io.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.*;

public class Acceso_xml {

	public static void main(String[] args) {


		try{
			//Indicaremos la ruta del fichero xml
			//Src es el nombre raiz de nuestro proyecto, main es la primera capreta, resources la siguiente, dentro de xml encontraremos el fichero
			//Esta es la ruta relativa.
			
			File arxXml = new File("C:\\Users\\David-Pc\\git\\AADD\\AccesoADatos\\src\\GestionFicheros\\coches.xml");
			
			//Creamos los objetos que nos permitiran leer el fichero
			
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			
			DocumentBuilder db = dbf.newDocumentBuilder();
			
			//Le pasamos el XML
			
			Document doc = db.parse(arxXml);
			
			doc.getDocumentElement().normalize();
			
			System.out.println("Elemento raiz:" + doc.getDocumentElement().getNodeName());
			
			NodeList nodeList = doc.getElementsByTagName("coche");
			
			//Creamos un bucle para leer los datos del xml y los mostramos en la consola
			
			for (int itr = 0; itr < nodeList.getLength(); itr++) {
			Node node = (Node) nodeList.item(itr);
			
			if (node.getNodeType() == Node.ELEMENT_NODE){
				
			Element eElement = (Element) node;
			
			System.out.println("Marca: "+ eElement.getElementsByTagName("marca").item(0).getTextContent());
			System.out.println("Modelo: "+ eElement.getElementsByTagName("modelo").item(0).getTextContent());
			System.out.println("Color: "+ eElement.getElementsByTagName("color").item(0).getTextContent());
			System.out.println("Matriculacion: "+ eElement.getElementsByTagName("matriculacion").item(0).getTextContent());
			}
			}
			} catch (Exception e) {
			e.printStackTrace();
			}


	}

}
