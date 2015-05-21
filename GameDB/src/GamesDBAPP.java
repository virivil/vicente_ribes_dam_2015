//Importamos clases de otros paquetes

import java.util.ArrayList;

import Controlador.MainController;
import Modelo.ConexionDB;
import Modelo.UsuariosModel;
import Vista.VistaPrin; 
import Vista.VistaApp; 

public class GamesDBAPP {

	

	
	public static void main(String[] args) {
		
		System.out.println("gamesdbapp llama a maincontroller");

		//Arrancamos el controlador
			MainController mController=MainController.getInstance();
			
			System.out.println("hemos vuelto a gamesdbapp");
	
	}

}
