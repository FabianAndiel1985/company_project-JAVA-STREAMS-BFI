package at.fabian.hausuebung.Model;

import java.io.Serializable;
import java.util.Comparator;

public abstract class Mitarbeiter implements Serializable  {
	
//	@Override
//	public int compareTo(Mitarbeiter o) {
//		
//		return this.getName().compareToIgnoreCase(o.getName());
//		
//	}
//	

	/**
	 * 
	 */
	private static final long serialVersionUID = 883624500518949046L;
	private int id; 
	private String name;
	public double brutto;
	
	
	
	
	public double getBrutto() {
		return brutto;
	}

	public void setBrutto(double brutto) {
		this.brutto = brutto;
	}

	public Mitarbeiter() {
	}

	public Mitarbeiter(int id) {
		this.id = id;
	}
	
	public Mitarbeiter(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public abstract double berechneBrutto();
	
	public abstract double berechneNettoGehalt();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Mitarbeiter ausgabe () {
		return this;
	}
	
	

	
	@Override
	public String toString() {
		return getClass().getSimpleName() + 
				", ID: " + getId() + ", Name: " + getName() + "\n" ;
	}


}
