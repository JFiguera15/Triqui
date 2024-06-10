package modelo;

public class Casilla {
	
	//Constantes
	public static final int VACIA = 0;
	
	public static final int JUGADOR_1 = 1;
	
	public static final int JUGADOR_2 = 2;
	
	private int tipo;
	
	// Constructor
	
	/**
	 * Construye una nueva casilla. <br>
	 * <b> post: </b> Se inicializa el tipo inicial de la casilla como vacio.
	 */
	public Casilla() {
		tipo = VACIA;
	}
	
	//Metodos
	
	/**
	 * Retorna el tipo de la casilla
	 * @return int tipo
	 */
	public int darTipo() {
		return tipo;
	}
	/**
	 * Cambia el tipo de la casilla
	 * @param pTipo Tipo de la casilla. 0 == VACIA, 1 == JUGADOR_1, 2 == JUGADOR_2. 
	 */
	public void cambiarTipo(int pTipo) {
		tipo = pTipo;
	}

}
