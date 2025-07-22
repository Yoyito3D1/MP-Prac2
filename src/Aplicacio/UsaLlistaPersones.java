package Aplicacio;
 
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import Dades.LlistaPersones;
import Dades.Persona;

public class UsaLlistaPersones  {
	
	static Scanner teclat = new Scanner(System.in);

	public static void main(String[] args) throws FileNotFoundException{
		
		int numLinies = 100;
		int opcio;
		String[] dataset = llegirLiniesFitxer(numLinies);
		LlistaPersones llista = carregarPersona(dataset);
		Scanner scan = new Scanner(System.in);
		
		do {
			mostraMenu();
			opcio = scan.nextInt();
			
			switch(opcio) {
			case 1:
				opcio1(llista);
				break;
				
			case 2:
				opcio2(llista);
				break;
				
			case 3:
				opcio3(llista);
				break;
			
			case 4:
				opcio4(llista);
				break;
			
			case 5:
				opcio5(llista);
				break;
			
			case 6:
				opcio6(llista);
				break;
			
			case 7:
				opcio7(llista);
				break;
				
			case 8:
				opcio8(llista);
				break;
			}
			
		} while(opcio != 9);
		scan.close();
	}

		/**
	 	* Metode que ens serveix per llegir el fitxer .txt i crear un String amb els elements del mateix.
	 	* @param numLinies
	 	* @return String[]
	 	*/
		private static String[] llegirLiniesFitxer(int numLinies) throws FileNotFoundException {
			String[] result;
			result = new String[numLinies];
			
			Scanner f = new Scanner(new File("LlistaPersones.txt"));
			for (int i = 0; i < numLinies; i++) {
				result[i] = f.nextLine();
			}
			f.close();
			return result;
		}
		
		/**
		 * Metode per crear una llista de persones a partir de l'array de Strings que s'ha creat amb el metode llegirLiniesFitxer.
		 * Rep per parametre el numero de linies i l'array de strings que conte dataset.
		 * Per cada linia separem cada dada en un string aux mitjançant la funcio split.
		 * Un cop fet aixo cridem al constructor dins d'un bucle per crear les persones amb els seus atributs
		 * les quals seran afegides a la llista de persones que es tractara al main.
		 * @param dataset
		 * @return LlistaPersones
		 */
		private static LlistaPersones carregarPersona(String[] dataset)  {
			LlistaPersones llista = new LlistaPersones(3);
			for(int i = 0; i < dataset.length; i++) {	
				String[] aux = dataset[i].split(";");
				Persona persona = new Persona(aux[0],aux[1], aux[2]);
				llista.afegir(persona);
			}
			return llista;
		}		
		
		/**
		 * Mètode per printejar el menú principal.
		 * 
		 */
		private static void mostraMenu( ) {
			System.out.println("\n\n");
			System.out.println("\t=========================================");
			System.out.println("\t||                MENU                 ||");
			System.out.println("\t=========================================");
			System.out.println("\t||                                     ||");
			System.out.println("\t|| [1]-> Afegir dades                  ||");
			System.out.println("\t||                                     ||");
			System.out.println("\t|| [2]-> Esborrar dades d'un recurs    ||");
			System.out.println("\t||                                     ||");
			System.out.println("\t|| [3]-> Esborrar dades d'una data     ||");
			System.out.println("\t||                                     ||");
			System.out.println("\t|| [4]-> Llista usuaris (Recurs)       ||");
			System.out.println("\t||                                     ||");
			System.out.println("\t|| [5]-> Llista usuaris (Recurs/Data)  ||");
			System.out.println("\t||                                     ||");
			System.out.println("\t|| [6]-> Recurs mes consultat          ||");
			System.out.println("\t||                                     ||");
			System.out.println("\t|| [7]-> Recursos consultats (Usuari)  ||");
			System.out.println("\t||                                     ||");
			System.out.println("\t|| [8]-> Comprovar si s'ha vist el rec ||");
			System.out.println("\t||                                     ||");
			System.out.println("\t|| [9]-> Sortir                        ||");
			System.out.println("\t||                                     ||");
			System.out.println("\t=========================================\n");
			System.out.println("TRIA UNA OPCIO DE 1-9");
			System.out.println("|");
			System.out.println("V");
		}
		
		// OPCIONS MENU
		
