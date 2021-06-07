package GestionFicheros;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


//----------------CREACION DE UNA CLASE PARA LEER UN FICHERO----------------

class Leer_Buffer{
	
	public void leeBuffer() { 
		
		try {				
		              /*creamos instancia de la clase File Reader 
		            indicandole la ruta del archivo que queremos leer*/
			
			
			FileReader entrada = new FileReader("C:/Users/David/Desktop/carpetaAcceso/Texto_Largo.txt");
			
					// CREAMOS EL BUFFER
					 
			BufferedReader mibuffer =new BufferedReader(entrada);
			
				  //CREAMOS UNA VARIABLE linea, PARA LEER LAS LINEAS DEL TEXTO
		
		   String linea ="";
			
		           // recorrer con bucle while la variable linea
		           
			while (linea!=null)
			{

				linea=mibuffer.readLine();
				
				if(linea!=null)				
				System.out.println(linea);	
			}
			
		            //CERRAMOS EL STRING (obligatorio)
			
			entrada.close();
			
		} catch (IOException e) {
			
			System.out.println("archivo no encontrado.");
			
			e.printStackTrace();
		}	
	}
}

//-------------------------CLASE PRINCIPAL (MAIN)-----------------------


public class  LecturaBuffer{

	public static void main(String[] args) {

		        //Creamos instancia del metodo lee() de la clase Leer_Buffer:
		
		Leer_Buffer accediendo=new Leer_Buffer();
		
		          /*Utilizamos la variable de instancia "Accediendo" 
		               para llamar al metodo lee() de la clase:*/
		
		accediendo.leeBuffer();
		
		
	}
}
