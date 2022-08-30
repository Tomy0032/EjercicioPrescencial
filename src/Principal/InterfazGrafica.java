package Principal;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Clases.Carrera;
import Clases.Universidad;
import DAOs.DAOCarrera;
import DAOs.DAOUniversidad;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.Rectangle;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Insets;
import java.awt.Cursor;

public class InterfazGrafica extends JFrame {
	
	private LinkedList<Universidad> universidades = null;
	private ArrayList<String> lista = null;
	private String[] nombreUniversidad = null;

	private JPanel contentPane;
	private JComboBox comboBoxUniversidad;
	private JPanel panelRegistroCarrera;
	private JPanel containerRegistroCarrera;
	private JTextField textFieldNombreCarrera;
	private JButton btnAgregarCarrera;
	private JLabel lblUniversidadCarrera;
	private JLabel lblNombreCarrera;
	private JButton btnMenuAgregarCarrera;
	private JButton btnMenuAgregarUniversidad;
	private JPanel panelMenu;
	private JPanel panelRegistroUniversidad;
	private JPanel containerRegistroUniversidad;
	private JTextField textFieldNombreUniversidad;
	private JLabel lblNombreUniversidad;
	private JLabel lblUbicacionUniversidad;
	private JButton btnAgregarUniversidad;
	private JTextField textFieldUbicacionUniversidad;

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
	
	public void cargarUniversidades() {
		universidades = DAOUniversidad.allUniversidadesNombre();
		lista = new ArrayList<>();
		for(Universidad u : universidades) {
			lista.add(u.getNombre());
		}
		nombreUniversidad = (String[]) lista.toArray(new String[lista.size()]);
		comboBoxUniversidad.setModel(new DefaultComboBoxModel(nombreUniversidad));
	}

	public InterfazGrafica() {
				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 834, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);		
		panelRegistroCarrera = new JPanel();
		panelRegistroCarrera.setBackground(new Color(255, 255, 255));
		panelRegistroCarrera.setBounds(275, 11, 533, 323);
		contentPane.add(panelRegistroCarrera);
		panelRegistroCarrera.setLayout(null);
		
		containerRegistroCarrera = new JPanel();
		containerRegistroCarrera.setBackground(new Color(255, 255, 255));
		containerRegistroCarrera.setBounds(82, 54, 368, 214);
		panelRegistroCarrera.add(containerRegistroCarrera);
		containerRegistroCarrera.setLayout(null);
		
		comboBoxUniversidad = new JComboBox();
		comboBoxUniversidad.setBackground(new Color(255, 255, 255));
		comboBoxUniversidad.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		comboBoxUniversidad.setFont(new Font("Roboto", Font.PLAIN, 12));
		comboBoxUniversidad.setBounds(129, 83, 227, 32);
		containerRegistroCarrera.add(comboBoxUniversidad);
		cargarUniversidades();
		
		textFieldNombreCarrera = new JTextField();
		textFieldNombreCarrera.setMargin(new Insets(5, 10, 5, 10));
		textFieldNombreCarrera.setBounds(129, 34, 227, 32);
		containerRegistroCarrera.add(textFieldNombreCarrera);
		textFieldNombreCarrera.setColumns(10);
		
		lblNombreCarrera = new JLabel("Nombre");
		lblNombreCarrera.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblNombreCarrera.setBounds(10, 42, 132, 14);
		containerRegistroCarrera.add(lblNombreCarrera);
		
		lblUniversidadCarrera = new JLabel("Universidad");
		lblUniversidadCarrera.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblUniversidadCarrera.setBounds(10, 92, 132, 14);
		containerRegistroCarrera.add(lblUniversidadCarrera);
		
		btnAgregarCarrera = new JButton("Agregar");
		btnAgregarCarrera.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAgregarCarrera.setBackground(SystemColor.control);
		btnAgregarCarrera.setFont(new Font("Roboto", Font.PLAIN, 14));
		btnAgregarCarrera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean continuar = true; 
				String nombreCarrera = textFieldNombreCarrera.getText();
				String nombreUniversidad = comboBoxUniversidad.getSelectedItem().toString();
				
				if(nombreCarrera.equals("")) {
					continuar = false;
				}
				
