package estructurasdedatos;

import objetos.*;

public class Comparavalor implements Icomparavalor {
	// inicio de metodos que determinan igualdad
	public boolean igualdadint(int o, int cod) {
		if (o == cod) {

			return true;

		} else {

			return false;
		}
	}

	public boolean igualdadString(String o, String cod) {
		if (cod.equals((o))) {

			return true;
		} else {
			return false;
		}

	}

	public boolean igualdadint(Object o, int dato) {
		// METODO PARA COMPARAR DOUBLE INT
		return false;
	}

	public boolean igualdadDouble(Object o, double cod) {
		// METODO PARA COMPARAR DOUBLE
		return false;
	}

	// fin de metodos que determinan igualdad

	// inicio de metodos que determinan orden
	// public String ordenString(Object o, String cod) {
	public String ordenString(Object o, String cod) {
		if (((String) o).compareTo(cod) == 0) {
			return "igual";
		}
		if (((String) o).compareTo(cod) < 0) {
			return "menor";
		}
		return "mayor";

	}

	/*
	 * 
	 * public String ordenint(Object o, int dato) { if((Integer) o < (Integer)
	 * dato){ return "menor"; } if((Integer) o == (Integer) dato){ return
	 * "igual"; } return "mayor"; }
	 */

	public String ordenDouble(Object o, double cod) {
		// METODO PARA COMPARAR DOUBLE
		return "menor";
	}

	@Override
	public boolean buscadordeigualdad(Object valor, Object valor2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String determinardeorden(Object valor, Object valor2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean buscadordeigualdadint(Object valor1, int valor2) {
		// TODO Auto-generated method stub
		return false;
	}

	// fin de metodos que determinan orden
	/*

	public boolean buscadordeigualdadint(Object valor1, int valor2) {
		if (valor1 instanceof Terreno) {

			return igualdadint(((Terreno) valor1).getImporteventa(),
					((int) valor2));

		}
		return false;
	}

	public boolean buscadordeigualdad(Object valor1, Object valor2) {
		if (valor1 instanceof Terreno) {

			return igualdadString(((Terreno) valor1).getLocalidad(),
					((String) valor2));

		}
		return false;
	}

	public String determinardeorden(Object valor1, Object valor2) {
		if (valor2 instanceof Terreno) {

			return ordenString(((Terreno) valor1).getLocalidad(),
					((Terreno) valor2).getProvincia());
		}
		return null;

	}
*/
}
