package Vista;
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
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;


public class VistaPrincipal extends JFrame {
	
	
	
	public JPanel PanelPrincipal;

	private JPasswordField passwordfield;
	
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
				
				JLabel lblNewLabel = new JLabel("New label");
				lblNewLabel.setBounds(9, 5, 205, 193);
				PanelPrincipal.add(lblNewLabel);
				lblNewLabel.setIcon(new ImageIcon("/Users/vince/Documents/git/vicente_rv_prog_2014_2015/GameDB/src/Vista/fotocarnet.jpeg"));
				
				
				//creo que el problema es que Vistaapp está esperando un JPanel ...
				
				} 
	
	//creo un metodo que devuelva el JPanel (dicho así parece fácil, me ha costado horas saber que %$&// pasaba )
	public JPanel Devuelvepanel(){
		return PanelPrincipal;
	}
	
	
}
