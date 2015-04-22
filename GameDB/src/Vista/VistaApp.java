package Vista;
import Vista.VistaPrincipal;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;


public class VistaApp extends JFrame {
	
	
	
	
	public JPanel CPPadre;

	//metodo de la vistaPrincipal, es decir, de la ventana contenedora.

	public VistaApp() {

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 482, 448);
		CPPadre = new JPanel();
		CPPadre.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(CPPadre);
		CPPadre.setLayout(new CardLayout(0, 0));
		
					
		//añado la barra del menu
	    //añado items
	
	JMenuBar menuBar = new JMenuBar();
	setJMenuBar(menuBar);
	
	JMenu Principal = new JMenu("Principal");
	menuBar.add(Principal);
	
	JMenu Juego = new JMenu("Juego");
	menuBar.add(Juego);
	
	JMenu Menu = new JMenu("Menu");
	menuBar.add(Menu);
				
	
	//aquí creo un objeto de nombre prueba de tipo VistaPrincipal y lo llamo mediante el constructor del mismo nombre, tras luego utilizar un metodo especificio creado para que devuelva un objeto tipo JPanel.		
	
	VistaPrincipal prueba = new VistaPrincipal();
	CPPadre.add(	prueba.Devuelvepanel(), "panelprincipal");
	prueba.Devuelvepanel().setLayout(null);


			
			
		}
		
	}
	

