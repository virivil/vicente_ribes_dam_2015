//Superconversormejorado



import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Color;


public class Direcciones extends JFrame {

	// VARIABLES
	
	private JPanel contentPane;
	private JTextField textField_Euros;
	private JTextField textField_Convertido;
	private JTextField textField_mensaje;

	
	
	// atributos
	
	float valor_origen;
	float factor_conversion;
	float valor_destino;
	String moneda_seleccionada=""; 
	
	/**Creo primer array
	final private float monedas[]={5F,2F,15F};
	
	//Segundo array con nombre de monedas
	final private String nombre_moneda[]={"Dolares","Yen","Corona Checa","Franco","peso"};
*/
	
	
	

	
	
	/** TODO ESTO LO GENERA ECLIPSE Y LO PUEDO BORRAR.
	 
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaConversor frame = new VentanaConversor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	 */
	
	// ACCESO DEL CONSTRUCTOR
	
	public Direcciones() {
		
		
		// ventana

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// label instrucción
		JLabel lblIntroduzcaUnValor = new JLabel("Introduzca un valor en Euros entre 0 y 500 ");
		lblIntroduzcaUnValor.setBounds(28, 29, 347, 16);
		contentPane.add(lblIntroduzcaUnValor);
		
		//label EURUOS
		JLabel lblEuros = new JLabel("Euros");
		lblEuros.setBounds(27, 57, 61, 16);
		contentPane.add(lblEuros);
		
		// campo donde introduzco los euros
		textField_Euros = new JTextField();
		textField_Euros.setBounds(28, 85, 134, 28);
		contentPane.add(textField_Euros);
		textField_Euros.setColumns(10);
		
		
/** Saco del constructor los valores del array 
		monedas[0]=1.5F;
		monedas[1]=12F;
		monedas[2]=0.7F;
	*/	
		/**Segundo array con nombre de monedas
		
		nombre_moneda[0]="Dolares";
		nombre_moneda[1]="Corona Checa";
		nombre_moneda[2]="Yen";
		nombre_moneda[3]="Franco";
	*/	
		//Combo= Desplegable
			// creo que el valor del conversor hay que asignarlo en el momento en el que se elige el combo y no despues!!!!! añado un listener al combo.

		JComboBox comboBox = new JComboBox();
		
		comboBox.setBounds(28, 125, 134, 27);
		contentPane.add(comboBox);
			
		
		//añadimos elementos
		
		/** vamos a cambiarlo por un for para que se rellene de forma automática
		comboBox.addItem(nombre_moneda[0]);
		comboBox.addItem(nombre_moneda[1]);
		comboBox.addItem(nombre_moneda[2]);
		comboBox.addItem(nombre_moneda[3]);
		*/
		// añadimos al combobox de forma automatica
		
		for(int i=0;i<Datos.nombre_moneda.length;i++)
			{
				
				comboBox.addItem(Datos.nombre_moneda[i]);
			}
		
			// una opción preseleccionada
		comboBox.setSelectedItem("Dolares");
		
			//listener del combo
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				
				switch ((String)comboBox.getSelectedItem()) //dentro del combo cn el listener y el switch asigno el valor de conversión
					{
					case "Dolares" :
						factor_conversion = Datos.monedas[0] ;
						moneda_seleccionada = Datos.nombre_moneda[0];
						textField_mensaje.setText("Ha seleccionado: " + moneda_seleccionada );// hubiera querido poner esto fuera, pero no he podido, si lo tengo que repetir 4 veces es que hay otra manera de hacerlo.

						break;
					
					case "Corona Checa" :
						factor_conversion = Datos.monedas[1] ;
						moneda_seleccionada = Datos.nombre_moneda[1];
						textField_mensaje.setText("Ha seleccionado: " + moneda_seleccionada );
						break;
						
					case "Yen" :
						factor_conversion = Datos.monedas[2] ;
						moneda_seleccionada = Datos.nombre_moneda[2];
						textField_mensaje.setText("Ha seleccionado: " + moneda_seleccionada );

						break;
						
					default:
						moneda_seleccionada = Datos.nombre_moneda[3];
						textField_mensaje.setText("Ha seleccionado una moneda fuera de curso" );


						break;
					}
				
				
			}
		});

		
		
		
		
		
		//Campo destino de la conversión
		textField_Convertido = new JTextField();
		textField_Convertido.setColumns(10);
		textField_Convertido.setBounds(28, 166, 134, 28);
		contentPane.add(textField_Convertido);
		
		//botón convertir
		JButton btnConvertir = new JButton("Convertir");
		btnConvertir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//aquí emplazamos todo aquello que queramos que ocurra una vez pulsamos el botón de convertir
				
/***	
 *          Probamos si funciona el botón= todo ok.
 * 			System.out.println("prueba");
	**/	
				
	//para evitar que introduciendo texto produzca error utilizaremos el try,catch
				
				
				try {
									//mediante el getText recuepramos el texto , mediante el parseFloat convertimos el string a float
									valor_origen=Float.parseFloat(textField_Euros.getText()) ;
									
								
											//para controlar que sea entre 0 y 500 , utilizaremos un , if, else if, else
						
									if ( valor_origen < 0 ) {
										textField_mensaje.setText("Introduzca un número entre 0 y 500");
									} else if (valor_origen > 500 ) {
										textField_mensaje.setText("Introduzca un número entre 0 y 500");
									} else {
										//aquí lo dejamos listo para que cuando se le de un valor a factorconversion directamente lo muestre en la ventana el resultado
								  			//System.out.println(valor_origen);
					
										valor_destino= valor_origen*factor_conversion ;
										
										textField_Convertido.setText(String.valueOf(valor_destino));
									}
				} catch ( Exception e1 )	{ 
					textField_mensaje.setText("Debe introducir un número");

				}
					
				
				
			}
		});
		btnConvertir.setBounds(215, 124, 117, 29);
		contentPane.add(btnConvertir);
		
			
		
		
		
		//label Mensaje de control
		JLabel lblMensajeDeControl = new JLabel("Mensaje de control:");
		lblMensajeDeControl.setBounds(28, 206, 178, 16);
		contentPane.add(lblMensajeDeControl);
		
		//Campo destino mensaje de control
		textField_mensaje = new JTextField();
		textField_mensaje.setForeground(Color.RED);
		textField_mensaje.setEditable(false);
		textField_mensaje.setColumns(10);
		textField_mensaje.setBounds(28, 234, 379, 28);
		contentPane.add(textField_mensaje);
		
		
		
		
		
	}
}
