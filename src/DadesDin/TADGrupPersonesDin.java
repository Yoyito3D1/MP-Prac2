package DadesDin;

import Dades.Persona;

public interface TADGrupPersonesDin {
	
	/** 
	 * Afegeix la informacio de persona al conjunt mentre hi ha espai.
	 * @param p, n la persona a afegir al conjunt a un node
	 */
	void afegir(Persona p, Node n) ;
	
	/**
	 * Elimina totes les dades de consulta d'un recurs del conjunt
	 * @param recurs - les dades d'una consulta a eliminar del conjunt
	 */
	void eliminarPerComplet(int recurs);
	
	/**
	 * Elimina totes les dades de consulta d'un recurs del conjunt d'un dia determinat 
	 * @param recurs, data - les dades d'una consulta a eliminar del conjunt donada una data
	 */
	void eliminarPerData(String recurs, String data) ;
	
	/**
	 * Retorna la llista de persones que te el conjunt donat un recurs
	 * @param recurs a buscar els elements 
	 * @return node numero d'elements que hi ha en el conjunt
	 */
	Node numElemsPerRecurs(String recurs) ;
	
	/**
	 * Retorna la llista de persones que te el conjunt donat un recurs i una data determinada
	 * @param recurs, data a buscar els elements
	 * @return node numero d'elements que hi ha en el conjunt
	 */
	Node numElemsPerData(String recurs, String data) ;
	
	/** 
	 * Busca el recurs que ha estat consultat mes cops 
	 * @return el recurs que ha estat consultat mes cops
	 */
	int recursMesConsultat();
	
	/**
	 * Busca el nombre de recursos que ha consultat un usuari determinat
	 * @param nom el nom que volem buscar
	 * @return boolea tot els recuros que ha consultat un alies determinat
	 */
	public boolean[] recursosConsultatsPerAlies (String nom);
}
