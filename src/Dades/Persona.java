package Dades;

public class Persona {
	private String data;
	private String alies;
	private String recurs;
	
	public Persona(String data, String alies, String recurs) {
		this.data = data;
		this.alies = alies;
		this.recurs = recurs;
	}

	public String getData() {
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}

	public String getAlies() {
		return alies;
	}

	public void setAlies(String alies) {
		this.alies = alies;
	}

	public String getRecursos() {
		return recurs;
	}

	public void setRecursos(String recursos) {
		this.recurs = recursos;
	}

	public Persona copia() {
		Persona pers = new Persona(data, alies, recurs);
		return pers;
	}

	public String toString() {
		return "Persona [data=" + data + ", alies=" + alies + ", recursos=" + recurs+"]";
	}
}

