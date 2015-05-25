package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class JuegosModel {
	
	//Consulta que devuelve el nombre de usuarios
	
		private  static String GAMES_SEL="SELECT * FROM juegos";	// estos deben ser static final , constantes en  mayusculas!
		private  static String ID_COL="id";
		private  static String NAME_COL="nombre";
		private  static String GENRE_COL="genero";
		private  static String PLATFORM_COL="plataforma";
		private  static String DESCRIPTION_COL="descripcion";
		



		ConexionDB cdb ;
			
		//Conexion 
		private Connection conexion = null;
		Statement instruccion = null; // Instrucción de consulta 
		ResultSet conjuntoResultados = null;
		
		
		//declaro juegos
		
		private ArrayList<Game> juegos = null;
		
		public JuegosModel(){     
					//inicializamos el array de juegos
			juegos = new ArrayList<Game>();
			cdb = ConexionDB.getInstance("localhost","gamedb","root","grabemivida"); 
			conexion = cdb.getConexion();
				}
		
		
		public JuegosModel(Connection conexion){    
			this.conexion=conexion;
				}
		   
		
		
		public ArrayList getJuegos(){   //METODO GET PARA OBTENER LOS Juegos
			try{			
				instruccion = conexion.createStatement(); //prepara la conexion
				conjuntoResultados = instruccion.executeQuery(GAMES_SEL); //esta linea ejecuta la petición a la bbdd.
				
				juegos.clear(); //este metodo hará que no se vuelva a cargar al volver a la ventana
				
					//cargamos al objeto los datos
				
					while( conjuntoResultados.next() ) {
						Game game=new Game(
					conjuntoResultados.getInt(ID_COL),
					conjuntoResultados.getString(NAME_COL),
					conjuntoResultados.getString(GENRE_COL),
					conjuntoResultados.getString(PLATFORM_COL),
					conjuntoResultados.getString(DESCRIPTION_COL));
						juegos.add(game);

					}// fin de while
					

					return juegos;

			}
			 
			
			catch( SQLException excepcionSql ) 
			{
				excepcionSql.printStackTrace();
				return juegos;

			}
			
		}
		

}
