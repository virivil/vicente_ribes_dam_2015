package Vista;

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
import javax.swing.JMenuItem;

import Controlador.MainController;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;


public class VistaApp extends JFrame {
	
	
	
	public static JPanel CPPadre;

	//metodo constructor de la vistaApp, es decir, de la ventana contenedora/exterior.

	public VistaApp() {

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 482, 448);
		CPPadre = new JPanel();
		CPPadre.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(CPPadre);
		CPPadre.setLayout(new CardLayout(0, 0));

	
		VistaPrin objetopanelprin = new VistaPrin();
		CPPadre.add( objetopanelprin, "panelprin");
		objetopanelprin.setVisible(true);
		
		
		VistaJuegos objetopaneljuegos = new VistaJuegos();
		CPPadre.add( objetopaneljuegos, "paneljuegos");

		
		
		//añado la barra del menu
	    
	JMenuBar menuBar = new JMenuBar();
	setJMenuBar(menuBar);
	
		//añado items a la barra
	
	JMenu Principal = new JMenu("Principal");
	menuBar.add(Principal);
	
	JMenu Menu = new JMenu("Menu");
	menuBar.add(Menu);
	
	JMenu Juego = new JMenu("Juego");
	menuBar.add(Juego);
	
	
		//añadimos a los desplegables de los items.
	
	JMenuItem mntmPanelJuegos = new JMenuItem("Panel Juegos");
	mntmPanelJuegos.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			MainController.getInstance().showVistaJuegos();
		}
	});
	Juego.add(mntmPanelJuegos);

	
	JMenuItem mntmPrincipal = new JMenuItem("Panel Principal");
	mntmPrincipal.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			MainController.getInstance().showVistaPrin();

		}
	});
	Principal.add(mntmPrincipal);
	
	
				
			}

	public void ShowJuegos(boolean b) {
		CardLayout c=(CardLayout) VistaApp.CPPadre.getLayout();
		c.show( VistaApp.CPPadre , "paneljuegos");
			}

	public void ShowPrin(boolean b) {
		CardLayout d=(CardLayout) VistaApp.CPPadre.getLayout();
		d.show( VistaApp.CPPadre , "panelprin");		
	}
		
	}
	

