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

	//public Autenticar auth;

	private ConexionDB gameDB;
	
	//Instancia unica
		private static MainController instance = null;
		
		
	//Vistas
	private	VistaApp objetovistaapp;
		
	//Usuarios
		
		UsuariosModel usuarios;
		JuegosModel juegos;
	
	//autenticacion
		public Autenticar auth = new Autenticar();

	
	private MainController() {
		//acabamos de instanciar MainController mediante metodo privado gracias a Singleton
		
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
			
			//Lanzamos la ventana Vistaapp

			objetovistaapp=  VistaApp.getInstance();	
			
			
			// creamos el objeto usuarios de la case UsuariosModel

			usuarios=new UsuariosModel();
			
			// creamos el objeto juegos de la clase JuegosModel

			juegos= new JuegosModel();
			
			
			//hacemos visible por defecto solo puede haber una entrada show

			objetovistaapp.setVisible(true);
			
			//llamamos a showVistaPrin
			
								//auth = new Autenticar();
			this.showVistaPrin();
			
		}
		
		
		
		
		//metodo al que llamamos para hacer visible el panel VistaPrin
		public void showVistaPrin(){
			//en el metodo showVistaPrin,lanzamos metodo de objetovistaapp

			objetovistaapp.CargaPanelPrin(this.CargarUsuarios());

		}
		

		
		
		//metodo al que llamamos para hacer visible el panel juegos
		public void showVistaJuegos(){
			
			//en el metodo showVistaJuegos,lanzamos metodo de objetovistajuegos
			if (this.auth.estaLogado()){
				objetovistaapp.CargaPanelJuegos(this.CargarJuegos());
				objetovistaapp.MensajePorConsola("Sesión iniciada");

			} else {
				
				//aquí mensaje de error por pantalla
				objetovistaapp.MensajePorConsola("Debes logearte antes");
			};
		}



		public void logar() {
			this.auth.comprobarUser();
			objetovistaapp.MensajePorConsola("logeado!");

		}
	
		
       
}
