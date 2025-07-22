package DadesDin;

import Dades.Persona;

public class LlistaNodes implements TADGrupPersonesDin{
	
	public static int numRecursos = 6;
    public int numConsultesPerRecurs[];
	
	private Node primer;
	    
	public LlistaNodes() { 
		primer = null;
		numConsultesPerRecurs = null;
		}

//------------------------------[Metode 1 TADDin]------------------------------//
	
	/** 
	 * Afegeix la informacio de persona al conjunt mentre hi ha espai.
	 * @param p, n la persona a afegir al conjunt a un node
	 */
	public void afegir (Persona p, Node n){ 
	    Node nou = new Node (p, n);
	    if (primer == null){
	    primer = nou;
	    }
	    else {
	        Node actual = primer;
	        while (actual.getNext()!= null){
	            actual = actual.getNext();
	            
	        }
	        actual.setNext(nou);
	    }
	}
	
//------------------------------[Metode 2 TADDin]------------------------------//
	
	/**
	 * Elimina totes les dades de consulta d'un recurs del conjunt
	 * @param recurs - les dades d'una consulta a eliminar del conjunt
	 */
	public void eliminarPerComplet(int recurs) {
		 numConsultesPerRecurs[recurs] = 0;
	}	
	
//------------------------------[Metode 3 TADDin]------------------------------//
	
	/**
	 * Elimina totes les dades de consulta d'un recurs del conjunt d'un dia determinat 
	 * @param recurs, data - les dades d'una consulta a eliminar del conjunt donada una data
	 */
	public void eliminarPerData(String recurs, String data) {
		
		Node actual = primer;
		while(actual.getNext() != null); {
			
		if(actual.getPersona().getData().equals(data)) {
		if(actual.getPersona().getRecursos().equals(recurs)) numConsultesPerRecurs[Integer.valueOf(recurs)]--; }

		//passar al seguent
		actual=actual.getNext();
		}
	}

//------------------------------[Metode 4 TADDin]------------------------------//
	
	/**
	 * Retorna la llista de persones que te el conjunt donat un recurs
	 * @param recurs a buscar els elements 
	 * @return node numero d'elements que hi ha en el conjunt
	 */
	 public Node numElemsPerRecurs (String recurs) {
	        
         boolean primerTrobat = false;
         Node aux = new Node(null,null);
         Node actual = primer;    
         int t1 = Integer.valueOf(recurs);
         int t2;
         
         while( primerTrobat == false && actual.getNext() != null) {
             
             if(actual.getPersona().getRecursos().equals(recurs)){
                 aux = actual;
                 primerTrobat = true;    
             }    
             actual = actual.getNext();
             }  
         actual = aux;
         primerTrobat = false;
         
         while(actual.next != null) {
             
        	 t2 = Integer.valueOf(actual.next.getPersona().getRecursos());
         
        	 if(t2 != t1) {
        		 actual.next = actual.next.next;
        		 primerTrobat = false;
         }
         if(t2 == t1) actual = actual.next;
         } 
     return aux;
 }
	
//------------------------------[Metode 5 TADDin]------------------------------//

	/**
	 * Retorna la llista de persones que te el conjunt donat un recurs i una data determinada
	 * @param recurs, data a buscar els elements
	 * @return node numero d'elements que hi ha en el conjunt
	 */
	public Node numElemsPerData (String recurs, String data) {
			
		boolean primerTrobat = false;
		Node aux = new Node(null,null);
		Node actual = primer;	
				
			while (primerTrobat == false && actual.getNext() != null) {
				if(actual.getPersona().getRecursos().equals(recurs) && actual.getPersona().getData().equals(data)){
					aux = actual.copia();
					primerTrobat = true;	
			}	
				actual = actual.getNext(); }
				
			while(aux.getNext() != null) {
			if(aux.getNext().getPersona().getRecursos() != recurs && aux.getNext().getPersona().getData() != data) aux.setNext(aux.getNext().getNext()); 
			}
	        return aux;
		}
	
//------------------------------[Metode 6 TADDin]------------------------------//

