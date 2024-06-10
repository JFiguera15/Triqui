package vista;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import modelo.Triqui;

public class PanelPartida extends JPanel{

	// Atributos
	private JLabel turno;
	private JLabel jugador1;
	private JLabel jugador2;

	//Constructor
	/**
	 * Crea un nuevo panel de partida.<br>
	 * <b> post: </b> Se crea un nuevo panel de partida con 3 JLabels, para el turno actual y el numero de movimientos de ambos jugadores. 
	 */ 
	public PanelPartida() {
		setLayout(new GridLayout(5,1));
		setBorder(new TitledBorder("Partida"));
		turno = new JLabel("Turno: Jugador 1");
		jugador1 = new JLabel("# de movimientos J1: 0");
		jugador2 = new JLabel("# de movimientos J2: 0");
		add(turno);
		add(jugador1);
		add(jugador2);
		setVisible(true);
	}

	//Metodos
	/**
	 * Muestra el turno actual de la partida.<br>
	 * <b> post: </b> Actualiza el JLabel "turno" para mostrar de quien es el turno actual. 
	 * @param pTurno Turno actual de la partida (false para J1, true para J2)
	 */
	public void cambiarTurno(boolean pTurno) {
		if(pTurno == false) {
			turno.setText("Turno: Jugador 1");
		} else {
			turno.setText("Turno: Jugador 2");
		}
	} 
	/**
	 * Muestra el numero de movimientos actual del J1.<br>
	 * <b> post: </b> El JLabel "jugador1" es actualizado para mostrar el numero de movimientos actual del J1.
	 * @param pMovimientos Numero de movimientos actual del J1
	 */
	public void actualizarNumeroMovimientosJugador1(int pMovimientos) {
		jugador1.setText("# de movimientos J1:" + " " + pMovimientos);
	}
	/**
	 * Muestra el numero de movimientos actual del J2.<br>
	 * <b> post: </b> El JLabel "jugador2" es actualizado para mostrar el numero de movimientos actual del J2.
	 * @param pMovimientos Numero de movimientos actual del J2
	 */
	public void actualizarNumeroMovimientosJugador2(int pMovimientos) {
		jugador2.setText("# de movimientos J2:" + " " + pMovimientos);
	}



}
