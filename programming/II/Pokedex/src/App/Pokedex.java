package App;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Label;

public class Pokedex {

	private JFrame frmPokedex;

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
		frmPokedex = new JFrame();
		frmPokedex.setTitle("Pokedex");
		frmPokedex.setBounds(100, 100, 450, 300);
		frmPokedex.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmPokedex.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		Label label = new Label("Hello ");
		label.setBounds(10, 33, 63, 23);
		panel.add(label);
	}
}
