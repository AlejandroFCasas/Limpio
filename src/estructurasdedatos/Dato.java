package estructurasdedatos;

public class Dato implements Comparable {
	private int valor;

	public Dato() {
		this(0);
	}

	public Dato(int valor) {
		this.valor = valor;
	}

	public int compareTo(Object o) {
		Dato nuevoDato = (Dato) o;
		if (this.valor > nuevoDato.valor) {
			return 1;
		} else if (this.valor < nuevoDato.valor) {
			return -1;
		} else {
			return 0;
		}
	}

}
