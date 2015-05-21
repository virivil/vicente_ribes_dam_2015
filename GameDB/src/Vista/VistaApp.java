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
import Modelo.Game;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Iterator;


public class VistaApp extends JFrame {
	
	
	
	public static JPanel CPPadre;
	
	//Instancia unica
			private static VistaApp instance = null;
			private VistaPrin objetopanelprin;			
			private VistaJuegos objetopaneljuegos;

		
			
	//metodo constructor de la vistaApp, es decir, de la ventana contenedora/exterior.

	public VistaApp() {

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 482, 448);
		CPPadre = new JPanel();
		CPPadre.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(CPPadre);
		CPPadre.setLayout(new CardLayout(0, 0));

		
		objetopanelprin = new VistaPrin();
		CPPadre.add( objetopanelprin, "panelprin");
		objetopanelprin.setVisible(true);
			
		
		objetopaneljuegos = new VistaJuegos();
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

//carga de los distintos paneles,recuerda, están fuera del constructor de vistaapp	
	
	public void ShowPrin(Iterator Objetoiterador) {
		System.out.println("cargamos el panel principal");

		
		CardLayout d=(CardLayout) VistaApp.CPPadre.getLayout();
		//llamada a metodo para cargar los usuarios
		objetopanelprin.cargaUsuarios(Objetoiterador);
		d.show( VistaApp.CPPadre , "panelprin");		
	}
	
	public void ShowJuegos(ArrayList juegos) {
			
		    //objetopaneljuegos = new VistaJuegos();

			System.out.println("cargamos el panel de Juegos");

			CardLayout c=(CardLayout) VistaApp.CPPadre.getLayout();
			
			objetopaneljuegos.cargaJuegos(juegos);

			c.show( VistaApp.CPPadre , "paneljuegos");
				}

		


	
	
	}
	