				if(continuar) {
					
					if(DAOCarrera.buscarCarrera(nombreCarrera) == null) {
					
						Carrera c = new Carrera(nombreCarrera,DAOUniversidad.buscarNombre(nombreUniversidad));
						DAOCarrera.insertCarrera(c);
						
					}else {
						
					}					
					
				}
				
			}
		});
		btnAgregarCarrera.setBounds(120, 158, 127, 32);
		containerRegistroCarrera.add(btnAgregarCarrera);
		
		panelMenu = new JPanel();
		panelMenu.setBackground(new Color(255, 255, 255));
		panelMenu.setBounds(10, 11, 255, 323);
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);
		
		btnMenuAgregarCarrera = new JButton("Agregar Carrera");
		btnMenuAgregarCarrera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelRegistroCarrera.setVisible(true);
				panelRegistroUniversidad.setVisible(false);
				textFieldNombreCarrera.setText("");
				textFieldNombreUniversidad.setText("");
				textFieldUbicacionUniversidad.setText("");
				cargarUniversidades();
			}
		});
		btnMenuAgregarCarrera.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnMenuAgregarCarrera.setBackground(SystemColor.control);
		btnMenuAgregarCarrera.setFont(new Font("Roboto", Font.PLAIN, 14));
		btnMenuAgregarCarrera.setBounds(27, 23, 201, 32);
		panelMenu.add(btnMenuAgregarCarrera);
		
		btnMenuAgregarUniversidad = new JButton("Agregar Universidad");
		btnMenuAgregarUniversidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelRegistroCarrera.setVisible(false);
				panelRegistroUniversidad.setVisible(true);
				textFieldNombreCarrera.setText("");
				textFieldNombreUniversidad.setText("");
				textFieldUbicacionUniversidad.setText("");
				cargarUniversidades();
			}
		});
		btnMenuAgregarUniversidad.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnMenuAgregarUniversidad.setBackground(SystemColor.control);
		btnMenuAgregarUniversidad.setFont(new Font("Roboto", Font.PLAIN, 14));
		btnMenuAgregarUniversidad.setBounds(27, 77, 201, 32);
		panelMenu.add(btnMenuAgregarUniversidad);
		
		panelRegistroUniversidad = new JPanel();
		panelRegistroUniversidad.setLayout(null);
		panelRegistroUniversidad.setBackground(Color.WHITE);
		panelRegistroUniversidad.setBounds(275, 11, 533, 323);
		panelRegistroUniversidad.setVisible(false);
		contentPane.add(panelRegistroUniversidad);
		
		containerRegistroUniversidad = new JPanel();
		containerRegistroUniversidad.setLayout(null);
		containerRegistroUniversidad.setBackground(Color.WHITE);
		containerRegistroUniversidad.setBounds(82, 54, 368, 214);
		panelRegistroUniversidad.add(containerRegistroUniversidad);
		
		textFieldNombreUniversidad = new JTextField();
		textFieldNombreUniversidad.setMargin(new Insets(5, 10, 5, 10));
		textFieldNombreUniversidad.setColumns(10);
		textFieldNombreUniversidad.setBounds(129, 34, 227, 32);
		containerRegistroUniversidad.add(textFieldNombreUniversidad);
		
		lblNombreUniversidad = new JLabel("Nombre");
		lblNombreUniversidad.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblNombreUniversidad.setBounds(10, 42, 132, 14);
		containerRegistroUniversidad.add(lblNombreUniversidad);
		
		lblUbicacionUniversidad = new JLabel("Ubicación");
		lblUbicacionUniversidad.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblUbicacionUniversidad.setBounds(10, 92, 132, 14);
		containerRegistroUniversidad.add(lblUbicacionUniversidad);
		
		btnAgregarUniversidad = new JButton("Agregar");
		btnAgregarUniversidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean continuar = true; 
				String nombreUniversidad = textFieldNombreUniversidad.getText();
				String ubicacionUniversidad = textFieldUbicacionUniversidad.getText();
				
				if(nombreUniversidad.equals("")) {
					continuar = false;
				}
				
				if(continuar) {
					
					if(DAOUniversidad.buscarNombre(nombreUniversidad) == null) {
					
						Universidad u = new Universidad(nombreUniversidad,ubicacionUniversidad);
						DAOUniversidad.insertUniversidad(u);
						
						cargarUniversidades();
						
					}else {
						
					}					
					
				}
			}
		});
		btnAgregarUniversidad.setFont(new Font("Roboto", Font.PLAIN, 14));
		btnAgregarUniversidad.setBackground(SystemColor.menu);
		btnAgregarUniversidad.setBounds(120, 158, 127, 32);
		containerRegistroUniversidad.add(btnAgregarUniversidad);
		
		textFieldUbicacionUniversidad = new JTextField();
		textFieldUbicacionUniversidad.setMargin(new Insets(5, 10, 5, 10));
		textFieldUbicacionUniversidad.setColumns(10);
		textFieldUbicacionUniversidad.setBounds(129, 83, 227, 32);
		containerRegistroUniversidad.add(textFieldUbicacionUniversidad);
		
	}
}
