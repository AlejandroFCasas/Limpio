

package estructurasdedatos;

import javax.swing.JTextArea;


public interface Ipila {
	public void inserta(Nodoc ref,Object O);
	public void eliminar(Nodoc ref);
	public void Mostrar (Nodoc ref,JTextArea mostrar);
	public void Consultarprimero(Nodoc ref);
}
