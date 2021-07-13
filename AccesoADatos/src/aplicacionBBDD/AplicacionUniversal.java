package aplicacionBBDD;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;
/*
 * Creacion de una aplicacion java, que puede acceder
 * a cualquier base de datos que le indiquemos
 * y mostrar su contenido
 * 
 */
public class AplicacionUniversal {

	public static void main(String[] args) {
		
		JFrame mimarco=new MarcoBBDD();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mimarco.setVisible(true);
		

	}

}

/*
 * creamos el MARCO----------------------------------------------------------------
 */

class MarcoBBDD extends JFrame{
	
	public MarcoBBDD(){
		
		setTitle ("Consulta BBDD");
		
		setBounds(500,300,400,400);
		
		LaminaBBDD miLamina=new LaminaBBDD();
		
		add(miLamina);

		

		}
	}

/*
 * Creamos la LAMINA------------------------------------------------------------
 */
class LaminaBBDD extends JPanel{
	
	public LaminaBBDD () {
		
		setLayout(new BorderLayout());
		
		comboTablas=new JComboBox();
		
		areaInformacion=new JTextArea();
		
		add(areaInformacion,BorderLayout.CENTER);
		
		/*
		 * llamamos a los metodos
		 */
		
		conectarBBDD();
		
		obtenerTablas();
		
		
		
		//hacemos que combotablas responda a eventos
		
		comboTablas.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				/*
				 * almacenamos en una variable, haciendo un casting
				 * del elemento que seleccionemos en el combobox,combotablas,
				 * convertido en un string
				 */
				
				String nombreTabla=(String)comboTablas.getSelectedItem();
				
				mostrarInfoTabla(nombreTabla);
				
			}
			
		});
		
		add(comboTablas,BorderLayout.NORTH);
		
	}
	
	/*
	 * creamos un metodo que mostrara la informacion
	 * de la tabla seleccionada, recibiendo la tabla por parametro
	 */
	
	public void mostrarInfoTabla(String tabla) {
		
		//guardamos los campos dentro de un ArrayList
		
		ArrayList<String> campos=new ArrayList<String>();
		
		//almacenamos la consulta SQL en una variable String
		
		String consulta="SELECT*FROM " + tabla;
		
		//consultamos la informacion de la tabla
		
		try {
			
			//establecemos la conexion
			Statement miStatement =miConexion.createStatement();
			
			ResultSet miResultSet=miStatement.executeQuery(consulta);
			
			//reseteamos el area de texto para borrar texto de anteriores consultas
			
			areaInformacion.setText("");
			
			//obtenemos los metadatos del resultset
			
			ResultSetMetaData rsBBDD=miResultSet.getMetaData();
			
			/*
			 * creamos un bucle for, para recorrer los campos del resultset
			 */
			
			for(int i=1;i<rsBBDD.getColumnCount();i++) {
				
				//utilizamos el arraylist para almacenar el nombre de los campos
				
				campos.add(rsBBDD.getColumnLabel(i));
				
			}
			
			/*
			 * extraemos los nombres de los campos 
			 * recorriendo el resultset
			 */
			
			while(miResultSet.next())
			{
				/*
				 * devemos recorrer el arraylist con un bucle foreach
				 */
				
				for(String nombreCampo:campos) {
					
					//agregar al area de texto el nombre de los campos
					
					areaInformacion.append(miResultSet.getString(nombreCampo)+ " ");
					
				}
				
				areaInformacion.append("\n");
				
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/*
	 * creamos las variables fuera para que tengan
	 * ambito de clase
	 */
	
	private JComboBox comboTablas;
	
	private JTextArea areaInformacion;
	
	//creamos variable para conectar con bases de datos
	
	private Connection miConexion;
	
	//creamos el metodo de conexion---------------------
	
	public void conectarBBDD() {
		
		miConexion=null;
		
		
		try {
			
			miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/m06","root","1234");
		
			
		
	}catch(Exception e) {
		e.printStackTrace();
	}
	
  }
	
	/*
	 * creamos un metodo que cargue los JCombobox
	 * con todas las tablas de la base de datos--------------
	 */
	
	public void obtenerTablas(){
		/*
		 * creamos una variable ResultSet
		 * donde se almacenaran las tablas
		 */
		ResultSet miResultSet=null;
		
		/*
		 * construimos un objeto metadata??
		 */
		
		try {
		
			DatabaseMetaData datosBBDD=miConexion.getMetaData();
			
			/*
			 * almacenamos en el resulset los datos obtenidos mediante
			 * el objeto datosBBD, de tipo  MetaData.
			 * 
			 * Hay que indicar en el primer parametro el nombre
			 * de la base de datos
			 */
			
			miResultSet=datosBBDD.getTables("m06", null, null, null);
			
			/*
			 * recorremos el resulset para quie nos carege el 
			 * JCombobox con lo que obtenga
			 */
			
			while(miResultSet.next()) {
				
				comboTablas.addItem(miResultSet.getString("TABLE_NAME"));
			}
			
			
		}catch(Exception e){
		e.printStackTrace();
		}
		
	}
	
}
		
		
