package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.ResultSetMetaData;


public class UsuariosModel {
	//Consulta que devuelve el nombre de usuarios
	
	private  static String USUARIOS_SEL="SELECT usuario FROM usuarios";	
	private  static String USUARIO_COL="usuario";
		
	//Conexion
	private Connection conexion = null;
	Statement instruccion = null;
	ResultSet conjuntoResultados = null;
	
	
	//declaro variable usuarios
	
	private ArrayList<String> objetousuarios = null;
	
	public UsuariosModel(){    
				//inicializamos el array de usuarios
		objetousuarios = new ArrayList<String>();
			}
	
	public UsuariosModel(Connection conexion){    
		this.conexion=conexion;
			}
	   
	
	
	public ArrayList getUsuarios(){   //METODO GET PARA OBTENER LOS USUARIO
		try{
			
			System.out.println("intenta mandar la query");

			//instruccion = this.conexion.createStatement(); //preparamos el canal para hacer ls preguntas
			
			System.out.println("intenta mandar la query2");

			
			conjuntoResultados = instruccion.executeQuery(USUARIOS_SEL); //realizamos la pregunta , la query

			//Listaremos por pantalla los datos
			while( conjuntoResultados.next() ) {
				
				System.out.print(conjuntoResultados.getString(USUARIO_COL)+";");
				
				
			}// fin de while
			return objetousuarios;
		}
		
		
		catch( SQLException excepcionSql ) 
		{
			excepcionSql.printStackTrace();
			return objetousuarios;

		}
		
		finally{
			try{
				System.out.println("Voy a cerrar la conexion");

				conjuntoResultados.close(); //cerramos conexion con la base de datos
				instruccion.close();
				conexion.close(); //él no cierra la conexión... 
			}
			catch( SQLException excepcionSql ) 
			{
				excepcionSql.printStackTrace();
			}
		}
		
		
	}
	
	
} //FINAL DE CLASE USUARIOSMODEL