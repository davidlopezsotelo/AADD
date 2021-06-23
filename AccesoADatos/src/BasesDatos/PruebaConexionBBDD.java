package BasesDatos;

import java.sql.*;



public class PruebaConexionBBDD {

	public static void main(String[] args) {
		
		//----PRIMER PASO: CONECTARSE A LA BASE DE DATOS---------------------------------------------------
		
		String URL="jdbc:mysql://localhost:3306/m06?useSSL=false";
		
		String User="root";
		
		String Passs="root";
		

		try {
			
			System.out.println("Conectando con base de datos.");
			
			/*
			 * Creamos un objeto de tipo Connection para conectarnos a la base de datos.
			 * utilizando la clase DriverManager.
			 */
			Connection Conexion=DriverManager.getConnection(URL, User, Passs);
			
			System.out.println("Conexion establecida con exito");
			
		//-------SEGUNDO PASO: CREAR OBJETO STATEMENT---------------
			
			
			/*
			 * Un objeto statement es el que permite ejecutar sentecias SQL.
			 */
			
			Statement miStatement = Conexion.createStatement();
			
		//-----TERCER PASO: EJECUTAR SENTENCIA SQL:
			
			/*
			 * Usamos el metodo ExecuteQuery, que nos devolverá
			 * un objeto de tipo resulset.
			 */
					
			ResultSet miResulset=miStatement.executeQuery("SELECT*FROM alumnos");
			
		//----CUARTO PASO:RECORRER EL RESULSET.--------------------
			
			/*
			 * utilizaremos un bucle while, para recorrerlo.
			 */
			
			while(miResulset.next()) {//mientras halla un siguiente registro en la tabla...
				
				/*
				 * le pedimos que nos imprima en consola los resultados
				 * de las tablas que le indiquemos, que tiene almacenadas en
				 * el resultset.
				 */
				
                                             //nombre de la columna				
				System.out.println(miResulset.getString("idAlumno")+ " "+ miResulset.getString("nombre")+ " "+ miResulset.getString("edad"));
				
				
			}
			
			
		}catch(Exception e){
			
			System.out.println("no conecta...");
			
			e.printStackTrace();
			
		}
		
		
	}

}
