package estructurasdedatos;

public class NodoBinario {

	protected Comparable dato;
	protected NodoBinario izquierdo;
	protected NodoBinario derecho;
	
	
	public NodoBinario() {
	
	this(null);
	}
	public NodoBinario(Comparable Dato) {
		this.dato=Dato;
		this.izquierdo=null;
		this.derecho=null;
	
		
		

		}
	
	public NodoBinario(Comparable dato, NodoBinario izquierdo,NodoBinario derecho) {
		this.dato=dato;
		this.izquierdo=izquierdo;
		this.derecho=derecho;
		
	
	}
	public Object getDato() {
		return dato;
	}
	public void setDato(Comparable dato) {
		this.dato = dato;
	}
	public NodoBinario getIzquierdo() {
		return izquierdo;
	}
	public void setIzquierdo(NodoBinario izquierdo) {
		this.izquierdo = izquierdo;
	}
	public NodoBinario getDerecho() {
		return derecho;
	}
	public void setDerecho(NodoBinario derecho) {
		this.derecho = derecho;
	}
	
	
	
	
}