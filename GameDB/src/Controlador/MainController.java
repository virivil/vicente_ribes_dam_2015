package Controlador;

import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.Iterator;

import Controlador.MainController;
import Modelo.UsuariosModel;
import Modelo.ConexionDB;
import Vista.VistaApp;
import Vista.VistaJuegos;
import Vista.VistaPrin;

public class MainController {

	//Atributos de bases de datos

	final ConexionDB gameDB;
	
	//Instancia unica
		private static MainController instance = null;
		
		
	//Vistas
		VistaApp objetovistaapp;
		
	//Usuarios
		
		UsuariosModel usuarios;
		
	
	private MainController() {

	//Generamos el objeto gamedb para que se conecte a la bbdd que hemos creado previamente. Mediante el metodo le pasamos los datos
	gameDB=ConexionDB.getInstance("localhost","gamedb","root","grabemivida") ; //aquí la instanciamos=laconvertimos en objeto
	
	if(gameDB.connectDB()==true) {
		System.out.println("CONECTADOS CON EXITO");			
	}	
	else {System.out.println("ERROR EN LA CONEXION");
	}
	
	this.showVistaApp();
		
	}
	
	
	
	//Implementar SingleTon
		public static MainController getInstance() {
		      if(instance == null) {
		         instance = new MainController();
		      }
		      return instance;
		}
	
		//metodo al que llamamos para hacer crear la ventana
		public void showVistaApp(){
			usuarios=new UsuariosModel();
			
			//Lanzamos la ventana Vistaapp
			objetovistaapp= new VistaApp();
			objetovistaapp.setVisible(true);
			
		}
		
		//metodo al que llamamos para hacer visible el panel juegos
		public void showVistaJuegos(){
			
			objetovistaapp.ShowJuegos(true);
			
			/**CardLayout c=(CardLayout) VistaApp.CPPadre.getLayout();
			c.show( VistaApp.CPPadre , "paneljuegos");
				**/		
		}
		
		//metodo al que llamamos para hacer visible el panel VistaPrin
		public void showVistaPrin(){
			
			objetovistaapp.ShowPrin(true);
			//objetovistaapp.ShowPrin(true);
			
			
			
					
		}
		
       
}
