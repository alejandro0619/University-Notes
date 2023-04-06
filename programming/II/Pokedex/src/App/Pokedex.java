package App;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.TextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import database.DbScheme;
import database.Parser;
import utils.Validations;

import java.awt.Font;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.JMenu;

public class Pokedex {

	private JFrame frmPokedex;
	private TextField txtIngreseElNmero;
	private JTable table;
	private JTextField opProcess;
	private int selectedRows = -1;

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
	@SuppressWarnings("serial")
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
				if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
					lblNmero.setText("Número");
					txtIngreseElNmero.setEditable(true);
				} else {
					txtIngreseElNmero.setText("");
					txtIngreseElNmero.setEditable(false);
					lblNmero.setText("Solo números");
					lblNmero.setForeground(Color.RED);
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
		JLabel lblTipo = new JLabel("Tipo 2");
		lblTipo.setBounds(161, 94, 60, 17);
		frmPokedex.getContentPane().add(lblTipo);
		JComboBox<String> comboBoxTipo1 = new JComboBox<String>();
		comboBoxTipo1.setModel(new DefaultComboBoxModel<String>(new String[] {"Normal", "Luchador", "Aéreo", "Veneno", "Tierra", "Roca", "Bicho", "Fantasma", "Hierro", "Fuego", "Agua", "Planta", "Eléctrico", "Psíquico", "Hielo", "Dragón", "Siniestro", "Hada"}));
		comboBoxTipo1.setBounds(32, 123, 98, 26);
		frmPokedex.getContentPane().add(comboBoxTipo1);
		
		// -- SECOND KIND OF POKEMON
		JLabel lblTipo_1 = new JLabel("Tipo 1");
		lblTipo_1.setBounds(32, 94, 60, 17);
		frmPokedex.getContentPane().add(lblTipo_1);
		JComboBox<String> comboBoxTipo2 = new JComboBox<String>();
		comboBoxTipo2.setModel(new DefaultComboBoxModel<String>(new String[] {"Nada", "Normal", "Luchador", "Aéreo", "Veneno", "Tierra", "Roca", "Bicho", "Fantasma", "Hierro", "Fuego", "Agua", "Planta", "Eléctrico", "Psíquico", "Hielo", "Dragón", "Siniestro", "Hada"}));
		comboBoxTipo2.setBounds(161, 123, 98, 26);
		frmPokedex.getContentPane().add(comboBoxTipo2);	

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
		
		JLabel lblSex = new JLabel("Sexo");
		lblSex.setBounds(32, 163, 60, 17);
		frmPokedex.getContentPane().add(lblSex);
		JComboBox<String> comboBox_2 = new JComboBox<String>();
		comboBox_2.setModel(new DefaultComboBoxModel<String>(new String[] {"No especificado", "Masculino", "Femenino"}));
		comboBox_2.setBounds(32, 192, 98, 26);
		frmPokedex.getContentPane().add(comboBox_2);
				
		JLabel lblUb = new JLabel("Ubicación");
		lblUb.setBounds(161, 168, 147, 17);
		frmPokedex.getContentPane().add(lblUb);
		TextField txtUbi = new TextField();
		txtUbi.setBounds(161, 197, 198, 21);
		frmPokedex.getContentPane().add(txtUbi);
		
		table = new JTable() {
			@Override
			public boolean isCellEditable(int rows, int columns) {
				return false;
				
			}
		};
		table.setForeground(Color.WHITE);
		table.setBackground(Color.DARK_GRAY);

		table.setCellSelectionEnabled(false);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setColumnSelectionAllowed(false);
		table.setRowSelectionAllowed(true);
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Numero", "Nombre", "Tipo 1", "Tipo 2", "Sexo", "Ubicacion"
			}
		));
		table.setBounds(12, 329, 426, 139);
		// We set it in a JScrollPane
		frmPokedex.getContentPane().add(table);
		
		JLabel opStatus = new JLabel("Estado de la operación:");
		opStatus.setFont(new Font("Dialog", Font.BOLD, 16));
		opStatus.setBounds(18, 480, 203, 17);
		frmPokedex.getContentPane().add(opStatus);
		
		opProcess = new JTextField();
		opProcess.setFont(new Font("Dialog", Font.BOLD, 14));
		opProcess.setBackground(Color.DARK_GRAY);
		opProcess.setEditable(false);
		opProcess.setBounds(216, 480, 222, 21);
		frmPokedex.getContentPane().add(opProcess);
		opProcess.setColumns(10);
		
		JLabel tableNum = new JLabel("Número");
		tableNum.setHorizontalAlignment(SwingConstants.CENTER);
		tableNum.setBounds(12, 301, 60, 17);
		frmPokedex.getContentPane().add(tableNum);
		
		JLabel tableName = new JLabel("Nombre");
		tableName.setHorizontalAlignment(SwingConstants.CENTER);
		tableName.setBounds(84, 301, 60, 17);
		frmPokedex.getContentPane().add(tableName);
		
		JLabel tableTipo1 = new JLabel("Tipo 1");
		tableTipo1.setHorizontalAlignment(SwingConstants.CENTER);
		tableTipo1.setBounds(161, 300, 60, 17);
		frmPokedex.getContentPane().add(tableTipo1);
		
		JLabel tableTipo2 = new JLabel("Tipo 2");
		tableTipo2.setHorizontalAlignment(SwingConstants.CENTER);
		tableTipo2.setBounds(230, 300, 60, 17);
		frmPokedex.getContentPane().add(tableTipo2);
		
		JLabel tableSexo = new JLabel("Sexo");
		tableSexo.setHorizontalAlignment(SwingConstants.CENTER);
		tableSexo.setBounds(299, 301, 60, 17);
		frmPokedex.getContentPane().add(tableSexo);
		
		JLabel lblUbicacion = new JLabel("Ubicación");
		lblUbicacion.setHorizontalAlignment(SwingConstants.CENTER);
		lblUbicacion.setBounds(371, 301, 60, 17);
		frmPokedex.getContentPane().add(lblUbicacion);

		JMenuBar menuBar = new JMenuBar();
		frmPokedex.setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		JMenuItem mntmAbrir = new JMenuItem("Abrir");
		mntmAbrir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Parser p = new Parser("./db");
					ArrayList<DbScheme> data = p.read();

					for(DbScheme val : data) {
						DefaultTableModel model = (DefaultTableModel) table.getModel();
						
						model.addRow(new String[] {
							val.getNumber(),
							val.getName(),
							val.getKind1(),
							val.getKind2(),
							val.getSex(),
							val.getAddress()
						});
					}
					
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		mnArchivo.add(mntmAbrir);
		
		JMenuItem mntmGuardar = new JMenuItem("Guardar");
		mntmGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Parser p = new Parser("./db");
					for(int i = 0; i < table.getRowCount(); i++) {
						ArrayList<String> rowData = new ArrayList<String>();
						for(int j = 0; j < table.getColumnCount(); j++) {
							rowData.add((String) table.getValueAt(i, j));
						}
						System.out.println(rowData);
						p.write(rowData);
					}
				} catch (IOException err) {
					// TODO Auto-generated catch block
					err.printStackTrace();
			 }
		 }
		});
		mnArchivo.add(mntmGuardar);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnArchivo.add(mntmSalir);
		
		JMenu mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
		JMenuItem mntmSobre = new JMenuItem("Acerca de");
		mntmSobre.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
				JOptionPane about = new JOptionPane();
				about.showMessageDialog(mntmSobre, "Alejandro López\nGithub: alejandro0619\n");
			}
		});
		mnAyuda.add(mntmSobre);
		
		/*
		 * Events triggered
		*/
		btnRegistrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TextField number = txtIngreseElNmero;
				TextField name = txtNombre;
				String kind1 = (String) comboBoxTipo1.getSelectedItem();
				String kind2 = (String) comboBoxTipo2.getSelectedItem();
				String sex = (String) comboBox_2.getSelectedItem();
				TextField address = txtUbi;
				TextField[] inputs = {number, name, address};
				JLabel[] labels = {lblNmero, lblNombre, lblUb};
				boolean isOkStatus = false;
				
				// Checks if the input text field is empty or blank, if so, request for it to be filled.
				for (int index = 0; index < inputs.length; index++) {
					JLabel label = labels[index];
					String labelTxt = label.getText();
					 
					if (new Validations().validateInputs(inputs[index])) {
						if(!labelTxt.contains("*")) {
							label.setText(labelTxt.concat(" *"));
						}
						label.setForeground(Color.RED);
						isOkStatus = false;
					} else {
						if(labelTxt.contains("*")) {
							label.setText(labelTxt.substring(0, labelTxt.length() - 2));
							label.setForeground(Color.BLACK);
						}
						// Everything went good
						isOkStatus = true;
					}
				}
				// Adds to the table and the file
				if(isOkStatus) {
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					model.addRow(new String[] {number.getText(), name.getText(), kind1, kind2, sex, address.getText()});
					
					opProcess.setText(" Agregado a la tabla");
					
					opProcess.setForeground(Color.GREEN);
				} else {
					// An error occurred:
					opProcess.setText("Error al agregar a tabla");
					opProcess.setForeground(Color.RED)
					;
				}
			}
		});
		
		btnLimpiar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				/*
				 * Sets every TextField to null or ""
				 */
				txtIngreseElNmero.setText(null);
				txtNombre.setText(null);
				txtUbi.setText(null);
				comboBoxTipo1.setSelectedIndex(0);
				comboBoxTipo2.setSelectedIndex(0);
				comboBox_2.setSelectedItem(0);
				
			}
			
		});
		btnActualizar.addActionListener(new ActionListener() {
			@Override 
			public void actionPerformed(ActionEvent e) {
				TextField number = txtIngreseElNmero;
				TextField name = txtNombre;
				String kind1 = (String) comboBoxTipo1.getSelectedItem();
				String kind2 = (String) comboBoxTipo2.getSelectedItem();
				String sex = (String) comboBox_2.getSelectedItem();
				TextField address = txtUbi;
				TextField[] inputs = {number, name, address};
				JLabel[] labels = {lblNmero, lblNombre, lblUb};
				boolean isOkStatus = false;
				
				// Checks if the input text field is empty or blank, if so, request for it to be filled.
				for (int index = 0; index < inputs.length; index++) {
					JLabel label = labels[index];
					String labelTxt = label.getText();
					 
					if (new Validations().validateInputs(inputs[index])) {
						if(!labelTxt.contains("*")) {
							label.setText(labelTxt.concat(" *"));
						}
						label.setForeground(Color.RED);
						isOkStatus = false;
					} else {
						if(labelTxt.contains("*")) {
							label.setText(labelTxt.substring(0, labelTxt.length() - 2));
							label.setForeground(Color.BLACK);
						}
						// Everything went good
						isOkStatus = true;
					}
				}
				// Update table's values if no error occurred
				if(isOkStatus) {
					if (selectedRows != -1) {
						DefaultTableModel model = (DefaultTableModel) table.getModel();
						for(int index = 0; index < 6; index++) {
							String[] values = new String[] {number.getText(), name.getText(), kind1, kind2, sex, address.getText()};
							model.setValueAt(values[index], selectedRows, index);
						}
					} else {
						// An error occurred:
						opProcess.setText("No hay tabla seleccionada");
						opProcess.setForeground(Color.RED);
					}
				} else {
					// An error occurred:
					opProcess.setText("Hay campos vacíos");
					opProcess.setForeground(Color.RED);
				}
			}
		});
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				selectedRows = table.getSelectedRow();
				for(int index = 0; index < 6; index++) {
					/*
					 * Prevent the event to propagate twice and checks if the selected row is correct
					 */
					if(!e.getValueIsAdjusting() && selectedRows != -1) {
						String value = (String) table.getValueAt(selectedRows, index);
						 /*
						  * Fills the text inputs and the comboBoxes
						  */
						switch(index) {
							case 0:
								txtIngreseElNmero.setText(value);
								break;
							case 1:
								txtNombre.setText(value);
								break;
							case 2:
								comboBoxTipo1.setSelectedItem(value);
								break;
							case 3:
								comboBoxTipo2.setSelectedItem(value);
								break;
							case 4:
								comboBox_2.setSelectedItem(value);
								break;
							case 5:
								txtUbi.setText(value);
								break;
								
						}
					}	
				}
			}
			
		});
	}
}
