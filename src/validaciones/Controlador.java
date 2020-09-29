
package validaciones;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Controlador {
	static String s;

	public static String ControladaFecha(String texto) {

		do {
			s = JOptionPane.showInputDialog(null, "Ingrese " + texto);
			if (s != null) {
				s = Validaciones.validarFecha(s);
			} else {
				s = " ";
			}

		} while (s == " ");
		return s;
	}

	public static int ControlaInt(String texto) {

		int controlado;
		do {
			s = JOptionPane.showInputDialog(null, "Ingrese " + texto);
			controlado = Validaciones.validarInt(s, texto);
		} while (controlado == -1);
		return controlado;
	}

	public static String ControladoString(String texto) {

		do {
			s = JOptionPane.showInputDialog(null, "Ingrese " + texto);
			if (s != null) {
				s = Validaciones.validarString(s);
			} else {
				s = " ";
			}

		} while (s == " ");
		return s;
	}

	public static double Controladouble(String texto) {

		double controlado;
		do {
			s = JOptionPane.showInputDialog(null, "Ingrese " + texto);
			controlado = Validaciones.validarDouble(s, texto);
		} while (controlado == -1);
		return controlado;
	}

}