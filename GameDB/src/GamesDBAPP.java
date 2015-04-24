//Importamos clases de otros paquetes

import java.util.ArrayList;

import Modelo.ConexionDB;
import Modelo.UsuariosModel;
import Vista.VistaPrincipal; 
import Vista.VistaApp; 

public class GamesDBAPP {

	public static void main(String[] args) {
		
		//establaciendo la conexion a la base de datos//es decir, creamos una variable de tipo ConexionDB
		ConexionDB gameDB;
		
		
		//Lanzamos la ventana Vistaapp
		VistaApp primerobjeto= new VistaApp();
		primerobjeto.setVisible(true);
		
		//Generamos el objeto gamedb para que se conecte a la bbdd que hemos creado previamente. Mediante el metodo le pasamos los datos
		gameDB=new ConexionDB("localhost","gamedb","root","grabemivida") ; //aquí la instanciamos=laconvertimos en objeto
		
		if(gameDB.connectDB()==true) {
			System.out.println("CONECTADOS CON EXITO");

		
		
		}
			
		else {System.out.println("ERROR EN LA CONEXION");
		}
		

		
	}

	
	
	
}
