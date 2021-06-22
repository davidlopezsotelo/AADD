package GestionFicheros;

import java.io.*;

/*
 * EJEMPLOS DE COMO ACCEDER Y RECORRER EL CONTENIDO DE CARPETAS Y ARCHIVOS-----------
 */


public class Pruebas_Path {

	public static void main(String[] args) {


		File archivo =new File("ejemplo_archivo");//tomo como ruta la carpeta que estamos usando(AccesoADatos)
	
		//Imprimir ruta absoltu del archivo
		
		System.out.println(archivo.getAbsolutePath());
		
		//comprobar si existe el archivo "ejemplo archivo"
		
		System.out.println(archivo.exists());
		
		
		//comprobamos existencia de un directorio en la carpeta actual
		
		File dir =new File("bin");
		
		System.out.println(dir.getAbsolutePath());
		
		
		/*
		 * acceder al contenido de una carpeta
		 * especifica.
		 * puede variar segun la maquina donde se ejecute
		 */
		
		File ruta =new File("C:\\Users\\David-Pc\\git\\AADD\\AccesoADatos");
		
		System.out.println(ruta.getAbsolutePath());
		
		//creamos un array para almacenar la informacion de la carpeta
		//usamos el metodo list, que devuelve un array
		
		String [] nombres_archivos=ruta.list();
		
		//recorremos con un bucle for el array
		
		for(int i=0;i<nombres_archivos.length;i++) {
			
			//imprimimos la informacion del array
			
			System.out.println(nombres_archivos[i]);
			
			/*
			 * comprobar si lo que examinamos es un directorio
			 * en caso afirmativo, el bucle for, entra en el directorio
			 * y nos imprime el contenido
			 */
			
			File f=new File(ruta.getAbsolutePath(),nombres_archivos[i]);
			
			//comprovamos si f, es un archivo o un directorio
			
			/*
			 * en caso de que sea un directorio, le decimos al programa
			 * que entre y nos liste el contenido
			 * de la misma forma que antes
			 * utilizando un bucle for
			 */
			
			if(f.isDirectory()) {   //si f es un directorio...
				
				//creamos el array que guarda la informacion
				
				String[] archivos_subcarpeta=f.list();
				
				// imprimimos la informacion del array
				
				for(int j=0;j<archivos_subcarpeta.length;j++) {
					
					System.out.println(archivos_subcarpeta[j]);
					
				}
			}
		}
		
	}

}
