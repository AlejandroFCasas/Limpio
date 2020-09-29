

package estructurasdedatos;

import javax.swing.JTextArea;


public interface Ilistadoble {
public  void insertar(Nodod ref,Object O);
public boolean eliminar(Nodod a,String id);
public Object buscar(Nodod ref, String I);
public void mostrarDescendente(Nodod n,JTextArea mostrar);
public void mostrarAscendente(Nodod n,JTextArea mostrar);
public void vaciar(Nodod a);
}
