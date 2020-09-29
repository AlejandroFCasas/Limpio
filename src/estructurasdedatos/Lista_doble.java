package estructurasdedatos;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;


public class Lista_doble implements Ilistadoble {
	private Icomparavalor comparar;// crear al inicion de la clase y luego
									// setear valor a la variable
	public Icomparavalor getComparar() {
		return comparar;
	}

	Nodod tmp;
	Nodod act;
	Nodod ant;
	Nodod cab;
	Nodod ult;

	public Nodod getUlt() {
		return ult;
	}

	public void setUlt(Nodod ult) {
		this.ult = ult;
	}

	public Nodod getAnt() {
		return ant;
	}

	public void setAnt(Nodod ant) {
		this.ant = ant;
	}

	public Nodod getCab() {
		return cab;
	}

	public void setCab(Nodod cab) {
		this.cab = cab;
	}

	public Lista_doble() {
		cab = new Nodod();
	}

	public Object buscar(Nodod ref, String I) {
		if (ref.getSig() == null) {
			return null;
		}

		if (ref.getSig() == null
				|| comparar.buscadordeigualdad(ref.getSig().getDato(), I)) {
			return ref.getSig().getDato();
		} else {
			if (comparar.buscadordeigualdad(ref.getSig().getSig().getDato(),
					I)) {

				return ref.getSig().getSig().getDato();
			}
			if (comparar.buscadordeigualdad(ult.getDato(), I)) {
				return ult.getDato();
			} else {
				
				act = ref.getSig();
		
			
				while (act != null) {
					if (comparar.buscadordeigualdad(act.getDato(), I)) {
						return act.getDato();

					}
					ant = act;
					act = act.getSig();

				}
				if (act == null) {
					return null;
				} else {
					
					return null;
				}
			}
		}
	}

	public boolean eliminar(Nodod a, String I) {
		if (a.getSig() == null) {
			return false;
		}

		if (a.getSig().getSig() == null
				&& comparar.buscadordeigualdad(a.getSig().getDato(), I)) {
		
			a.setAnt(null);
			a.setSig(null);
			ult = null;
			return true;
		}

		if (comparar.buscadordeigualdad(a.getSig().getDato(), I)) {
			a.getSig().setAnt(null);
			a.setSig(a.getSig().getSig());
			a.getSig().setAnt(a);
			return true;
		} else {
			act = a.getSig();

			while (act != null && comparar.buscadordeigualdad(a.getDato(), I)) {

				ant = act;
				act = act.getSig();
			}

			if (comparar.buscadordeigualdad(a.getDato(), I)) {
				ant.setSig(null);
				ult.setAnt(null);
				ult = ant;
				return true;
			}
			if (act == null) {
				return false;
			} else {
				ant.setSig(act.getSig());
				act.getSig().setAnt(ant);
				act = null;
				return true;
			}
		}
	}

	public void insertar(Nodod ref, Object O) {
		tmp = new Nodod(O);
		if (ref.getSig() == null) {

			ref.setSig(tmp);
			tmp.setAnt(ref);
			ult = tmp;
		} else {
			if (comparar.determinardeorden(O, cab.getSig().getDato()).equals(
					"menor")
					|| comparar.determinardeorden(O, cab.getSig().getDato())
							.equals("igual")) {

				tmp.setAnt(ref);
				ref.getSig().setAnt(tmp);
				tmp.setSig(ref.getSig());
				ref.setSig(tmp);
			} else {

				if (comparar.determinardeorden(O, ult.getDato())
						.equals("mayor")
						|| comparar
								.determinardeorden(O, cab.getSig().getDato())
								.equals("igual")) {

					ult.setSig(tmp);
					tmp.setAnt(ult);
					ult = tmp;
				} else {
					act = ref.getSig();

					while (comparar.determinardeorden(O, act.getDato()).equals(
							"mayor")) {
						ant = act;
						act = act.getSig();
					}

					tmp.setSig(act);
					act.setAnt(tmp);
					ant.setSig(tmp);
					tmp.setAnt(ant);
				}
			}
		}
	}

	public void mostrarDescendente(Nodod n, JTextArea mostrar) {

		ant = n;
		if (ant == null) {
			JOptionPane.showMessageDialog(null, "No hay elementos", "Lista",
					JOptionPane.ERROR_MESSAGE);
		} else {

			while (ant.getDato() != null) {

				String cadena;
				cadena = ant.getDato().toString()+"";
				
				mostrar.append(cadena);
				ant = ant.getAnt();
			}
			JOptionPane.showMessageDialog(null, mostrar,
					"Datos de orden de trabajo",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public void mostrarAscendente(Nodod n, JTextArea mostrar) {

		ant = n;
		if (ant == null) {
			JOptionPane.showMessageDialog(null, "No hay elementos", "Lista",
					JOptionPane.ERROR_MESSAGE);
		} else {

			while (ant.getSig() != null && ant.getSig().getDato() != null) {

				String cadena;
				cadena = ant.getSig().getDato() + "";
				mostrar.append(cadena);
				ant = ant.getSig();
			}
			JOptionPane.showMessageDialog(null, mostrar,
					"Datos de orden de trabajo",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public void vaciar(Nodod a) {
		a.getSig().setAnt(null);
		a.setSig(null);

	}

	public void setComparar(Icomparavalor comparar) {
		this.comparar = comparar;
	}

	

}
