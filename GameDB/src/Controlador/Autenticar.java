package Controlador;

public class Autenticar {
	private boolean isAuth=false;
	//por defecto el objeto se creará sin autenticar
	
	public Autenticar() {
		
	}
	
	// al llamar a este metodo nos devuelve el estado en el que está el objeto. True o False
	public boolean estaLogado(){
		return this.isAuth;
	}

	// al llamar a este metodo se modifica el objeto y se vuelve true, devuelve true= logeado
	public boolean comprobarUser(){
		this.isAuth=true;
		return this.isAuth;
	}
}
