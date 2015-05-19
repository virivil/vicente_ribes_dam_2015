package Vista;

import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JLabel;

public class VistaJuegos extends JPanel {
	
	
	//public JPanel PanelJuegos = new JPanel();

	public JTextField textField;
	public JTextField textField_Nombre;
	public JTextField textField_Genero;
	public JTextField textField_Plataforma;
	
	
	
	public VistaJuegos() {
		
		
		
		setLayout(null);
		
		JButton VJBoton2 = new JButton("Editar");
		VJBoton2.setBounds(292, 349, 150, 29);
		add(VJBoton2);
		
		JButton VJBoton1 = new JButton("Salvar");
		VJBoton1.setBounds(292, 308, 150, 29);
		add(VJBoton1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(170, 58, 120, 50);
		add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(306, 58, 120, 50);
		add(comboBox_1);
		
		textField = new JTextField();
		textField.setBounds(24, 68, 134, 28);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblFiltros = new JLabel("Filtros");
		lblFiltros.setBounds(14, 23, 61, 16);
		add(lblFiltros);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(24, 40, 61, 16);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Género");
		lblNewLabel_1.setBounds(172, 40, 61, 16);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Plataforma");
		lblNewLabel_2.setBounds(310, 40, 116, 16);
		add(lblNewLabel_2);
		
		textField_Nombre = new JTextField();
		textField_Nombre.setBounds(292, 143, 134, 28);
		add(textField_Nombre);
		textField_Nombre.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(296, 126, 61, 16);
		add(lblNombre);
		
		JLabel lblGnero = new JLabel("Género");
		lblGnero.setBounds(296, 179, 61, 16);
		add(lblGnero);
		
		textField_Genero = new JTextField();
		textField_Genero.setColumns(10);
		textField_Genero.setBounds(292, 194, 134, 28);
		add(textField_Genero);
		
		JLabel lblPlataforma = new JLabel("Plataforma");
		lblPlataforma.setBounds(296, 234, 102, 16);
		add(lblPlataforma);
		
		textField_Plataforma = new JTextField();
		textField_Plataforma.setColumns(10);
		textField_Plataforma.setBounds(296, 249, 134, 28);
		add(textField_Plataforma);
		
		
		
		
		

	}
}
