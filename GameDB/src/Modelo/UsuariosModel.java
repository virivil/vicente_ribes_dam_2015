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
	ConexionDB cdb ;
		
	//Conexion
	private Connection conexion = null;
	Statement instruccion = null; // Instrucción de consulta ???
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
			
			System.out.println("realiza el try1");
				
					
				//instruccion = ConexionDB.getConexion(); //prepara la conexion
			instruccion = conexion.createStatement(); //prepara la conexion

	
			System.out.println("realiza el try2");

				conjuntoResultados = instruccion.executeQuery(USUARIOS_SEL); //esta linea ejecuta la petición a la bbdd.

			System.out.println("realiza el try3");

				//Listaremos por pantalla los datos
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
		
		finally{
			System.out.println(" llega al finally");


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