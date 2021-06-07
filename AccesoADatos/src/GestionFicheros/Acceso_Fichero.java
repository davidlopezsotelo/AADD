package GestionFicheros;

import java.io.FileReader;
import java.io.IOException;


//----------------CREACION DE UNA CLASE PARA LEER UN FICHERO----------------

class Leer_Fichero{
	
	public void lee() { 
		
		try {				
		              /*creamos instancia de la clase File Reader
		            indicandole la ruta del archivo que queremos leer*/
			
			FileReader entrada = new FileReader("C:/Users/David/Desktop/carpetaAcceso/TextoPrueba.txt");
		
		           //creamos una variable "c", para almacenar el contenido del archivo	
			
			int c=0;    // si no la igualamos a 0, en el bucle while no leera el primer caracter
			
		           /* recorrer con bucle while la variable c, para imprimir
		                 los caracteres guradados el la variable c.
		                 usamos el metodo read() para leer el archivo  */
			
			while (c!=-1)
			{
				c=entrada.read();
				
				   /*creamos variable haciendo casting para imprimir la informacion
				       como caracterers (letras)*/
				
				char letra=(char)c;
				System.out.print(letra);	
			}
			
		            //CERRAMOS EL FILEREADER (obligatorio)
			
			entrada.close();
			
		} catch (IOException e) {//cambiar a IOException
			
			System.out.println("archivo no encontrado.");
			e.printStackTrace();
		}	
	}
}

//-------------------------CLASE PRINCIPAL (MAIN)-----------------------


public class Acceso_Fichero {

	public static void main(String[] args) {

		        //Creamos instancia del metodo lee() de la clase Leer_Fichero:
		
		Leer_Fichero accediendo=new Leer_Fichero();
		
		          /*Utilizamos la variable de instancia "Accediendo" 
		               para llamar al metodo lee() de la clase:*/
		
		accediendo.lee();
	}
}


