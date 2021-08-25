package BasesDatos;

import java.sql.*;


//https://www.youtube.com/watch?v=OOWg6m1B7uo&list=PLU8oAlHdN5BktAXdEVCLUYzvDyqRQJ2lk&index=205&t=267s


public class ConsultaPreparada {
	
	//base de datos : m06
	//clave de base de datos = root

	public static void main(String[] args) {
		
		System.out.println("Conectando con base de datos.");

		try {
			
			//1. CREAR CONEXION--------------------------------
			
			
			
			String URL="jdbc:mysql://localhost:3306/m06?useSSL=false";	
		    String User="root";
		    String Passs="root";
						
			Connection miConexion=DriverManager.getConnection(URL, User, Passs);
			
			
			//2.PREPARAR CONSULTA--------------------------------
			
			/*
			 * preparamos una consulta de la tabla alunmos
			 * en la base de datos
			 */
			
			String sql="SELECT idAlumno,nombre,edad FROM alumnos WHERE nacionalidad=? AND sexo =?";
			
			PreparedStatement miSentencia=miConexion.prepareStatement(sql);
			
			
			//3.ESTABLECER LOS PARAMETROS DE CONSULTA
			
			/*
			 * en el metodo setString le indicamos en primer lugar
			 * el numero del parametro y despues el nombre de la columna 
			 */
			
			miSentencia.setString(1, "Espaniola");
			
			miSentencia.setString(2, "Hombre");
			
			//4.EJECUTAR Y RECORRER LA CONSULTA.
			
			/*
			 * creamos un objeto de tipo resulset
			 */
			
			ResultSet rs=miSentencia.executeQuery();
			/*
			 * recorremos el resulset
			 */
			
			while (rs.next()) {
				
				/*
				 * tenemos que añadir tantos  getString
				 *  como columnas tenga la tabla que queremos consultar
				 */
				
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
			}
			
			//CERRAMOS EL RESULSET
			
			System.out.println("consulta terminada");
			
			rs.close();
			
		} catch (SQLException e) {
			
			
			e.printStackTrace();
		}
		
	}

}
//revisar, no funciona??????

