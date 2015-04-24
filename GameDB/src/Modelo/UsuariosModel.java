package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.mysql.jdbc.ResultSetMetaData;


public class UsuariosModel {
	//DConsulta que devuelve el nombre de usuarios
	
	private  String USUARIOS_SEL="SELECT * FROM usuarios";	
	private  String USUARIO_COL="usuario";
		
	//Conexion
	private Connection conexion = null;// maneja la conexión
	Statement instruccion = null;
	ResultSet conjuntoResultados = null;
	
	
	//declaro variable usuarios
	
	private ArrayList<String> objetousuarios = null;
	
	public UsuariosModel(){    //no tengo muy clara la dif entre static y non-static , los metodos estaticos pueden ser llamados sin instaciarlo(hacerlos objeto)
		
		//Obtenemos la conexion de datos
		
		
		conexion = ConexionDB.getConexion(); // he aquí el error !!!

		//inicializamos el array de usuarios
		objetousuarios = new ArrayList<String>();
			}
	
	
	
	
			/** public void getDatosUsuarios(){   //METODO GET PARA OBTENER TODAS LAS COLUMNAS
				try{
					instruccion = this.conexion.createStatement(); //preparamos el canal para hacer ls preguntas
					conjuntoResultados = instruccion.executeQuery(USUARIOS_LIST); //realizamos la pregunta , la query
		
					//Listaremos por pantalla los datos
					while( conjuntoResultados.next() ) {
						System.out.print(conjuntoResultados.getInt(ID_COL)+";");
						System.out.print(conjuntoResultados.getString(USUARIO_COL)+";");
						System.out.print(conjuntoResultados.getString(PASS_COL)+";");
						System.out.println(conjuntoResultados.getTime(NOMBRE_COL));
					}// fin de while
				}
				catch( SQLException excepcionSql ) 
				{
					excepcionSql.printStackTrace();
				}
				finally{
					try{
						conjuntoResultados.close(); //cerramos conexion con la base de datos
						instruccion.close();
						conexion.close();
					}
					catch( SQLException excepcionSql ) 
					{
						excepcionSql.printStackTrace();
					}
				}
				
				
			}
			
			**/
	
	public ArrayList getUsuarios(){   //METODO GET PARA OBTENER LOS USUARIO
		try{
			instruccion = this.conexion.createStatement(); //preparamos el canal para hacer ls preguntas
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