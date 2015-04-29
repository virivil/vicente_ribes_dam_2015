package Vista;
import Modelo.UsuariosModel;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;

import java.awt.FlowLayout;

import javax.swing.BoxLayout;

import java.awt.CardLayout;

import javax.swing.JMenu;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import java.awt.Canvas;
import java.awt.Color;
import java.util.Iterator;

import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import Modelo.ConexionDB;
import Modelo.UsuariosModel;



public class VistaPrincipal extends JFrame {
	
				//agrupo las variables/atributos
				
				public JPanel PanelPrincipal;
			
				private JPasswordField passwordfield;
				
				//datos para la carga de usuarios
				UsuariosModel objetousuarios = new UsuariosModel();
				static UsuariosModel mUsuarios;


				
				//metodo constructor (de entrada)  a la Vista Principal(panel)
				public  VistaPrincipal() {
					
					PanelPrincipal = new JPanel();
					PanelPrincipal.setLayout(null);
							
							
							//botones
							
					
							JButton btnJuegos = new JButton("Juegos >");
							btnJuegos.setBounds(266, 42, 166, 29);
						
							PanelPrincipal.add(btnJuegos);
							
							JButton btnPerfil = new JButton("Perfil >");
							btnPerfil.setBounds(266, 83, 166, 29);
							PanelPrincipal.add(btnPerfil);
							
							JButton btnLogin = new JButton("Login");
							btnLogin.setBounds(31, 303, 166, 29);
							PanelPrincipal.add(btnLogin);
							
							JButton btnRegistrar = new JButton("Registrar");
							btnRegistrar.setBounds(31, 344, 166, 29);
							PanelPrincipal.add(btnRegistrar);
							
							//combobox
							
							JComboBox cmbUsuario = new JComboBox();
							cmbUsuario.setBounds(31, 224, 166, 27);
							PanelPrincipal.add(cmbUsuario);
							cmbUsuario.setToolTipText("Usuario");
							
							// field para contraseña
							passwordfield = new JPasswordField();
							passwordfield.setBounds(31, 263, 166, 28);
							PanelPrincipal.add(passwordfield);
							
							
							//foto de nuestro mayorMono!
							JLabel lblNewLabel = new JLabel("New label");
							lblNewLabel.setBounds(9, 5, 205, 193);
							PanelPrincipal.add(lblNewLabel);
							lblNewLabel.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/images/fotocarnet.jpeg")));
							
							//rellenamos los datos del comboBox
							
							mUsuarios= new UsuariosModel();
							mUsuarios.getUsuarios();
							
						//System.out.println("paso por vista principal");
							//objetousuarios.getUsuarios();
							
							/**
							Iterator<String> it= objetousuarios.getUsuarios().iterator();
							while(it.hasNext()){
								cmbUsuario.addItem((String)it.next());
							}
								
							**/
							} 
				
	
				//creo que el problema es que Vistaapp está esperando un JPanel ...

				
	public JPanel Devuelvepanel(){ 				//creo un metodo que devuelva el JPanel (dicho así parece fácil, me ha costado horas saber que %$&// pasaba )
		return PanelPrincipal;
	}
	
	
} //fin de la clase vistaprincipal
