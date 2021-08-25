package GestionFicheros;

import java.io.FileWriter;
import java.io.IOException;

//----------------------------CLASE PARA ESCRIBIR EN FICHEROS---------------------

class Escribiendo{
	
	public void escribir() {
		
				/*declaracion de variable con texto para escribir
				 * dentro del fichero que seleccionemos
				 */
		String frase="Prueba de escritura.";
		
				/*Instanciamos la clase FileWriter.
				 * Para seleccionar el archivo donde queremos escribir
				 * le damos una ruta y un nombre de archivo.
				 * Si el archivo existe, lo sobreescrive
				 * si no ,lo crea.
				 */
		
		try {
			
			/*
			 * Si especificamos la ruta "src/..." se creara en la carpeta del proyecto 
			 * y asi sera portable cuando se exporte el proyecto
			 */
			
			FileWriter escritura=new FileWriter("src/Prueba_Escritura.txt");
			
			     /*Creamos un bucle for que recorra todos los caracteres de la frase 
			      * y los gurada dentro de una bariable i
			      */
			
			for (int i=0;i<frase.length();i++) 
			{
			
					/*
					 * usamos el metodo Write para escribir dentro del
					 * archivo "escritura", los caracteres almacenados en
					 * la variable "i",de la variable "frase".
					 */
				
				escritura.write(frase.charAt(i));  // metodo de la clase String.
				
			}
			
			escritura.close();  //CERRAMOS EL STRING
			
		} catch (IOException e) {
			
			System.out.println("no se ha podido escribir en el archivo.");

			e.printStackTrace();
		}
		
	}
	
}


//------------------------------CLASE PRINCIPAL (MAIN)--------------------------------

public class Escribir_Fichero {

	public static void main(String[] args) {
		
		/*
		 * INSTANCIAMOS EL METODO escribir DE LA CLASE Escribiendo
		 */
		
		
		Escribiendo escritura =new Escribiendo();
		
		escritura.escribir();

	}

}
