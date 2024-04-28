package esercizi_java_spFormazione;

import java.util.Objects;

public class SchedaPersona {
	static String name;
	static String indirizzo;
	static String numeroTel;

	public static String getName() {
		return name;
	}

	public void setName(String name) {
		SchedaPersona.name = name;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		SchedaPersona.indirizzo = indirizzo;
	}

	public String getNumeroTel() {
		return numeroTel;
	}

	public void setNumeroTel(String numeroTel) {
		SchedaPersona.numeroTel = numeroTel;
	}

	@Override
	public int hashCode() {
		return Objects.hash(indirizzo, name, numeroTel);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		return Objects.equals(indirizzo, SchedaPersona.indirizzo) && Objects.equals(name, SchedaPersona.name)
				&& Objects.equals(numeroTel, SchedaPersona.numeroTel);
	}

	@Override
	public String toString() {
		return "schedaPersona [name=" + name + ", indirizzo=" + indirizzo + ", numeroTel=" + numeroTel + "]";
	}

	/*
	 * static void nameChecker(String data) {
	 * 
	 * String nome=getName(); if (nome.contains(data)) {
	 * System.out.println("match"); } else { System.out.println("unmatched"); } }
	 */

	boolean contains(String data) {
		if (data.contains(name) || data.contains(indirizzo) || data.contains(numeroTel)) {
			return true;
		}
		return false;

	}

}