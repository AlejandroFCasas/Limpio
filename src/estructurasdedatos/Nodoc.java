

package estructurasdedatos;


public class Nodoc {
private Object dato;
private Nodoc sig;
private Nodoc ant;
public Nodoc(){
	this.ant=null;
	this.dato=null;
	this.sig=null;
}
public Nodoc(Nodoc sig,Nodoc ant){
	this.ant=ant;
	this.sig=sig;
}
public Nodoc(Nodoc sig,Nodoc ant, Integer r){
	this.dato=r;
	this.ant=ant;
	this.sig=sig;
}
public Nodoc(Object d){
	this.dato=d;
}
public Nodoc getAnt() {
	return ant;
}
public void setAnt(Nodoc ant) {
	this.ant = ant;
}
public Object getDato() {
	return dato;
}
public void setDato(Object dato) {
	this.dato = dato;
}
public Nodoc getSig() {
	return sig;
}
public void setSig(Nodoc sig) {
	this.sig = sig;
}

}
