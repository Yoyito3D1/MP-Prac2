package DadesDin;

import DadesDin.Node;
import Dades.Persona;

public class Node {
	private Persona info;
	public Node next;				//contingut node
	

	public Node (Persona test, Node seg) {
		info = test;							
		next = seg;
	}
	
	public Persona getPersona() {
		return info;
	}
	
	public Node getNext() {
		return next;
	}
	
	public void setPersona(Persona pers) {
		info=pers;	
	}
	
	public void setNext(Node segu) {
		next=segu;	
	}

	public Node copia() {
		Node nod = new Node(info , next );
		return nod;
	}
}