package Dades;

public interface TADGrupPersones {
	
	/** 
	 * Afegeix la informacio de persona al conjunt mentre hi ha espai.
	 * @param e - la persona a afegir al conjunt
	 * @return codiError: =1 si la persona s'ha afegit correctament al conjunt, =0 si la persona ja hi era, =-1 si no es pot afegit la persona (problemes espai, altres, ...)
	 */
	void afegir(Persona e) ;
	
	/**
	 * Elimina totes les dades de consulta d'un recurs del conjunt.
	 * @param recurs - les dades d'una consulta a eliminar del conjunt
	 * @return codiError: =1 si s'ha esborrat del conjunt, =0 si no s'ha esborrat perque  no hi era, =-1 qualsevol altre cas
	 */
	void eliminarPerComplet(int recurs);
	
	/**
	 * Elimina totes les dades de consulta d'un recurs del conjunt d'un dia determinat.
	 * @param recurs, data - les dades d'una consulta a eliminar del conjunt donada una data
	 */
	void eliminarPerData(String recurs, String data) ;
	
	/**
	 * Retorna el llistat de persones que te el conjunt donat un recurs.
	 * @param recurs, recurs que volem buscar
	 * @return llista d'elements que hi ha en el conjunt
	 */
	LlistaPersones numElemsPerRecurs(String recurs) ;
	
	/**
	 * Retorna el numero de persones que te el conjunt donat un recurs i una data determinada.
	 * @param recurs, data, recurs i data que volem buscar
	 * @return llista d'elements que hi ha en el conjunt
	 */
	LlistaPersones numElemsPerData(String recurs, String data) ;
	
	/** 
	 * Busca el recurs que ha estat consultat mes cops.
	 * @return el recurs que ha estat consultat mes cops
	 */
	int recursMesConsultat();
	
	/**
	 * Busca el nombre de recursos que ha consultat un usuari determinat.
	 * @param nom, nom que volem buscar
	 * @return tot els recuros que ha consultat un alies determinat
	 */
	public boolean[] recursosConsultatsPerAlies (String nom);
}
