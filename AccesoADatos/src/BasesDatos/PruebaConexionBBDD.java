package BasesDatos;

import java.sql.Connection;
import java.sql.DriverManager;

public class PruebaConexionBBDD {

	public static void main(String[] args) {
		
		String URL="jdbc:mysql://localhost:3306/m06?useSSL=false";
		
		String User="root";
		
		String Passs="1234";
		

		try {
			
			System.out.println("Conectando con base de datos.");
			
			Connection Conexion=DriverManager.getConnection(URL, User, Passs);
			
			System.out.println("Conexion establecida con exito");
			
		}catch(Exception e){
			
			System.out.println("no conecta...");
			
			e.printStackTrace();
			
		}
	}

}
