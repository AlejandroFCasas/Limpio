package menu ;
import javax.swing.JOptionPane;
import validaciones.Validaciones;

public class Menu {
	public static void menu() {
		int cursodeaccion;
		do {
			String opcion = JOptionPane.showInputDialog(null,"" +
					"1-Realizar el alta de un usuario\n" +
					"2-realizar carga de dispositivo\n" +
					"3-mostrar promedio de dispositivos por usuario\n" +
					"-salir","Menu", JOptionPane.INFORMATION_MESSAGE);
			
			cursodeaccion = Validaciones.validarInt(opcion,"error al ingresar opcion");
			Gestordemenu.recibeopcion(cursodeaccion);
		} while (true);
	}
}
