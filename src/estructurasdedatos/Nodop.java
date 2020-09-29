
package estructurasdedatos;


public class Nodop {

    private Object I;
    private Nodop sig;

    public Nodop() {
        this.I = null;
        this.sig = null;
    }

    public Nodop(Object I, Nodop s) {
        this.I = I;
        this.sig = s;
    }

    public Nodop(Object I) {
        this.I = I;
        this.sig = null;

    }

    public Nodop(Nodop sig) {
        this.sig = sig;
    }

    public Object getI() {
        return I;
    }

    public void setI(Object i) {
        I = i;
    }

    public Nodop getSig() {
        return sig;
    }

    public void setSig(Nodop sig) {
        this.sig = sig;
    }
}

/*package objetos;

import java.util.LinkedList;
import java.util.List;

public class Usuario implements Comparable {

	private String email;
	private List dispositivos;

	public Usuario() {

	}

	public Usuario(String Email, List L) {
		this.email = Email;
		this.dispositivos = L;

	}
	
	public Usuario(String Email) {
		this.email = Email;
		this.dispositivos =  new LinkedList( );

	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List getDispositivos() {
		return dispositivos;
	}

	public void setDispositivos(List dispositivos) {
		this.dispositivos = dispositivos;
	}

	// IMPORTANTE
	public int compareTo(Object d1) {
		// return this.nombre.compareTo(((Dueño)d1).getNombre());

		return this.email.compareTo(((Usuario) d1).getEmail());

	}
	
	
	
	public String toString() {
		return this.email + " ";
		
		
		
		
	}
	/*
	public int compareTo(Competencia d1) {
		// return this.nombre.compareTo(((Dueño)d1).getNombre());

		return this.disciplina.compareTo(((Competencia) d1).getDisciplina());

	}

	public int compareTo(Comparable d1) {
		// return this.nombre.compareTo(((Dueño)d1).getNombre());

		return this.disciplina.compareTo((String) d1);

	}

	public String toString() {
		return this.disciplina + " " + this.equipo1 + " " + this.equipo2 + " "
				+ this.comentario + " " + this.arbitro + " " + this.resultado
				+ " " + this.ID + "\n";
	}

	 * public int compareTo(Competencia o) { return
	 * this.nombre.compareTo(o.nombre); }
	 

*/
