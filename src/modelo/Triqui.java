package modelo;

public class Triqui {
	
	// Constantes
	public final static int FILAS = 3;

	public final static int COLUMNAS = 3;

	//Atributos
	private Casilla[][] tablero;

	private boolean turno;
	
	private int numeroMovimientosJugador1;
	
	private int numeroMovimientoJugador2;
	// Constructor
	
	/**
	 * Construye un nuevo triqui. <br>
	 * <b> post: </b> Se inicializa un nuevo triqui, iniciando el turno en false (Jugador 1), y estableciendo el numero de movimientos para ambos jugadores en 0.
	 */ 
	public Triqui() {
		turno = false; 
		numeroMovimientosJugador1 = 0;
		numeroMovimientoJugador2 = 0;
		tablero = new Casilla[FILAS][COLUMNAS];
		inicializarTablero();
	}
	/**
	 * Retorna el tablero en su estado actual
	 * @return El tablero en su estado actual
	 */
	public Casilla[][] darTablero(){
		return tablero;
	}
	/**
	 * Retorna el turno actual
	 * @return El turno actual
	 */
	public boolean darTurno() {
		return turno;
	}
	
	/**
	 * Retorna el numero de movimientos del J1.
	 * @return Numero de movimientos del J1.
	 */
	public int darNumeroMovimientosJugador1() {
		return numeroMovimientosJugador1;
	}
	/**
	 * Retorna el numero de movimientos del J2.
	 * @return Numero de movimientos del J2.
	 */
	public int darNumeroMovimientoJugador2() {
		return numeroMovimientoJugador2;
	}
	
	/**
	 * Cambia el turno actual segun el parametro.
	 * @param pTurno Turno por el que se va a cambiar.
	 */
	public void cambiarTurno(boolean pTurno) {
		turno = pTurno;
	}
	
	/**
	 * Cambia el numero de movimientos del J1.
	 * @param pMovimientos Movimientos por los que se va a cambiar.
	 */
	public void cambiarNumeroMovimientosJ1(int pMovimientos) {
		numeroMovimientosJugador1 = pMovimientos;
	}
	
	/**
	 * Cambia el numero de movimientos del J1.
	 * @param pMovimientos Movimientos por los que se va a cambiar.
	 */
	public void cambiarNumeroMovimientosJ2(int pMovimientos) {
		numeroMovimientoJugador2 = pMovimientos;
	}
	
	/**
	 * Inicializa una matriz de casillas.<br>
	 * <b> post: </b> La matriz de tablero se llena de casillas vacias.
	 */
	public void inicializarTablero() {
		for (int i = 0; i < FILAS; i++) {
			for (int j = 0; j < COLUMNAS; j++) {
				tablero[i][j] = new Casilla();
			}
		}
	}
	/**
	 * Actualiza la casilla segun los parametros que posea.<br>
	 * <b> post: </b> La casilla en la posicion que se recibe por parametro es actualizada segun el turno actual.
	 * @param pX Fila de la casilla que se quiere actualizar.
	 * @param pY Columna de la casilla que se quiere actualizar.
	 * @return true si se actualizo la casilla, false si no se pudo actualizar.
	 */
	public boolean actualizarCasilla(int pX, int pY){
		boolean seActualizo = false;
		Casilla cas = tablero[pX][pY];

		if(cas.darTipo() == Casilla.VACIA){
			if(turno == false) { 
				tablero[pX][pY].cambiarTipo(Casilla.JUGADOR_1);
				turno = true;
				numeroMovimientosJugador1++;
			}
			else {
				tablero[pX][pY].cambiarTipo(Casilla.JUGADOR_2);
				turno = false;
				numeroMovimientoJugador2++;
			}
			seActualizo = true;
		}
		return seActualizo;
	}
	/**
	 * Verifica si hubo un ganador.<br>
	 * @return true si gano alguien, false si todavia no.
	 */
	public boolean verificarPartida() {
		boolean respuesta = false;
		if(validarDiagonalesJugador1() || validarDiagonalesJugador2() 
				|| validarFilasJugador1() || validarFilasJugador2() 
				|| validarColumnasJugador1() || validarColumnasJugador2()) {
			respuesta = true;
		}
		return respuesta;
	}
	