	/** 
	 * Busca el recurs que ha estat consultat mes cops 
	 * @return el recurs que ha estat consultat mes cops
	 */
	public int recursMesConsultat() {
        int i0 = 0;
        int i1 = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int mesConsultat = 0;
        Node actual = primer;

        while (actual.getNext() != null) {
            
        if (Integer.valueOf(actual.getPersona().getRecursos()) == 0) i0++;
        if (Integer.valueOf(actual.getPersona().getRecursos()) == 1) i1++;
        if (Integer.valueOf(actual.getPersona().getRecursos()) == 2) i2++;
        if (Integer.valueOf(actual.getPersona().getRecursos()) == 3) i3++;
        if (Integer.valueOf(actual.getPersona().getRecursos()) == 4) i4++;
        if (Integer.valueOf(actual.getPersona().getRecursos()) == 5) i5++;
            
        actual = actual.getNext();
        }
        
        if (Integer.valueOf(actual.getPersona().getRecursos()) == 0) i0++;
        if (Integer.valueOf(actual.getPersona().getRecursos()) == 1) i1++;
        if (Integer.valueOf(actual.getPersona().getRecursos()) == 2) i2++;
        if (Integer.valueOf(actual.getPersona().getRecursos()) == 3) i3++;    
        if (Integer.valueOf(actual.getPersona().getRecursos()) == 4) i4++;
        if (Integer.valueOf(actual.getPersona().getRecursos()) == 5) i5++;
        
        if(i0>i1 && i0>i2 && i0>i3 && i0>i4 && i0>i5) mesConsultat=i0;    
        else if(i1>i0 && i1>i2 && i1>i3 && i1>i4 && i1>i5) mesConsultat=1;
        else if(i2>i0 && i2>i1 && i2>i3 && i2>i4 && i2>i5) mesConsultat=2;
        else if(i3>i0 && i3>i2 && i3>i1 && i3>i4 && i3>i5) mesConsultat=3;
        else if(i4>i0 && i4>i2 && i4>i3 && i4>i1 && i4>i5) mesConsultat=4;
        else if(i5>i0 && i5>i2 && i5>i3 && i5>i4 && i5>i1) mesConsultat=5;
        return mesConsultat;
    }

//------------------------------[Metode 7 TADDin]------------------------------//

	/**
	 * Busca el nombre de recursos que ha consultat un usuari determinat
	 * @param nom el nom que volem buscar
	 * @return boolea tot els recuros que ha consultat un alies determinat
	 */
	public boolean[] recursosConsultatsPerAlies(String nom) {         
		int x = 0;
		
		Node actual = primer;
		boolean[] aux = new boolean[6];
		
		while (actual.getNext() != null || actual==null) {
                
			if (actual.getPersona().getAlies().equals(nom)) {
				x = Integer.valueOf(actual.getPersona().getRecursos());  
				aux[x] = true;
				actual = actual.getNext();
			}
			else actual = actual.getNext();
		}
		if (actual.getPersona().getAlies().equals(nom)) {     
			x = Integer.valueOf(actual.getPersona().getRecursos());   
			aux[x] = true;
            actual = actual.getNext();
		}
		return aux;
    }
	
//------------------------------[ToString]--------------------------------------//
	
	/**
	 * Mètode que ens retorna un toString de la llista d'alumnes.
	 * @return String de la llista d'alumnes
	 */
	public String toString() {
		String aux = "Els seus elements son els seguents:\n";
		Node actual = primer;
		while(actual.getNext() != null) {
				
			aux = aux + "|Nom: " + actual.getPersona().getAlies() +" |Data: "+ actual.getPersona().getData() +" |Recurs: "+ actual.getPersona().getRecursos() +"\n";
			actual = actual.getNext();

		}
		aux = aux + "|Nom: " + actual.getPersona().getAlies() +" |Data: "+ actual.getPersona().getData() +" |Recurs: "+ actual.getPersona().getRecursos() +"\n";
			
		return aux;
	}
	 
//-----------------------------[CheckAliesRecurs]--------------------------------//
	
	/**
	 * Mètode que ens retorna un toString de la llista d'alumnes.
	 * @param nom, recurs
	 * @return boolea que comprova si una persona ha vist un recurs
	 */
	public boolean aliesHaVistRecurs(String nom, String recurs) {
        Node actual = primer;
        while(actual.getNext() != null) {
            if(actual.getPersona().getAlies().equals(nom) && actual.getPersona().getRecursos().equals(recurs)) return true;
            actual = actual.getNext();
        }             
        return false;
    }	
	
//---------------------------------[getNode]-------------------------------------//
		
	/**
	 * Mètode getter del node.
	 * @return Node
	 */
	public Node getPrimer() {
		return primer;
	}

	/**
	 * Mètode setter del node.
	 */
	public void setPrimer(Node primer) {
		this.primer = primer;
	}

	/**
	 * Mètode getter del numConsulterPerRecurs.
	 * @return numConsultesPerRecurs
	 */
	public int[] getNumConsultesPerRecurs() {
		return numConsultesPerRecurs;
	}

	/**
	 * Mètode setter del numConsultesPerRecurs.
	 */
	public void setNumConsultesPerRecurs(int[] numConsultesPerRecurs) {
		this.numConsultesPerRecurs = numConsultesPerRecurs;
	}
}


