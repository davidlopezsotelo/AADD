package Leyendo_escribiendo_bytes;

import java.io.*;


public class Lectura_escritura {

	public static void main(String[] args) {

				//creamos una variable contador que luego utilizaremos
		
		int contador =0;
		
				/*
				 * creamos un array para guardar los bytes
				 */
		

		int datos_entrada[]=new int[86578]; // la longitud del array sera igual al nº de bytes del archivo
		
		
				//	leemos el archivo de bytes de origen
		
		try {
			
				//creamos variable con ruta del archivo
			
			FileInputStream archivo_lectura=new FileInputStream("C:\\Users\\David\\Desktop\\carpetaAcceso\\origen\\gato.jpg");
			
				//creamos una variable para indicar el final del archivo
			
			boolean final_ar=false;
			
			while(!final_ar)
			{
			
					/*
					 * Creamos una variable para guardar los datos
					 * que leemos del archivo en forma de bytes,
					 * que esta en la ruta especificada
					 */
				
				
				int byte_entrada=archivo_lectura.read();
				
				   /*
				    * le indicamos que cuando llege al final del
				    * archivo que esta leyendo (-1)
				    * cambie el valor a true de la anterior variable
				    * indicando que el archivo ha finalizado
				    */
				
				if(byte_entrada!=-1) 
				
				
					datos_entrada[contador]=byte_entrada;//rellenamos el array
				
				
				else final_ar=true;
				
					/*
					 * impriminos las posiciones del array
					 */
				
				System.out.println(datos_entrada[contador]);
				
					/*incrementamos la variable contador
					 * a cada buelta del bucle while 
					 */

				contador++;

			}
			
				/*
				 * Eclipse no puede imprimir todos los bytes.
				 *
				 * para saber cuantos bytes tiene el archivo
				 * creamos una variable contador
				 */
			
			
				//CERRAMOS EL STRING
			
			archivo_lectura.close();
			
		}catch(IOException e){
			
		}
		/*
		 * Eclipse no puede imprimir todos los bytes.
		 *
		 * para saber cuantos bytes tiene el archivo
		 * creamos una variable contador para saber cuantos bytes
		 * tiene el archivo, al finalizar le decimos que nos
		 * imprima el numero de bytes
		 */
		System.out.println("El archivo contiene "+contador+" bytes");
		
		
		/*
		 * LLAMAMOS AL METODO CREA_FICHERO.
		 * el cual copia los datos y los ecribre en otro fichero
		 * y le pasamos por parametro la variable en la que hemos 
		 * almacenado el array de datos 
		 * que queremos copiar
		 */
		
		crea_fichero(datos_entrada);
		

	}
	
	/*
	 * Metodo que copia el contenido del array [], que pasamos por parametro
	 * en otro fichero, sobreescribiendolo
	 */
	
	static void crea_fichero(int datos_nuevo_fichero[]) {
		
		
		try {
			
					//indicamos ruta del archivo de destino
			
			FileOutputStream fichero_destino=new FileOutputStream("C:\\Users\\David\\Desktop\\carpetaAcceso\\destino\\copia2.jpg");
			
				/*
				 * leemos el array mediante un bucle for
				 */
			
			for(int i=0;i<datos_nuevo_fichero.length;i++) {
				
				fichero_destino.write(datos_nuevo_fichero[i]);
			}
			
			fichero_destino.close();
		
		
	}catch(IOException e) {
		System.out.println("No se ha podido copiar el archivo.");
	}

}
}
