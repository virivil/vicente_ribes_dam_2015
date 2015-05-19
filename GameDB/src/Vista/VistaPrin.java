package Vista;

import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import Controlador.MainController;
import Modelo.UsuariosModel;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VistaPrin extends JPanel {

	
	//agrupo las variables/atributos
	

	private JPasswordField passwordfield;
	private JComboBox cmbUsuario;
	
	


	
	//metodo constructor (de entrada)  a la Vista Prin(panel)
	public  VistaPrin() {
				setLayout(null);
				
				JButton btnPerfil = new JButton("Perfil >");
				btnPerfil.setBounds(270, 96, 113, 29);
				add(btnPerfil);
				
				JButton btnLogin = new JButton("Login");
				btnLogin.setBounds(32, 319, 79, 29);
				add(btnLogin);
				
				JButton btnRegistrar = new JButton("Registrar");
				btnRegistrar.setBounds(109, 319, 100, 29);
				add(btnRegistrar);
				
				//combobox
				
				
				cmbUsuario = new JComboBox();
				cmbUsuario.setBounds(22, 244, 187, 27);
				add(cmbUsuario);
				cmbUsuario.setToolTipText("Usuario");
				
				//llama a un metodo para que carge los usuarios.
				/** 
				 * Para cargar los usuarios lo que hace es ; 
				 * 1. Crea objeto cargausuarios del tipo UsuariosModel ()
				 * 2. Utiliza metodo get usuarios del objeto creado previamente y se lo introduce en un Iterator llamado IT
				 * 3. Comienza el proceso de carga. 
				 * 4. utiliza un while ... mientras siga habiendo un siguiente en IT , añadelo.
				 * 
				 * la nueva opción debería ser:
				 * 
				 * 1. VistaPrin llama a un metodo de MainController que cree un objeto del tipo UsuariosModelo
				 * 2. Utiliza metodo get usuarios del objeto creado previamente y se lo introduce en un Iterator llamado IT
				 * 
				 * 
				 * 
				 * 
				 **/

				/**UsuariosModel cargadeusuarios = new UsuariosModel();
				Iterator<String> it= cargadeusuarios.getUsuarios().iterator();
				**/	
					
			
			/**	MainController Objetocarga = MainController.getInstance() ;
				Iterator Objetoiterador;
				Objetoiterador = Objetocarga.CargarUsuarios();
				
				//rellenamos los datos del comboBox	
				while(Objetoiterador.hasNext()){
					
					 cmbUsuario.addItem((String)Objetoiterador.next());
					}
				
				**/
				
				//foto de nuestro mayorMono!
				JLabel lblNewLabel = new JLabel("New label");
				lblNewLabel.setBounds(6, 6, 226, 225);
				add(lblNewLabel);
				lblNewLabel.setIcon(new ImageIcon(VistaPrin.class.getResource("/images/fotocarnet.jpeg")));
				

						
						
						//botones
						
				
						JButton btnJuegos = new JButton("Juegos >");
						btnJuegos.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								
								MainController.getInstance().showVistaJuegos();								
								
							}
						});
						btnJuegos.setBounds(270, 60, 113, 29);
						add(btnJuegos);
				
				// field para contraseña
				passwordfield = new JPasswordField();
				passwordfield.setBounds(22, 283, 187, 28);
				add(passwordfield);
				
	}
	
	
	public void cargaUsuarios(Iterator Objetoiterador){
		while(Objetoiterador.hasNext()){
			
			 cmbUsuario.addItem((String)Objetoiterador.next());
			}		
	 }
}
