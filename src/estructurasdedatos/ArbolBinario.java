package estructurasdedatos;

import objetos.*;

public class ArbolBinario implements Comparable<Object> {

	private static NodoBinario raiz;
	private NodoBinario O;
	
	// Buscar un elemento.
	public NodoBinario Buscar(NodoBinario raiz, Comparable O,Comparable String) {
		//if (raiz.getDato() == O.getDato()) {
		if (((Comparable)raiz.dato).compareTo((String) O) == 0) {
		
		
			
			//System.out.println("el elemento existe en el arbol");
		return null;
		}
		//if (raiz.getIzquierdo().getDato() > O.getDato()) {
		if (raiz.getIzquierdo()!= null&&((Comparable)raiz.getIzquierdo().getDato()).compareTo(O) > 0) {	
			return null ;
		}
		
		//if (raiz.getDerecho().getDato() < O.getDato()) {
		if (raiz.getDerecho()!= null&&((Comparable)raiz.getDerecho().getDato()).compareTo(O) < 0){
			return null ;
		}
		/*if (raiz.getIzquierdo()!= null) {
			Buscar(raiz.getIzquierdo(),O);
		}
		if (raiz.izquierdo != null) {
			Buscar(raiz.getDerecho(),O);
		}
		
		*/
		System.out.println("No se encontro el elemento buscado");
		return null;

	}

	public NodoBinario BuscarE(NodoBinario raiz, Comparable O) {
		//if (raiz.getDato() == O.getDato()) {
		if (((Comparable)raiz.dato).compareTo(((String)O)) == 0) {
			return (NodoBinario) raiz.dato;			
			}
		
		if (((Comparable)raiz.dato).compareTo(((String)O)) == 0) {
			return (NodoBinario) raiz.dato;			
			}
	/*	if (((Competencia)raiz.dato).getDisciplina().compareTo(((String)O)) == 0) {
			p.inserta(p.getCab(),((Competencia)raiz.dato) );		
			}

		*/
		//System.out.println("el elemento existe en el arbol");		
		//if (raiz.getIzquierdo().getDato() > O.getDato()) {
		if (raiz.getIzquierdo()!= null&&((Comparable)raiz.getIzquierdo().getDato()).compareTo(O) > 0) {	
			return BuscarE (raiz.getIzquierdo(),O);
		}
		
		//if (raiz.getDerecho().getDato() < O.getDato()) {
		if (raiz.getDerecho()!= null&&((Comparable)raiz.getDerecho().getDato()).compareTo(O) < 0){
			return BuscarE (raiz.getDerecho(),O);
		}
		/*if (raiz.getIzquierdo()!= null) {
			Buscar(raiz.getIzquierdo(),O);
		}
		if (raiz.izquierdo != null) {
			Buscar(raiz.getDerecho(),O);
		}
		
		*/
		System.out.println("No se encontro el elemento buscado");
		return null;

	}
	
	
	
	public NodoBinario Buscarem(NodoBinario raiz, Comparable O, Pila p) {
		//if (raiz.getDato() == O.getDato()) {
		if (((Comparable)raiz.dato).compareTo(O) == 0) {
		p.inserta(p.getCab(),((Comparable)raiz.dato) );
		
		
		
		//System.out.println("el elemento existe en el arbol");

		}
		//if (raiz.getIzquierdo().getDato() > O.getDato()) {
		if (raiz.getIzquierdo()!= null&&((Comparable)raiz.getIzquierdo().getDato()).compareTo(O) > 0) {	
			return Buscarem (raiz.getIzquierdo(),O,p);
		}
		
		//if (raiz.getDerecho().getDato() < O.getDato()) {
		if (raiz.getDerecho()!= null&&((Comparable)raiz.getDerecho().getDato()).compareTo(O) < 0){
			return Buscarem (raiz.getDerecho(),O,p);
		}
		
		
		/*if (raiz.getIzquierdo()!= null) {
			Buscar(raiz.getIzquierdo(),O);
		}
		if (raiz.izquierdo != null) {
			Buscar(raiz.getDerecho(),O);
		}
		
		*/
		System.out.println("No se encontro el elemento buscado");
		return null;

	}
	
	
	
