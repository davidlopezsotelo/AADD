package metaDatos;

//https://www.youtube.com/watch?v=LUflNGme-d4&list=PLU8oAlHdN5BktAXdEVCLUYzvDyqRQJ2lk&index=223

import java.sql.*;

/*
 * ecceso a los metadatos de una base de datos
 * que nos indica los datos relativos a la base de datos
 */

public class Info_MetaDatos {

	public static void main(String[] args) {

		/*
		 * llamamos al metodo para mostrar la informacion
		 */
		//mostrarinfo_BBDD();
		
		mostrarInfo_Tablas();
		
	}
	
	/*
	 * creamos un metodo para acceder a la informacion
	 */
	
	static void mostrarinfo_BBDD() {
		
		//creamos conexion---------------------------------
		Connection miConexion=null;
		
		try {
			
			miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/m06","root","1234");
		
			//obtencion de metadatos:
			
			DatabaseMetaData datosBBDD=miConexion.getMetaData();
			
			//mostramos informacion de la base de datos
			
			System.out.println("Gestor de Base de Datos "+ datosBBDD.getDatabaseProductName());
			
			System.out.println("Version del gestor "+datosBBDD.getDatabaseProductVersion());
			
			System.out.println("Nombre del Driver "+datosBBDD.getDriverName()+" "+datosBBDD.getDriverVersion());
		} catch (SQLException e) {

			e.printStackTrace();
		}finally{
			try {
				miConexion.close();
			} catch (SQLException e) {
				// TODO Bloque catch generado automáticamente
				e.printStackTrace();
			}
			
		}
		
	}
	
	/*
	 * creamos otro metodo que nos de informacion
	 * de las tablas y lo almacenamos en un resultset
	 */

	static void mostrarInfo_Tablas() {
		
		//creamos conexion---------------------------------
		Connection miConexion=null;
		
		//creamos variable resultset
		
		ResultSet miResultSet=null;
		
		try {
			
			miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/m06","root","1234");
		
			//obtencion de metadatos:
			
			DatabaseMetaData datosBBDD=miConexion.getMetaData();
			
			//Lista de tablas
			
			System.out.println("Lista de tablas ");
			
			//hay que indicar en el primer parametro el nombre de la base de datos
			
			miResultSet=datosBBDD.getTables("m06", null, null, null);
			
			while(miResultSet.next()) {
				System.out.println(miResultSet.getString("TABLE_NAME"));
			}
			
			//lista de columnas 
			
			System.out.println("");
			System.out.println("Campos de alumnos: ");
			
			miResultSet=datosBBDD.getColumns("m06", null, "alumnos", null);
			
			while(miResultSet.next()) {
				System.out.println(miResultSet.getString("COLUMN_NAME"));
			}
			
			
		
		
		} catch (SQLException e) {
		// TODO Bloque catch generado automáticamente
		e.printStackTrace();
	}
	
}

}

