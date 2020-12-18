package at.fabian.hausuebung.Model;

import java.util.ArrayList;
import java.util.List;

public class Firma {
	
	public static String name;
	
	private List<Abteilung> abteilungs_liste = new ArrayList<Abteilung>();

	private List<Mitarbeiter> mitarbeiter_liste = new ArrayList<Mitarbeiter>();
	
	
	public Firma(List<Abteilung> abteilungs_liste) {
		this.setAbteilungs_liste(abteilungs_liste);
	}

	public Firma(List<Abteilung> abteilungs_liste, List<Mitarbeiter> mitarbeiter_liste) {
		this.setAbteilungs_liste(abteilungs_liste);
		this.setMitarbeiter_liste(mitarbeiter_liste);
	}

	public static String getName() {
		return name;
	}

	public static void setName(String name) {
		Firma.name = name;
	}
	

	public List<Abteilung> getAbteilungs_liste() {
		return abteilungs_liste;
	}

	public void setAbteilungs_liste(List<Abteilung> abteilungs_liste) {
		this.abteilungs_liste.addAll(abteilungs_liste);
	}

	public List<Mitarbeiter> getMitarbeiter_liste() {
		return mitarbeiter_liste;
	}

	public void setMitarbeiter_liste(List<Mitarbeiter> mitarbeiter_liste) {
		this.mitarbeiter_liste.addAll(mitarbeiter_liste);
	}
	

}
