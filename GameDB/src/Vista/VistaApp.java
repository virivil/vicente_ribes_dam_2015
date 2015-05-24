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
import javax.swing.JTextField;


public class VistaApp extends JFrame {
		
			private String msg = "";
			public static JPanel BLO;
			public static JPanel CPPadre;
	
			//Instancia unica		
			private static VistaApp instance = null;
			
			private VistaPrin objetopanelprin;			
			private VistaJuegos objetopaneljuegos;
			private JTextField consolaapp;




		
			
	//metodo constructor de la vistaApp, es decir, de la ventana contenedora/exterior.

	private VistaApp() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 482, 448);
		BLO = new JPanel();
		BLO.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(BLO);
		BLO.setLayout(new BorderLayout(0, 0));
		
		JPanel CPPadre = new JPanel();
		BLO.add(CPPadre);
		CPPadre.setLayout(new CardLayout(0, 0));
		
				
				objetopanelprin = new VistaPrin();
				CPPadre.add(objetopanelprin, "panelprin");				
		
				objetopaneljuegos = new VistaJuegos();
				CPPadre.add(objetopaneljuegos, "paneljuegos");
		
				// la consola: muestra mensajes en la base de la ventana. 
		consolaapp = new JTextField();
		consolaapp.setEnabled(false);
		consolaapp.setEditable(false);
		BLO.add(consolaapp, BorderLayout.SOUTH);
		consolaapp.setColumns(10);
		
		
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

			//Implementar SingleTon
	public static VistaApp getInstance() {
			      if(instance == null) {
			         instance = new VistaApp();
			      }
			      return instance;
			}
	
//carga de los distintos paneles,recuerda, están fuera del constructor de vistaapp	
	
	public void CargaPanelPrin(Iterator Objetoiterador) {
					//cargamos el panel principal
					//llamada a metodo para cargar los usuarios
					objetopanelprin.cargaUsuarios(Objetoiterador);	
					
					objetopanelprin.setVisible(true);
					objetopaneljuegos.setVisible(false);
					//objetopanelprin.show(true);

				}
	
	public void CargaPanelJuegos(ArrayList juegos) {
			
					//cargamos el panel de Juegos
		
					objetopaneljuegos.cargaJuegos(juegos);	
		
					objetopaneljuegos.setVisible(true);
					objetopanelprin.setVisible(false);
					//objetopaneljuegos.show(true);
	
				}
	
	public void MensajePorConsola(String mensaje){
					this.consolaapp.setText(mensaje);
				}
				
	}
	

