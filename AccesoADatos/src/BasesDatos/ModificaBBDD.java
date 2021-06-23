package BasesDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ModificaBBDD {

	public static void main(String[] args) {


        String URL="jdbc:mysql://localhost:3306/m06?useSSL=false";
		
		String User="root";
		
		String Passs="root";
		

		try {
			
			System.out.println("Conectando con base de datos.");
			
			/*
			 * Creamos un objeto de tipo Connection para conectarnos a la base de datos.
			 * utilizando la clase DriverManager.
			 */
			Connection Conexion2=DriverManager.getConnection(URL, User, Passs);
			
			System.out.println("Conexion establecida con exito");
			
		//-----CREAMOS STATEMENT----------------------------
			
			Statement miStatement2 = Conexion2.createStatement();
			
			/*
			 * creamos una vaiable de tipo String,para indicar
			 * la instruccion sql.
			 */
		
			String instruccionSql="INSERT INTO ALUMNOS (idAlumno,nombre,edad)VALUES (10,'JOSE',58)";
			
			/*
			 * usamos el metodo executeUpdate de la intefaz statement
			 * para ejecutar sentencias sql.
			 */
			
			miStatement2.executeUpdate(instruccionSql);
			
			System.out.println("datos insertados");
			
		}catch(Exception e){
			
			System.out.println("no conecta...");
			
			e.printStackTrace();
			
		}
	}

}
