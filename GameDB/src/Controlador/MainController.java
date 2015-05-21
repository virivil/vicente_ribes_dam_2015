package Controlador;

import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.Iterator;

import Controlador.MainController;
import Modelo.Game;
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
		JuegosModel juegos;
	
	
	private MainController() {
		System.out.println("acabamos de instanciar MainController");
		
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
			System.out.println("cargamos usuarios");

			UsuariosModel cargadeusuarios = new UsuariosModel();
			Iterator<String> it= cargadeusuarios.getUsuarios().iterator();
		return it; }
		
		
		public ArrayList<Game> CargarJuegos(){		
			System.out.println("cargamos usuarios");
			
			JuegosModel cargadejuegos = new JuegosModel();
			ArrayList<Game> it2= cargadejuegos.getJuegos();
		return it2; }
		
		
		//metodo al que llamamos para crear la ventana principal
		public void showVistaApp(){
			System.out.println("comienza metodo showVistaApp");

			
			//Lanzamos la ventana Vistaapp
			
			System.out.println("creamos el objetovistaapp");

			objetovistaapp= new VistaApp();	
			
			
			System.out.println("creamos el objeto UsuariosModelo");

			usuarios=new UsuariosModel();
			
			System.out.println("creamos el objeto juegos");

			juegos= new JuegosModel();
			
			
			//la hacemos visible, por defecto solo puede haber una entrada show, el resto de show serán por listeners. 

			objetovistaapp.setVisible(true);
			
			System.out.println("llamamos a showVistaPrin");

			this.showVistaPrin();
			
			
		}
		
		
		
		
		//metodo al que llamamos para hacer visible el panel VistaPrin
		public void showVistaPrin(){
			System.out.println("en el metodo showVistaPrin,lanzamos metodo de objetovistaapp");

			objetovistaapp.ShowPrin(this.CargarUsuarios());
		
		}
		

		
		
		//metodo al que llamamos para hacer visible el panel juegos
		public void showVistaJuegos(){
			System.out.println("en el metodo showVistaJuegos,lanzamos metodo de objetovistajuegos");

			
			objetovistaapp.ShowJuegos(this.CargarJuegos());

		}
	
       
}
