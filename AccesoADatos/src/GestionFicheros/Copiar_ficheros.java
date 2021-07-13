package GestionFicheros;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Copiar_ficheros {

	public static void main(String[] args) {
		
		/*
		 * copiamos la ruta del archivo que queremos copiar
		 */
		
		String RutaOrigen="‪‪src/origen.txt";
		
		
		//seleccionamos la ruta de destino
		
		String RutaDestino="src/destino.txt";
		
		Path origen=Paths.get(RutaOrigen);
		
		try {
			Path ejemploOrigen=Files.createFile(origen);
			
		} catch (IOException e) {
			
			// TODO Bloque catch generado automáticamente
			
			e.printStackTrace();
		}
		
		Path destino=Paths.get(RutaDestino);
		
		try {
			Path ejemploDestino=Files.createFile(destino);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		try {
			Files.copy(origen, destino, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
	}
}

	

