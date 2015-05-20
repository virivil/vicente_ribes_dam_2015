package Vista;

import java.awt.Component;

import javax.swing.DefaultListModel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.ListSelectionModel;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Iterator;

public class VistaJuegos extends JPanel {
	
	
	//public JPanel PanelJuegos = new JPanel();

	public JTextField textField;
	public JTextField textField_Nombre;
	public JTextField textField_Genero;
	public JTextField textField_Plataforma;
	
	private JScrollPane scrollPane;
	private JList list;
	private DefaultListModel listModel;
	private DefaultListModel game;


	
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
		
		JPanel panelJList = new JPanel();
		panelJList.setBounds(24, 135, 256, 243);
		add(panelJList);
		panelJList.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JScrollPane scrollPane = new JScrollPane();
		panelJList.add(scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);

		//permite mayor control sobre el JList
        listModel = new DefaultListModel();    
        list = new JList(listModel);
        //Solo  permitmos selccionar un elemento cada vez
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
        scrollPane = new JScrollPane(list);
        scrollPane.setBounds(0, 0, 190, 247);
        
        

        //Evento para mostrar en los campos los datos
        list.addListSelectionListener(new ListSelectionListener() {
              public void valueChanged(ListSelectionEvent listSelectionEvent) {
                  //Cojo el juego seleccionado
                  Game game=(Game)listModel.getElementAt(list.getSelectedIndex());
                  //Coloco los datos en los campos
                  textField_Nombre.setText(game.getNombre());
                  textField_Genero.setText(game.getGenero());
                  textField_Plataforma.setText(game.getPlataforma());
              }
        });

   
    
		
	}
        
        
      //Al haber definido el modelo, los datos sobre el JList se realizará sobre el Modelo,
        //no sobre el JList
        public void cargaJuegos(Iterator<String> iteratorjuegos){
            Iterator<Game> it= iteratorjuegos.iterator();
            listModel.removeAllElements();
            
            while(it.hasNext()){
                Game game=(Game)it.next();
                //Añadimos el objeto Game en el modelo
                listModel.addElement(game);
            }
		

	}
}
