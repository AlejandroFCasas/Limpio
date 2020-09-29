package estructurasdedatos;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import objetos.*;



public class Pila implements Ipila{
	 private  Icomparavalor comparar ;//crear al inicion de la clase y luego setear valor a la variable
	    public Icomparavalor getComparar() {
			return comparar;
		}
	    

	
	private Nodoc act;
	private Nodoc cab;
	private Nodoc tmp;
	public Nodoc getCab() {
		return cab;
	}
	public void setCab(Nodoc cab) {
		this.cab = cab;
	}
	
	public Pila() {
		cab = new Nodoc();
		
	}


	    	    
	    	    
	public void Consultarprimero(Nodoc ref) {
		if(ref.getSig()!=null){
			JOptionPane.showMessageDialog(null,"Primero"+ref.getSig().getAnt(),"Pila",JOptionPane.INFORMATION_MESSAGE);
		}
		else{
		JOptionPane.showMessageDialog(null, "No hay elementos en la Pila", "Pila", JOptionPane.ERROR_MESSAGE);
		}
	}
	public void Mostrar(Nodoc ref) {
		act = ref.getSig();
        String cadena;
        if (act == null) {
			//JOptionPane.showMessageDialog(null, "No hay elementos en la Pila", "Pila", JOptionPane.ERROR_MESSAGE);
		} else {
			while (act != null) {
				cadena=act.getDato().toString();
               System.out.println(cadena);
				act = act.getSig();
			}
                      //JOptionPane.showMessageDialog(null, mostrar, "Datos de la Pila", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public void Mostrar1(Nodoc ref) {
		act = ref.getSig();
        String cadena;
        if (act == null) {
			//JOptionPane.showMessageDialog(null, "No hay elementos en la Pila", "Pila", JOptionPane.ERROR_MESSAGE);
		} else {
			while (act != null) {
				cadena=act.getDato().toString();
               System.out.println(cadena);
				act = act.getSig();
			}
                      //JOptionPane.showMessageDialog(null, mostrar, "Datos de la Pila", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	
	public void eliminar(Nodoc ref) {
		if(ref.getSig()==null){
			JOptionPane.showMessageDialog(null, "No hay elementos en la Pila", "Pila", JOptionPane.ERROR_MESSAGE);
		}
		else{
		ref.setSig(ref.getSig().getSig());
		}
	}
	public void inserta1(Nodoc ref, Object O) {
		
		tmp = new Nodoc(O);
		if (ref.getSig() == null){

			ref.setSig(tmp);

		}
		
		else {
			tmp.setSig(ref.getSig());
			ref.setSig(tmp);

		}
	}
	
	public void inserta(Nodoc ref, Object O) {
		
		tmp = new Nodoc(O);
		if (ref.getSig() == null){

			ref.setSig(tmp);

		}
		
		else {
			tmp.setSig(ref.getSig());
			ref.setSig(tmp);

		}
	}
	
	
	public void setComparar(Icomparavalor comparar) {
		this.comparar = comparar;
	}
	@Override
	public void Mostrar(Nodoc ref, JTextArea mostrar) {
		// TODO Auto-generated method stub
		
	}

	}
	
	