package at.fabian.hausuebung.Model;

import java.util.ArrayList;
import java.util.List;

public class Abteilung {

	protected int id;
	protected String abtname;
	protected String abt_Leiter;
	protected List<Mitarbeiter> mitarb_Liste = new ArrayList<Mitarbeiter>();

	// Konstruktoren
	public Abteilung() {
	}

	public Abteilung(int id) {
		this.id = id;
	}

	public Abteilung(int id, String abtname) {
		this.id = id;
		this.abtname = abtname;
	}

	public Abteilung(int id, String abtname, List<Mitarbeiter> mitarbeiter_Liste) {
		this.id = id;
		this.abtname = abtname;
		this.setMitarb_Liste(mitarbeiter_Liste);
	}

	public Abteilung(int id, String abtname, String abt_Leiter, List<Mitarbeiter> mitarbeiter_Liste) {
		this.id = id;
		this.abtname = abtname;
		this.abt_Leiter = abt_Leiter;
		this.setMitarb_Liste(mitarbeiter_Liste);
	}

	// Getter- Setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return abtname;
	}

	public void setName(String abtname) {
		this.abtname = abtname;
	}

	public String getAbt_Leiter() {
		return abt_Leiter;
	}

	public void setAbt_Leiter(String abt_Leiter) {
		this.abt_Leiter = abt_Leiter;
	}

	public List<Mitarbeiter> getMitarb_Liste() {
		return mitarb_Liste;
	}

	public void setMitarb_Liste(List<Mitarbeiter> mitarb_Liste) {
		this.mitarb_Liste.addAll(mitarb_Liste);
	}

	// toString Methode
	@Override
	public String toString() {
		return "ID: " + getId() + " Abteilungsname: " + getName() + " Mitarbeiteranzahl: " + getMitarb_Liste().size()
				+ " Abteilungsleiter: " + getAbt_Leiter() + "\n";

	}

}
