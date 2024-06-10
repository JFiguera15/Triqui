package vista;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import controlador.TorreDeControl;
import modelo.Casilla;

public class Ventana extends JFrame implements ActionListener {
	//Constantes
	public static final String REINICIAR = "Reiniciar";

	public static final String GUARDAR = "Guardar";

	public static final String CARGAR = "Cargar";

	//Atributos
	private PanelTablero panelTablero;

	private PanelMatrix panelMatrix;

	private TorreDeControl controlador;

	//Constructor
	/**
	 * Crea una nueva ventana principal.
	 * <b> post: </b> Se crea una ventana principal, con titulo "Triqui", de tamaño 500x500, del cual no se puede cambiar. Con todos los paneles necesarios.
	 * @param pControlador Controlador de el programa.
	 */
	public Ventana(TorreDeControl pControlador) {
		controlador = pControlador;
		setTitle("Triqui");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500, 500);
		setResizable(false);
		setLayout(new BorderLayout());
		panelTablero = new PanelTablero(this);	
		panelMatrix = new PanelMatrix(this);
		add(panelTablero, BorderLayout.CENTER);
		add(panelMatrix, BorderLayout.EAST);
		setVisible(true);
	}
	
	//Metodos

	/**
	 * Actualiza el PanelTablero segun la matriz que recibe por parametro.
	 * @param matriz Matriz de casillas.
	 */
	public void actualizarPanelTablero(Casilla[][] matriz) {
		panelTablero.actualizarPanel(matriz);
	}
	
	/**
	 * Verifica si la casilla presionada esta ocupada por el jugador actual o su oponente.<br>
	 * <b> post: </b> Muestra un JOptionPane diciendo que la casilla esta ocupada por el jugador actual o por su oponente, dependiendo de su estado actual.
	 * @param pTipo Tipo de la casilla.
	 * @param pTurno Turno actual de la partida.
	 */
	public void casillaOcupada(int pTipo, boolean pTurno) {
		if(pTipo == 1) {
			if(pTurno == false) {
				JOptionPane.showMessageDialog(this, "Esta casilla ya esta ocupada por ti");
			} else {
				JOptionPane.showMessageDialog(this, "Esta casilla ya esta ocupada por tu oponente");
			}
		} else if (pTipo == 2) {
			if (pTurno == true) {
				JOptionPane.showMessageDialog(this, "Esta casilla ya esta ocupada por ti");
			} else {
				JOptionPane.showMessageDialog(this, "Esta casilla ya esta ocupada por tu oponente");
			}
		}
	}
	
	/**
	 * Notifica quien gano la partida.<br>
	 * <b>post:</b> Muestra un JOptionPane diciendo cual jugador gano la partida.
	 * @param pTurno Turno actual de la partida.
	 */
	public void notificarQueHayJugador(boolean pTurno) {
		if(pTurno == false) {
			JOptionPane.showMessageDialog(this, "Gano el Jugador 2");
		} else {
			JOptionPane.showMessageDialog(this, "Gano el Jugador 1");
		}
		panelTablero.inhabilitarTablero();
	}

	/**
	 * Llama al metodo para actualizar el turno en el PanelMatrix.<br>
	 * <b>post:</b> Muestra el turno actual de la partida en el PanelPartida
	 */
	public void actualizarPanelPartida() {
		panelMatrix.actualizarTurno(controlador.cambiarTurno());
	}
	/**
	 * Llama al metodo para actualizar el numero de movimientos del J1 en el PanelMatrix.<br>
	 * <b>post: </b>Actualiza el numero de movimientos del J1 en el PanelPartida. 
	 */
	public void actualizarMovimientosJugador1() {
		panelMatrix.actualizarMovimientosJugador1(controlador.darNumeroMovimientosJugador1());
	}
	/**
	 * Llama al metodo para actualizar el numero de movimientos del J2 en el PanelMatrix.<br>
	 * <b>post: </b>Actualiza el numero de movimientos del J2 en el PanelPartida. 
	 */
	public void actualizarMovimientosJugador2() {
		panelMatrix.actualizarMovimientosJugador2(controlador.darNumeroMovimientosJugador2());
	}
	/**
	 * LLama el metodo para actualizar el turno en el PanelMatrix.<br>
	 * <b>post:</b>Actualiza el turno en el PanelMatrix.
	 */
	public void actualizarTurno() {
		panelMatrix.actualizarTurno(controlador.darTurno());
	}

	@Override
	/**
	 * Escucha los botones presionados, y actua segun cual se presione.
	 */
	public void actionPerformed(ActionEvent evento) {
		String comando = evento.getActionCommand();

		if(comando.equals(REINICIAR)) {
			controlador.reiniciar();
			panelTablero.habilitarTablero();
		} else if(comando.equals(GUARDAR)) {
			controlador.guardarPartida();
		} else if (comando.equals(CARGAR)) { 
			controlador.cargarPartida();

		} else {
			String[] posiciones = comando.split(",");
			int fila = Integer.parseInt(posiciones[0]);
			int columna = Integer.parseInt(posiciones[1]);
			controlador.actualizarCasilla(fila, columna);
			actualizarPanelPartida();
			actualizarMovimientosJugador1();
			actualizarMovimientosJugador2();
		}

	}

}