		/**
		 * Mètode que afegeix la informacio de persona al conjunt mentre hi ha espai.
		 * @param llista
		 */
		private static void opcio1 (LlistaPersones llista)  {
			System.out.println("Sisplau introdueixi la data en format xx/xx/xxxx");
			String data = teclat.nextLine();
			System.out.println("Sisplau introdueixi el alies");
			String alies = teclat.nextLine();
			System.out.println("Sisplau introdueixi el recuros consultat");
			String recurs = teclat.nextLine();
			
			Persona aux = new Persona(data, alies, recurs);
			llista.afegir(aux);
			System.out.println("Alumne afegit correctament!");
			System.out.println(llista.toString());
		}
		
		/**
		 * Mètode que elimina totes les dades de consulta d'un recurs del conjunt.
		 * @param llista
		 */
		private static void opcio2 (LlistaPersones llista) {
			System.out.println("Sisplau trii un recurs entre el 0-5 per a borrar les dades:");
			int opcio = Integer.parseInt(teclat.nextLine());
			llista.eliminarPerComplet(opcio);
			for (int i = 0; i < LlistaPersones.numRecursos; i++) {
				System.out.println("El recurs numero " + i + " s'ha consultat un total de " +LlistaPersones.numConsultesPerRecurs[i] + " vegades.");
			}
		}
		
		/**
		 * Mètode que elimina totes les dades de consulta d'un recurs del conjunt d'un dia determinat.
		 * @param llista
		 */
		private static void opcio3 (LlistaPersones llista) {
			System.out.println("Sisplau trii un recurs entre el 0-5 per a borrar les dades:");
			String opcio = teclat.nextLine();
			System.out.println("Sisplau escrigui una data de l'estil xx/xx/xxxx:");
			String data = teclat.nextLine();
			llista.eliminarPerData(opcio, data);
			for (int i = 0; i < LlistaPersones.numRecursos; i++) {
				System.out.println("El recurs numero " + i + " s'ha consultat un total de " +LlistaPersones.numConsultesPerRecurs[i] + " vegades.");
			}
		}
		
		/**
		 * Mètode que retorna el llistat de persones que te el conjunt donat un recurs.
		 * @param llista
		 */
		private static void opcio4 (LlistaPersones llista) {
			System.out.println("Sisplau introdueixi un recurs de 0-5");
			String opcio = teclat.nextLine();
			System.out.println(llista.numElemsPerRecurs(opcio).toString());
		}
		
		/**
		 * Mètode que retorna el numero de persones que te el conjunt donat un recurs i una data determinada.
		 * @param llista
		 */
		private static void opcio5 (LlistaPersones llista){
			System.out.println("Sisplau introdueixi un recurs de 0-5");
			String opcio = teclat.nextLine();
			System.out.println("Sisplau introdueixi una data en format xx/xx/xxxx");
			String data = teclat.nextLine();
			System.out.println(llista.numElemsPerData(opcio, data).toString());
		}
		
		/**
		 * Mètode que busca el recurs que ha estat consultat mes cops.
		 * @param llista
		 */
		private static void opcio6 (LlistaPersones llista) {
			System.out.println("El recurs mes consultat es el numero " + llista.recursMesConsultat());
		}
		
		/**
		 * Mètode que afegeix la informacio de persona al conjunt mentre hi ha espai.
		 * @param llista
		 */
		private static void opcio7 (LlistaPersones llista) {
			for(int i = 0; i < 6; i++) {
				if(llista.recursosConsultatsPerAlies("Jon")[i] == true) System.out.println("Recurs Consultat");
				else System.out.println("Recurs NO Consultat");
			}
		}
		
		/**
		 * Mètode que busca el nombre de recursos que ha consultat un usuari determinat.
		 * @param llista
		 */
		private static void opcio8 (LlistaPersones llista) {
			System.out.println("Sisplau introdueixi un nom");
			String nom = teclat.nextLine();
			System.out.println("Sisplau introdueixi un recurs del 0-5");
			String recurs = teclat.nextLine();
			if(llista.aliesHaVistRecurs(nom, recurs) == true) System.out.println("El " + nom + " ha visualitzat el recurs " + recurs + ".");
			else System.out.println("El " + nom + " no ha visualitzat el recurs " + recurs + ".");
		}
		
}