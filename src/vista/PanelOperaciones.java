package vista;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PanelOperaciones extends JPanel{
	
	//Atributos
	private JButton btnNueva;
	
	private JButton btnGuardar;
	
	private JButton btnCargar;

	private Ventana principal;
	
	//Constructor
	
	/**
	 * Crea un nuevo PanelOperaciones. <br>
	 * <b> post: </b> Se crea un nuevo PanelOperaciones, con 3 JButtons, uno para nueva partida, otro para guardar la partida actual y otro para cargar una partida anterior.
	 * @param pVentana Ventana que escuchara los gritos de los botones.
	 */
	public PanelOperaciones(Ventana pVentana) {
		principal = pVentana;
		setLayout(new BorderLayout());
		setBorder(new TitledBorder("Operaciones"));
		btnNueva = new JButton("Nueva Partida");
		btnNueva.setActionCommand(Ventana.REINICIAR);
		btnNueva.addActionListener(principal);
		btnGuardar = new JButton("Guardar Partida");
		btnGuardar.addActionListener(principal);
		btnGuardar.setActionCommand(Ventana.GUARDAR);
		btnCargar = new JButton("Cargar Partida");
		btnCargar.addActionListener(principal);
		btnCargar.setActionCommand(Ventana.CARGAR);
		add(btnNueva, BorderLayout.SOUTH);
		add(btnGuardar, BorderLayout.CENTER);
		add(btnCargar, BorderLayout.NORTH);
	}
}