		//if (((Persona)raiz.dato).compareTo(O) == 0) {
			public boolean Eliminar(NodoBinario raiz,Comparable O) {

				//if (((Persona)raiz.getIzquierdo().getDato()).compareTo(O) == 0) {
				if (raiz.getIzquierdo()!=null&&((Comparable)raiz.getIzquierdo().dato).compareTo(O) == 0) {
				if (raiz.getIzquierdo().getIzquierdo()!=null){
						raiz.setIzquierdo(raiz.getIzquierdo().getIzquierdo());
						return false;
				}
					else
						raiz.setIzquierdo(null);
						return false;
				}
			
				if (raiz.getDerecho()!=null&&((Comparable)raiz.getDerecho().dato).compareTo(O) == 0) {
					if (raiz.getDerecho().getDerecho()!=null){
							raiz.setDerecho(raiz.getDerecho().getDerecho());
							return false;
					}
						else
							raiz.setDerecho(null);
							return false;
					
					}			
					if (raiz.getIzquierdo() != null && raiz.getDerecho() != null) {
						if (raiz.getIzquierdo().getDato() == O) {
							raiz.setIzquierdo(MasIzq(raiz.getIzquierdo()));
						}
						if (raiz.getDerecho().getDato() == O) {
							raiz.setDerecho(MasDer(raiz.getDerecho()));
						}
					}
				return false;
			}
			// es hoja ?
			// calcular altura y nivel de un arbol

	public NodoBinario MasIzq(NodoBinario Raiz) {

		if (raiz.getIzquierdo() == null) {

			return raiz.getIzquierdo();

		}

		return MasIzq(raiz.getIzquierdo());

	}

	public void esHoja(NodoBinario Nodo) {
		if (Nodo.getIzquierdo() == null && Nodo.getDerecho() == null)
			System.out.println("Es hoja");
		else
			System.out.println("No es hoja");

	}

	public NodoBinario MasDer(NodoBinario Raiz) {
		if (raiz.getDerecho() == null) {
			return raiz.getDerecho();
		}
		return MasDer(raiz.getDerecho());

	}

	public int altura(NodoBinario n) {
		if (n == null)
			return 0;
		else
			return 1 + Math.max(altura(n.getDerecho()),
					altura(n.getIzquierdo()));
	}

	public int nivel(NodoBinario n) {
		if (n == null)
			return 0;
		else
			return Math.max(altura(n.getDerecho()), altura(n.getIzquierdo()));
	}


	public ArbolBinario() {
	}

	public ArbolBinario(NodoBinario raiz) {
		this.raiz = raiz;
	}

	public boolean esVacio() {

		if (ArbolBinario.raiz == null) {
			System.out.print("El Arbol esta vacio");
			return false;
		} else
			System.out.print("El Arbol no esta vacio");

		return false;
	}

	public void PreOrder(NodoBinario raiz) {
		System.out.println(raiz.getDato().toString());
		if (raiz.izquierdo != null) {
			PreOrder(raiz.getIzquierdo());
		}
		if (raiz.derecho != null) {
			PreOrder(raiz.getDerecho());

		}

	}

	public void InOrder(NodoBinario raiz) {
		if (raiz.izquierdo != null) {
			InOrder(raiz.getIzquierdo());
		}

		System.out.println(raiz.getDato().toString());

		if (raiz.getDerecho() != null) {
			InOrder(raiz.getDerecho());
		}

	}

	public void PostOrder(NodoBinario raiz) {

		if (raiz.izquierdo != null) {
			PostOrder(raiz.getIzquierdo());
		}

		if (raiz.getDerecho() != null) {
			PostOrder(raiz.getDerecho());
		}
		System.out.println(raiz.getDato().toString());
	}

	public boolean raiz() {
		if (raiz == null) {
			return true;
		} else {
			return false;
		}
	}

	public void insertar(Comparable p) {
		// NodoBinario p= New NodoBinario (Object D);
		if (ArbolBinario.raiz == null) {
			raiz = new NodoBinario(p);
		} else {
			NodoBinario O = new NodoBinario((Comparable) p);
			ArbolBinario.Insertar(raiz, (NodoBinario) O);
		}
	}

	// revisar
	public static boolean Insertar(NodoBinario raiz, NodoBinario D) {
		//if (((Persona)raiz.dato).compareTo(D.getDato()) == 0) {
			
		if (((Comparable)raiz.dato).compareTo(D.getDato()) == 0) {
			
			System.out.print("Ya hay un nodo con el mismo valor");
			return true;
		} else if (raiz.dato.compareTo(D.getDato()) > 0) {
			raiz.setIzquierdo(D);
			return true;
		} else if (raiz.dato.compareTo(D.getDato()) < 0)
			raiz.setDerecho(D);

		return false;
	}

	public void imprimirArbol(NodoBinario O) {
		if (ArbolBinario.raiz == null) {
			System.out.print("No hay nodo en el Arbol");
		}
		return;
	}

	public NodoBinario getRaiz() {
		return raiz;
	}

	public void setRaiz(NodoBinario raiz) {
		this.raiz = raiz;
	}

	public int compareTo(Object arg0) {
		
		return 0;
	}
}
