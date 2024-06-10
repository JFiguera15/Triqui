package vista;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import modelo.Casilla;
import modelo.Triqui;

public class PanelTablero extends JPanel{
	//Atributos
	private JButton[][] matrizBotones;
	private Ventana principal;
	
	//Constructor
	/**
	 * Crea un nuevo PanelTablero.<br>
	 * <b> post: </b> Se crea un nuevo PanelTablero, con una matriz de botones (casillas) en blanco.
	 * @param pVentana Ventana principal que escuchara cuando se presione un boton.
	 */
	public PanelTablero(Ventana pVentana) {
		principal = pVentana;
		setLayout(new GridLayout(Triqui.FILAS,Triqui.COLUMNAS));
		setBorder(new TitledBorder("Tablero"));
		matrizBotones = new JButton[Triqui.FILAS][Triqui.COLUMNAS];
		inicializarBotones();
		cargarGrilla();
	}
	//Metodos
	
	/**
	 * Se inicializan los botones del tablero.
	 */
	public void inicializarBotones() {
		for (int i = 0; i < Triqui.FILAS; i++) {
			for (int j = 0; j < Triqui.COLUMNAS; j++) {
				matrizBotones[i][j] = new JButton("");
				matrizBotones[i][j].setActionCommand(i + "," + j);
				matrizBotones[i][j].addActionListener(principal);
			}
		}
	}
	/**
	 * Se carga la matriz de botones al panel.
	 */
	public void cargarGrilla() {
		for (int i = 0; i < Triqui.FILAS; i++) {
			for (int j = 0; j < Triqui.COLUMNAS; j++) {
				add(matrizBotones[i][j]);
			}
		}
		validate();
	}
	
	/**
	 * Se actualiza el panel siguiendo la matriz que se recibe por parametro.
	 * @param matriz Matriz de casillas en su estado actual del modelo.
	 */
	public void actualizarPanel(Casilla[][] matriz) {
		for (int i = 0; i < Triqui.FILAS; i++) {
			for (int j = 0; j < Triqui.COLUMNAS; j++) {
				if(matriz[i][j].darTipo() == Casilla.JUGADOR_1) {
					matrizBotones[i][j].setBackground(Color.RED);
				} else if (matriz[i][j].darTipo() == Casilla.JUGADOR_2) {
					matrizBotones[i][j].setBackground(Color.BLACK);
				} else {
					matrizBotones[i][j].setBackground(Color.WHITE);
				}
			}
		}
	}
	
	/**
	 * Bloquea el tablero.<br>
	 * <b> post: </b> El tablero queda inutilizado.
	 */
	public void inhabilitarTablero() {
		for (int i = 0; i < Triqui.FILAS; i++) {
			for (int j = 0; j < Triqui.COLUMNAS; j++) {
				matrizBotones[i][j].setEnabled(false);
			}
		}
	}
	
	/**
	 * Desblquea el tablero.<br>
	 * <b> post: </b> El tablero se puede volver a utilizar.
	 */
	public void habilitarTablero() {
		for (int i = 0; i < Triqui.FILAS; i++) {
			for (int j = 0; j < Triqui.COLUMNAS; j++) {
				matrizBotones[i][j].setEnabled(true);
			}
		}
	}

}