	/**
	 * Verfica si el jugador 1 gano con una diagonal.<br>
	 * @return true si gano, false si no.
	 */
	public boolean validarDiagonalesJugador1() {
		boolean respuesta = false;
		int contador = 0;
		for (int i = 0; i < FILAS; i++) {
			if(tablero[i][i].darTipo() == Casilla.JUGADOR_1) {
				contador++;
			}
		}
		if(contador == FILAS) {
			respuesta = true;
		}

		if(respuesta == false) {
			contador = 0;
			int f = FILAS - 1;
			for (int i = 0; i < FILAS && f >=0; i++) {	
				if(tablero[f][i].darTipo() == Casilla.JUGADOR_1) {
					contador++;
				}
				f--;
			}

			if(contador == FILAS) {
				respuesta = true;
			}
		}
		return respuesta;
	}
	
	/**
	 * Verfica si el jugador 2 gano con una diagonal.<br>
	 * @return true si gano, false si no.
	 */
	public boolean validarDiagonalesJugador2() {
		boolean respuesta = false;
		int contador = 0;
		for (int i = 0; i < FILAS; i++) {
			if(tablero[i][i].darTipo() == Casilla.JUGADOR_2) {
				contador++;
			}
		}
		if(contador == FILAS) {
			respuesta = true;
		}

		if(respuesta == false) {
			contador = 0;
			int f = FILAS - 1;
			for (int i = 0; i < FILAS && f >=0; i++) {
				if(tablero[f][i].darTipo() == Casilla.JUGADOR_2) {
					contador++;
				}
				f--;
			}

			if(contador == FILAS) {
				respuesta = true;
			}
		}
		return respuesta;
	}
	
	/**
	 * Verfica si el jugador 1 gano con una fila.
	 * @return true si gano, false si no.
	 */
	public boolean validarFilasJugador1() {
		boolean respuesta = false;
		for (int i = 0; i < FILAS && respuesta == false; i++) {
			int contador = 0;
			for (int j = 0; j < COLUMNAS; j++) {
				if(tablero[i][j].darTipo() == Casilla.JUGADOR_1) {
					contador++;
				}
			}
			if(contador == FILAS) {
				respuesta = true;
			}
		}


		return respuesta;
	}
	/**
	 * Verfica si el jugador 2 gano con una fila.
	 * @return true si gano, false si no.
	 */
	public boolean validarFilasJugador2() {
		boolean respuesta = false;
		for (int i = 0; i < FILAS && respuesta == false; i++) {
			int contador = 0;
			for (int j = 0; j < COLUMNAS; j++) {
				if(tablero[i][j].darTipo() == Casilla.JUGADOR_2) {
					contador++;
				}
			}
			if(contador == FILAS) {
				respuesta = true;
			}
		}


		return respuesta;
	}
	
	/**
	 * Verfica si el jugador 1 gano con una columna.
	 * @return true si gano, false si no.
	 */
	public boolean validarColumnasJugador1() {
		boolean respuesta = false;
		for (int j = 0; j < COLUMNAS && respuesta == false; j++) {
			int contador = 0;
			for (int i = 0; i < FILAS; i++) {
				if(tablero[i][j].darTipo() == Casilla.JUGADOR_1) {
					contador++;
				}
			}

			if(contador == COLUMNAS) {
				respuesta = true;
			}
		}

		return respuesta;
	}
	
	/**
	 * Verfica si el jugador 2 gano con una columna.
	 * @return true si gano, false si no.
	 */
	public boolean validarColumnasJugador2() {
		boolean respuesta = false;
		for (int j = 0; j < COLUMNAS && respuesta == false; j++) {
			int contador = 0;
			for (int i = 0; i < FILAS; i++) {
				if(tablero[i][j].darTipo() == Casilla.JUGADOR_2) {
					contador++;
				}
			}

			if(contador == COLUMNAS) {
				respuesta = true;
			}
		}

		return respuesta;
	}
	
	/**
	 * Reinicia la partida.<br>
	 * <b> post: </b> Vuelve a inicializar el tablero con casillas vacias, vuelve al turno del Jugador 1, deja los movimientos de ambos jugadores en 0. 
	 */
	public void reiniciarPartida() {
		inicializarTablero();
		turno = false;
		numeroMovimientosJugador1 = 0;
		numeroMovimientoJugador2 = 0;
	}

	
}
