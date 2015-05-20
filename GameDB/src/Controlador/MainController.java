package Controlador;

import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.Iterator;

import Controlador.MainController;
import Modelo.JuegosModel;
import Modelo.UsuariosModel;
import Modelo.ConexionDB;
import Vista.VistaApp;
import Vista.VistaJuegos;
import Vista.VistaPrin;

public class MainController {

	//Atributos de bases de datos

	private ConexionDB gameDB;
	
	//Instancia unica
		private static MainController instance = null;
		
		
	//Vistas
	private	VistaApp objetovistaapp;
		
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
	
		
		public Iterator<String> CargarUsuarios(){		
			UsuariosModel cargadeusuarios = new UsuariosModel();
			Iterator<String> it= cargadeusuarios.getUsuarios().iterator();
		return it; }
		
		
		public Iterator<String> CargarJuegos(){		
			JuegosModel cargadejuegos = new JuegosModel();
			Iterator<String> it= cargadejuegos.getJuegos().iterator();
		return it; }
		
		
		//metodo al que llamamos para crear la ventana principal
		public void showVistaApp(){
			
			//Lanzamos la ventana Vistaapp
			objetovistaapp= new VistaApp();			
			usuarios=new UsuariosModel();
			
			//la hacemos visible
			objetovistaapp.setVisible(true);
			this.showVistaPrin();
		}
		
		
		
		
		//metodo al que llamamos para hacer visible el panel juegos
		public void showVistaJuegos(){
			
			objetovistaapp.ShowJuegos(this.CargarJuegos());
			
		}
		
		
		//metodo al que llamamos para hacer visible el panel VistaPrin
		public void showVistaPrin(){
			
			objetovistaapp.ShowPrin(this.CargarUsuarios());
			//objetovistaapp.ShowPrin(true);
		
		}
		
	
       
}
