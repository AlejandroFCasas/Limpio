
package validaciones;

import javax.swing.JOptionPane;

public class Validaciones {

	public static String validarFecha(String op) {
		int i = 0;

		String ñ = " ";
		for (i = 0; i < op.length(); i++) {

			if (op.charAt(i) >= '0' && op.charAt(i) <= '9'
					|| op.charAt(i) == '/') {
				ñ = op;

			} else {

				JOptionPane.showMessageDialog(null, "Datos no validos",
						"Error", JOptionPane.ERROR_MESSAGE);
				i = 40;
				ñ = " ";
			}
		}
		return ñ;
	}

	public static int validarInt(String op, String texto) {
		int temp = 0;

		try {

			temp = Integer.parseInt(op);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Datos no validos", "Error",
					JOptionPane.ERROR_MESSAGE);

			return -1;
		}
		return temp;
	}
	
	public static int validarChar(String op, String texto) {
		int temp = 0;

		try {

			temp = Integer.parseInt(op);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Datos no validos", "Error",
					JOptionPane.ERROR_MESSAGE);

			return -1;
		}
		return temp;
	}

	public static double validarDouble(String op, String texto) {
		double temp = 0;

		try {
			temp = Double.parseDouble(op);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error en datos ingresados",
					"Error", JOptionPane.ERROR);
			return -1;
		}

		return temp;
	}

	public static String validarString(String op) {
		int i = 0;

		String ñ = " ";
		for (i = 0; i < op.length(); i++) {

			if (op.charAt(i) >= 'a' && op.charAt(i) <= 'z'
					|| op.charAt(i) >= 'A' && op.charAt(i) <= 'Z'
					|| op.charAt(i) == ' ' && op.charAt(i) == ' '
					|| op.charAt(i) == ',') {
				ñ = op;

			} else {

				JOptionPane.showMessageDialog(null, "Datos no validos",
						"Error", JOptionPane.ERROR_MESSAGE);
				i = 40;
				ñ = " ";
			}
		}

		return ñ;
	}
}

 