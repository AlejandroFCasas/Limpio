

package estructurasdedatos;


public class Nodod {
private Object dato;
private Nodod sig;
private Nodod ant;
public Nodod(){
	this.sig=null;
	this.dato=null;
	this.ant=null;
}
public Nodod(Nodod sig,Nodod ant){
	this.ant=ant;
	this.sig=sig;
}
public Nodod(Nodod sig,Nodod ant, Integer r){
	this.dato=r;
	this.ant=ant;
	this.sig=sig;
}
public Nodod(Object d){
	this.dato=d;
        this.ant=null;
       this.sig=null;
}
public Nodod getAnt() {
	return ant;
}
public void setAnt(Nodod ant) {
	this.ant = ant;
}
public Object getDato() {
	return dato;
}
public void setDato(Object dato) {
	this.dato = dato;
}
public Nodod getSig() {
	return sig;
}
public void setSig(Nodod sig) {
	this.sig = sig;
}

}
