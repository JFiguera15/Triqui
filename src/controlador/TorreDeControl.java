package controlador;

import java.io.IOException;

import modelo.Casilla;
import modelo.Triqui;
import vista.Ventana;

public class TorreDeControl {
	//Atributos
	private Triqui modelo;

	private Ventana vista;
	
	private AdministradorPersistencia admin;
	
	//Contructor
	/**
	 * Se crea una nueva TorreDeControl.<br>
	 * <b>post: </b>Se genera un nuevo controlador, que tiene acceso al modelo, la vista, y la persistencia.
	 */
	public TorreDeControl() {
		modelo = new Triqui();
		vista = new Ventana(this);
		admin = new AdministradorPersistencia(modelo);
		vista.actualizarPanelTablero(modelo.darTablero());
	}
	//Metodos
	
	/**
	 * Reinicia la partida actual.
	 */
	public void reiniciar() {
		modelo.reiniciarPartida();
		Casilla[][] tablero = modelo.darTablero();
		vista.actualizarPanelTablero(tablero);
		vista.actualizarPanelPartida();
		vista.actualizarMovimientosJugador1();
		vista.actualizarMovimientosJugador2();
	}
	
	/**
	 * Da el turno actual de la partida.
	 * @return Turno actual de la partida.
	 */
	public boolean cambiarTurno() {
		return modelo.darTurno();
	}
	
	/**
	 * Da el numero de movimientos del J1.
	 * @return Numero de movimientos del J1.
	 */
	public int darNumeroMovimientosJugador1() {
		return modelo.darNumeroMovimientosJugador1();
	}
	/**
	 * Da el numero de movimientos del J2.
	 * @return Numero de movimientos del J2.
	 */
	public int darNumeroMovimientosJugador2() {
		return modelo.darNumeroMovimientoJugador2();
	}
	
	/**
	 * Actualiza la casilla segun lo que se reciba por parametro.
	 * @param fila Fila de la casilla que se quiere actualizar.
	 * @param columna Columna de la casilla que se quiere actualizar.
	 */
	public void actualizarCasilla(int fila, int columna) {
		boolean seActualizo = modelo.actualizarCasilla(fila, columna);
		Casilla[][] tablero = modelo.darTablero();
		vista.actualizarPanelTablero(tablero);
		boolean respuesta = modelo.verificarPartida();
		if(seActualizo == true) {
			if(respuesta == true) {
				vista.notificarQueHayJugador(modelo.darTurno());
			}
		} else {
			vista.casillaOcupada(modelo.darTablero()[fila][columna].darTipo(), modelo.darTurno());
		}

	}
	
	/**
	 * Retorna el turno actual.
	 * @return El turno en la partida.
	 */
	public boolean darTurno() {
		return modelo.darTurno();
	}
	
	/**
	 * Guarda la partida actual.
	 */
	public void guardarPartida() {
		try {
			admin.guardarPartida();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Carga una partida anterior.
	 */
	public void cargarPartida() {
		try {
			admin.cargarPartida(vista);
			vista.actualizarPanelTablero(modelo.darTablero());
			vista.actualizarMovimientosJugador1();
			vista.actualizarMovimientosJugador2();
			vista.actualizarTurno();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Metodo main
	public static void main(String[] args) {
		TorreDeControl control = new TorreDeControl();
	}


}
