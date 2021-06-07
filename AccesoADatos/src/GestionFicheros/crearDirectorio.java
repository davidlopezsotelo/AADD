package GestionFicheros;

import java.io.File;
import java.io.FileWriter;
import javax.swing.JOptionPane;

/**
 * esta clase construye directorios
 * @author David
 *
 */

public class crearDirectorio {

	public static void main(String[] args) {
		
		String nDirectorio=JOptionPane.showInputDialog("introduce el nombre del directorio");
		String nArchivo=JOptionPane.showInputDialog("Introduce el nombre del archivo");
		String frase=JOptionPane.showInputDialog("Introduce el texto");
		
	
	//CREA DIRECTORIO EN UNA CARPETA ESPECIFICA:
		
		File directorio=new File("C:"+File.separator+"Users"+File.separator+"David"+
		File.separator+"Desktop"+File.separator+"carpetaAcceso" + File.separator + nDirectorio);
		
		directorio.mkdirs();
		
		System.out.println("el Directorio :'"+nDirectorio+"' , se ha creado.");
		
   // CREACION DE ARCHIVO 
		
		File ruta_archivo=new File("C:"+File.separator+"Users"+File.separator+"David"+
		File.separator+"Desktop"+File.separator+"carpetaAcceso" + File.separator + nDirectorio
		+File.separator+nArchivo+".txt");
		
	
		try {
			
			ruta_archivo.createNewFile();
			
			//Escritura
			
			FileWriter escritura=new FileWriter("C:"+File.separator+"Users"+File.separator+"David"+
					File.separator+"Desktop"+File.separator+"carpetaAcceso" + File.separator + nDirectorio
					+File.separator+nArchivo+".txt",true);
			
			for (int i=0;i<frase.length();i++) {
				
				escritura.write(frase.charAt(i));
			}
			escritura.close();
			
			System.out.println("El archivo :'"+nArchivo+"' , se ha escrito correctamente");
			
		}catch(Exception e) {
			
		}
		
		//COMPROVAR RUTA:
		
		
		// imprimimos la ruta en consola:
		
		System.out.println("La ruta del archivo creado es: "+ruta_archivo.getAbsolutePath());

		//CREAMOS UN MENSAJE EN PANTALLA QUE DA LA INFORMACION SOBRE 
		//LA RUTA DEL ARCHIVO CREADO
		
		JOptionPane.showMessageDialog(null, "La ruta del archivo creado es: "+ruta_archivo.getAbsolutePath());
	}

}
