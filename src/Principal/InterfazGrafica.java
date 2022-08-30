package Principal;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Clases.Universidad;
import DAOs.DAOUniversidad;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class InterfazGrafica extends JFrame {

	private JPanel contentPane;
	JComboBox comboBoxUniversidad;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazGrafica frame = new InterfazGrafica();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public InterfazGrafica() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboBoxUniversidad = new JComboBox();		
		LinkedList<Universidad> universidades = DAOUniversidad.allUniversidadesNombre();
		ArrayList<String> lista = new ArrayList<>();
		for(Universidad u : universidades) {
			lista.add(u.getNombre());
		}
		String[] nombreUniversidad = (String[]) lista.toArray(new String[lista.size()]);
		comboBoxUniversidad.setModel(new DefaultComboBoxModel(nombreUniversidad));		
		comboBoxUniversidad.setBounds(96, 94, 241, 22);
		contentPane.add(comboBoxUniversidad);		
		
	}
}
