package Serializzazione_exercize;

import java.io.Serializable;

public class Animale implements Serializable  {
	private String name;
	private String suono;
	private int zampe;
	
	Animale(String name, String suono,int zampe){
		this.name=name;
		this.suono=suono;
		this.zampe=zampe;
	}

	/**
	 * @return the name
	 */
	private String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	private void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the suono
	 */
	private String getSuono() {
		return suono;
	}

	/**
	 * @param suono the suono to set
	 */
	private void setSuono(String suono) {
		this.suono = suono;
	}

	/**
	 * @return the zampe
	 */
	private int getZampe() {
		return zampe;
	}

	/**
	 * @param zampe the zampe to set
	 */
	private void setZampe(int zampe) {
		this.zampe = zampe;
	}

	@Override
	public String toString() {
		return "Animale [name=" + name + ", suono=" + suono + ", zampe=" + zampe + "]";
	}
	
	
}
