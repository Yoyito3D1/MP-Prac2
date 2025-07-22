package Dades;

public class LlistaPersones implements TADGrupPersones {
	
	private Persona[] llistaPersones;
	private int numPersones;
	public static int numRecursos = 6;
	public static int numConsultesPerRecurs[] = new int[numRecursos];
	
	public LlistaPersones(int mida) {
		this.llistaPersones = new Persona[mida];
		this.numPersones = 0;
	}
	
	//Inicialitzem les dates 
	Data data = new Data(10, 4, 2000);
	Data dataAux = new Data(10, 5, 2000);
	
//------------------------------[Metode 1 TAD]------------------------------//
	
	/** 
	 * Afegeix la informacio de persona al conjunt mentre hi ha espai.
	 * @param e - la persona a afegir al conjunt
	 * @return codiError: =1 si la persona s'ha afegit correctament al conjunt, =0 si la persona ja hi era, =-1 si no es pot afegit la persona (problemes espai, altres, ...)
	 */
	public void afegir(Persona e) {
        if (numPersones < this.llistaPersones.length){
            Persona[] llistaAux = new Persona[numPersones+10];
            
            for (int i = 0; i < this.llistaPersones.length; i++) {
                llistaAux[i] = this.llistaPersones[i];
            }    
            this.llistaPersones = llistaAux;
        }
        numConsultesPerRecurs[Integer.valueOf(e.getRecursos())]++;
        this.llistaPersones[numPersones] = e.copia();
        numPersones++;    
    }
	
//------------------------------[Metode 2 TAD]------------------------------//

	/**
	 * Elimina totes les dades de consulta d'un recurs del conjunt.
	 * @param recurs - les dades d'una consulta a eliminar del conjunt
	 * @return codiError: =1 si s'ha esborrat del conjunt, =0 si no s'ha esborrat perque  no hi era, =-1 qualsevol altre cas
	 */
	public void eliminarPerComplet(int recurs) {
		 numConsultesPerRecurs[recurs] = 0;
	}
	
//------------------------------[Metode 3 TAD]------------------------------//

	/**
	 * Elimina totes les dades de consulta d'un recurs del conjunt d'un dia determinat.
	 * @param recurs, data - les dades d'una consulta a eliminar del conjunt donada una data
	 */
	public void eliminarPerData(String recurs, String data) {
		for(int i = 0; i < numPersones; i++) {
			if(llistaPersones[i].getData().equals(data) && llistaPersones[i].getRecursos().equals(recurs)) numConsultesPerRecurs[Integer.valueOf(recurs)]--;
			}
	}
		
//------------------------------[Metode 4 TAD]------------------------------//

	/**
	 * Retorna el llistat de persones que te el conjunt donat un recurs.
	 * @param recurs, recurs que volem buscar
	 * @return llista d'elements que hi ha en el conjunt
	 */
	public LlistaPersones numElemsPerRecurs(String recurs)  {
        int i = 0;
        LlistaPersones aux = new LlistaPersones(1);
        while(i<numPersones) {
            if(llistaPersones[i].getRecursos().equals(recurs)) {
                aux.afegir(llistaPersones[i].copia());
            }
            i++;
        }
        return aux;
    }
	
//------------------------------[Metode 5 TAD]------------------------------//

	/**
	 * Retorna el numero de persones que te el conjunt donat un recurs i una data determinada.
	 * @param recurs, data, recurs i data que volem buscar
	 * @return llista d'elements que hi ha en el conjunt
	 */
	public LlistaPersones numElemsPerData(String recurs, String data)  {
        int i = 0;
        LlistaPersones aux = new LlistaPersones(1);
        while(i<numPersones) {
            if(llistaPersones[i].getRecursos().equals(recurs) && llistaPersones[i].getData().equals(data)) {
                aux.afegir(llistaPersones[i].copia());
            }
            i++;
        }
        return aux;
    }
	
//------------------------------[Metode 6 TAD]------------------------------//

	/** 
	 * Busca el recurs que ha estat consultat mes cops.
	 * @return el recurs que ha estat consultat mes cops
	 */
	public int recursMesConsultat() {
		int i = 0;
		int mesConsultat = 0;
		
		while (i < numPersones) {
		if (numConsultesPerRecurs[i] >= numConsultesPerRecurs[mesConsultat]) mesConsultat = i; 
		i++;
		}
		return mesConsultat;
	}

//------------------------------[Metode 7 TAD]------------------------------//
	
	/**
	 * Busca el nombre de recursos que ha consultat un usuari determinat.
	 * @param nom, nom que volem buscar
	 * @return tot els recuros que ha consultat un alies determinat
	 */
	public boolean[] recursosConsultatsPerAlies (String nom) {
        boolean[] aux = new boolean[6];
        int i=0;
        while (i < numPersones) {
            if (llistaPersones[i].getAlies().equals(nom)) {
                aux[Integer.valueOf(llistaPersones[i].getRecursos())] = true;
                i++;
            }
            else i++; 
            } 
        return aux;
    } 
	
//------------------------------[ToString]------------------------------//

	/**
	 * Mètode que ens retorna un toString de la llista d'alumnes.
	 * @return String de la llista d'alumnes
	 */
	public String toString() {
		String aux = "Els seus elements son els seguents:\n";
		
    	for(int i = 0; i < numPersones; i++ ) {
   			aux = aux + llistaPersones[i].toString() +"\n";
		}
    	return aux;
	}
	
//------------------------------[Copia]------------------------------//

	/**
	 * Mètode que ens retorna un copia de la llista d'alumnes.
	 * @return copia de la llistaPersones
	 */
	public LlistaPersones copia() {
		LlistaPersones duplicat = new LlistaPersones(numPersones);
    	return duplicat;
    }

//------------------------------[CheckAliesRecurs]--------------------//
	
	/**
	 * Mètode que ens retorna un toString de la llista d'alumnes.
	 * @param nom, recurs
	 * @return boolea que comprova si una persona ha vist un recurs
	 */
	public boolean aliesHaVistRecurs(String nom, String recurs) {
		for(int i = 0; i < numPersones; i++) if(llistaPersones[i].getAlies().equals(nom) && llistaPersones[i].getRecursos().equals(recurs)) return true;
		return false;
	}
	
}
