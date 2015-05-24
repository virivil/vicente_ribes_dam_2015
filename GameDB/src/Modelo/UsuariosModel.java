package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.ResultSetMetaData;


public class UsuariosModel {
	//Consulta que devuelve el nombre de usuarios
	
	private  static String USUARIOS_SEL="SELECT usuario FROM usuarios";	// estos deben ser static final , constantes en  mayusculas!
	private  static String USUARIO_COL="usuario";
	ConexionDB cdb ;
		
	//Conexion
	private Connection conexion = null;
	Statement instruccion = null; // Instrucción de consulta 
	ResultSet conjuntoResultados = null;
	
	
	//declaro objetousuarios
	
	private ArrayList<String> objetousuarios = null;
	
	public UsuariosModel(){    
				//inicializamos el array de objetousuarios
		objetousuarios = new ArrayList<String>();
		cdb = ConexionDB.getInstance("localhost","gamedb","root","grabemivida"); 
		conexion = cdb.getConexion();
			}
	
	
	public UsuariosModel(Connection conexion){    
		this.conexion=conexion;
			}
	   
	
	
	public ArrayList getUsuarios(){   //METODO GET PARA OBTENER LOS USUARIO
		try{			
			instruccion = conexion.createStatement(); //prepara la conexion
			conjuntoResultados = instruccion.executeQuery(USUARIOS_SEL); //esta linea ejecuta la petición a la bbdd.
			objetousuarios.clear();
			//cargamos al objeto los datos
			
				while( conjuntoResultados.next() ) {
				objetousuarios.add(conjuntoResultados.getString(USUARIO_COL));
				}// fin de while
			

				return objetousuarios;

		}
		 
		
		catch( SQLException excepcionSql ) 
		{
			excepcionSql.printStackTrace();
			return objetousuarios;

		}
		
	}
	
	
} //FINAL DE CLASE USUARIOSMODEL