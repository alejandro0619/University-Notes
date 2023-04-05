package App;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.TextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import javax.swing.border.CompoundBorder;
import javax.swing.ListSelectionModel;

public class Pokedex {

	private JFrame frmPokedex;
	private TextField txtIngreseElNmero;
	private JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pokedex window = new Pokedex();
					window.frmPokedex.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Pokedex() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// -- MAIN FRAME --
		frmPokedex = new JFrame();
		frmPokedex.setTitle("Pokedex");
		frmPokedex.setBounds(100, 100, 450, 600);
		frmPokedex.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPokedex.getContentPane().setLayout(null);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 450, 1);
		frmPokedex.getContentPane().add(panel);
		panel.setLayout(null);
		
		// -- NUMBER TEXT INPUT
		JLabel lblNmero = new JLabel("Número");
		lblNmero.setBounds(32, 23, 134, 17);
		frmPokedex.getContentPane().add(lblNmero);
		txtIngreseElNmero = new TextField();
		lblNmero.setLabelFor(txtIngreseElNmero);
		
		txtIngreseElNmero.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent ke) {
				if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
					txtIngreseElNmero.setEditable(true);
				} else {
					txtIngreseElNmero.setEditable(true);
					lblNmero.setText("Solo números");
				}
			}
		});
		txtIngreseElNmero.setBounds(32, 52, 85, 21);
		frmPokedex.getContentPane().add(txtIngreseElNmero);
		txtIngreseElNmero.setColumns(10);
		
		// -- NAME TEXT INPUT
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(161, 23, 147, 17);
		frmPokedex.getContentPane().add(lblNombre);
		TextField txtNombre = new TextField();
		txtNombre.setBounds(161, 52, 198, 21);
		frmPokedex.getContentPane().add(txtNombre);
		
		// -- FIRST KIND OF POKEMON
		JLabel lblTipo = new JLabel("Tipo 1");
		lblTipo.setBounds(161, 94, 60, 17);
		frmPokedex.getContentPane().add(lblTipo);
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Normal", "Luchador", "Aéreo", "Veneno", "Tierra", "Roca", "Bicho", "Fantasma", "Hierro", "Fuego", "Agua", "Planta", "Eléctrico", "Psíquico", "Hielo", "Dragón", "Siniestro", "Hada"}));
		comboBox.setBounds(32, 123, 98, 26);
		frmPokedex.getContentPane().add(comboBox);
		
		// -- SECOND KIND OF POKEMON
		JLabel lblTipo_1 = new JLabel("Tipo 2");
		lblTipo_1.setBounds(32, 94, 60, 17);
		frmPokedex.getContentPane().add(lblTipo_1);
		JComboBox<String> comboBox_1 = new JComboBox<String>();
		comboBox_1.setModel(new DefaultComboBoxModel<String>(new String[] {"Nada", "Normal", "Luchador", "Aéreo", "Veneno", "Tierra", "Roca", "Bicho", "Fantasma", "Hierro", "Fuego", "Agua", "Planta", "Eléctrico", "Psíquico", "Hielo", "Dragón", "Siniestro", "Hada"}));
		comboBox_1.setBounds(161, 123, 98, 26);
		frmPokedex.getContentPane().add(comboBox_1);	

		JButton btnRegistrar = new JButton("Registrar");
		
		btnRegistrar.setBounds(32, 230, 105, 27);
		frmPokedex.getContentPane().add(btnRegistrar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLimpiar.setBounds(161, 230, 105, 27);
		frmPokedex.getContentPane().add(btnLimpiar);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnActualizar.setBounds(291, 230, 105, 27);
		frmPokedex.getContentPane().add(btnActualizar);
		
		JLabel lblTipo_1_1 = new JLabel("Sexo");
		lblTipo_1_1.setBounds(32, 163, 60, 17);
		frmPokedex.getContentPane().add(lblTipo_1_1);
		JComboBox<String> comboBox_2 = new JComboBox<String>();
		comboBox_2.setModel(new DefaultComboBoxModel<String>(new String[] {"No especificado", "Masculino", "Femenino"}));
		comboBox_2.setBounds(32, 192, 98, 26);
		frmPokedex.getContentPane().add(comboBox_2);
				
		JLabel lblUb_1 = new JLabel("Ubicación");
		lblUb_1.setBounds(161, 168, 147, 17);
		frmPokedex.getContentPane().add(lblUb_1);
		TextField txtUbi = new TextField();
		txtUbi.setBounds(161, 197, 198, 21);
		frmPokedex.getContentPane().add(txtUbi);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setModel(new DefaultTableModel(
			new String[] {
				"Numero", "Nombre", "Tipo 1", "Tipo 2", "Sexo", "Ubicacion"
			}, 0));
		table.setBounds(12, 326, 426, 142);
		table.setEnabled(false);
		table.isCellEditable(0, 0);
		frmPokedex.getContentPane().add(table);
		
		JLabel lblPokedex = new JLabel("Pokedex");
		lblPokedex.setLabelFor(table);
		lblPokedex.setFont(new Font("Dialog", Font.BOLD, 16));
		lblPokedex.setBounds(186, 288, 74, 26);
		frmPokedex.getContentPane().add(lblPokedex);
		
		JLabel opStatus = new JLabel("Estado de la operación:");
		opStatus.setFont(new Font("Dialog", Font.BOLD, 16));
		opStatus.setBounds(18, 480, 203, 17);
		frmPokedex.getContentPane().add(opStatus);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(216, 480, 114, 21);
		frmPokedex.getContentPane().add(textField);
		textField.setColumns(10);

		JMenuBar menuBar = new JMenuBar();
		frmPokedex.setJMenuBar(menuBar);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Archivo");
		menuBar.add(mntmNewMenuItem);
		
		JMenuItem mntmAyuda = new JMenuItem("Ayuda");
		menuBar.add(mntmAyuda);
		
		/*
		 * Events triggered
		*/
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TextField number = txtIngreseElNmero;
				TextField name = txtNombre;
				String kind1 = (String) comboBox.getSelectedItem();
				String kind2 = (String) comboBox_1.getSelectedItem();
				String sex = (String) comboBox_2.getSelectedItem();
				TextField address = txtUbi;
				TextField[] inputs = {number, name, address};
				JLabel[] labels = {lblNmero, lblNombre, lblUb_1};
				JLabel[] labelsDefault = labels.clone();
				boolean isOkStatus = false;
				
				// Checks if the input text field is empty or blank, if so, request for it to be filled.
				for (int index = 0; index < inputs.length; index++) {
					if (inputs[index].getText().isBlank() || inputs[index].getText().isEmpty()) {
						if(!labelsDefault[index].getText().contains("*")) {
							labels[index].setText(labels[index].getText().concat(" *"));
						}
						labels[index].setForeground(Color.RED);
					} else {
						if(labelsDefault[index].getText().contains("*")) {
							labels[index].setText(labelsDefault[index].getText().substring(0, labelsDefault[index].getText().length() - 2));
							labels[index].setForeground(Color.BLACK);
						}
						// Everything went good
						isOkStatus = true;
					}
				}
				// Adds to the table and the file
				if(isOkStatus) {
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					model.addRow(new String[] {number.getText(), name.getText(), kind1, kind2, sex, address.getText()});
				}
			}
		});
	}
}
