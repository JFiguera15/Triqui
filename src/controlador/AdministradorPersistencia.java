package controlador;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JFileChooser;

import modelo.Triqui;
import vista.Ventana;

public class AdministradorPersistencia {
	
	//Atributo
	private Triqui modelo;
	
	//Constructor
	/**
	 * Crea un nuevo AdministradorPersistencia.<br>
	 * <b>post: </b> Crea un nuevo administrador para la persistencia, que conoce el modelo.
	 * @param pModelo Modelo de el programa.
	 */
	public AdministradorPersistencia(Triqui pModelo) {
		modelo = pModelo;
	}
	//Metodos
	/**
	 * Guarda la partida actual en un archivo .properties.<br>
	 * <b>post: </b>Crea un archivo llamado "juego.properties" en la carpeta datos.
	 * @throws IOException Si no se puede escribir el archivo.
	 */
	public void guardarPartida() throws IOException {
		File archivo = new File("./datos/juego.properties");		
		FileWriter fw = new FileWriter(archivo);
		BufferedWriter be = new BufferedWriter(fw);
		be.write("turno = " + modelo.darTurno() );
		be.newLine();
		be.write("MovimientosJ1 = " + modelo.darNumeroMovimientosJugador1());
		be.newLine();
		be.write("MovimientosJ2 = " + modelo.darNumeroMovimientoJugador2());
		be.newLine();
		int contador = 0;
		for(int i = 0; i < Triqui.FILAS; i++) {
			for (int j = 0; j < Triqui.COLUMNAS; j++) {

				be.write("casilla"+contador+ " = " + modelo.darTablero()[i][j].darTipo());
				be.newLine();
				contador++;

			}
		}


		be.close();
		fw.close();
	}

	/**
	 * Carga la partida segun el archivo .properties que se lea.<br>
	 * <b>post: </b> Abre un JFileChooser en la carpeta datos, y lee el archivo que se seleccione.
	 * @param pVentana Ventana principal
	 * @throws IOException Si no puede leer el archivo.
	 */
	public void cargarPartida(Ventana pVentana) throws IOException {

		File archivo = null;

		JFileChooser chooser = new JFileChooser("./datos");

		int returnVal = chooser.showOpenDialog(pVentana);
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			archivo = chooser.getSelectedFile();
		}

		FileInputStream fis = new FileInputStream(archivo);

		Properties propiedades = new Properties();
		propiedades.load(fis);

		String turnoTxt = propiedades.getProperty("turno");
		if(turnoTxt.equals("true")) {
			modelo.cambiarTurno(true);
		} else {
			modelo.cambiarTurno(false);
		}
		String movimientos1TxT = propiedades.getProperty("MovimientosJ1");
		int movimientos1 = Integer.parseInt(movimientos1TxT);
		modelo.cambiarNumeroMovimientosJ1(movimientos1);
		String movimientos2Txt = propiedades.getProperty("MovimientosJ2");
		int movimientos2 = Integer.parseInt(movimientos2Txt);
		modelo.cambiarNumeroMovimientosJ2(movimientos2);
		
		int contador = 0;

		for (int j = 0; j < Triqui.FILAS; j++) {
			for (int j2 = 0; j2 < Triqui.COLUMNAS; j2++) {
				String casillaTexto = propiedades.getProperty("casilla" + contador);
				int casilla = Integer.parseInt(casillaTexto);
				modelo.darTablero()[j][j2].cambiarTipo(casilla);
				contador++;
			}

		}


	}

}
