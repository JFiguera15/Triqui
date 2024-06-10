package vista;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class PanelMatrix extends JPanel{
	
	//Atributos
	private PanelPartida panelPartida;
	private PanelOperaciones panelOperaciones;
	private Ventana principal;
	
	//Constructor
	/**
	 * Crea un nuevo PanelMatrix.<br>
	 * <b> post: </b> Un nuevo panel matrix es creado, que con tiene un PanelPartida y un PanelOperaciones.
	 * @param pVentana La ventana principal necesaria para el PanelOperaciones
	 */
	public PanelMatrix(Ventana pVentana) {
		principal = pVentana;
		setLayout(new BorderLayout());
		panelPartida = new PanelPartida();
		panelOperaciones = new PanelOperaciones(pVentana);
		add(panelPartida, BorderLayout.CENTER);
		add(panelOperaciones, BorderLayout.SOUTH);
		setVisible(true);
	}	
	
	//Metodos
		/**
		 * Llama al metodo para actualizar el turno en el PanelPartida.<br>
		 * <b> post: </b> Se actualiza el JLabel con el turno en el PanelPartida.
		 * @param pTurno Turno actual de la partida.
		 */
		public void actualizarTurno(boolean pTurno)
		{
			panelPartida.cambiarTurno(pTurno);
		}
		
		/**
		 * Llama al metodo para actualizar el numero de movimientos del J1 en el PanelPartida.<br>
		 * <b> post: </b> Se actualiza el JLabel con el numero de movimientos del J1 en el PanelPartida.
		 * @param pMovimientos Movimientos de el J1.
		 */
		public void actualizarMovimientosJugador1(int pMovimientos) {
			panelPartida.actualizarNumeroMovimientosJugador1(pMovimientos);
		}
		
		/**
		 * Llama al metodo para actualizar el numero de movimientos del J2 en el PanelPartida.<br>
		 * <b> post: </b> Se actualiza el JLabel con el numero de movimientos del J2 en el PanelPartida.
		 * @param pMovimientos Movimientos de el J2.
		 */
		public void actualizarMovimientosJugador2(int pMovimientos) {
			panelPartida.actualizarNumeroMovimientosJugador2(pMovimientos);
		}
}
