package at.fabian.hausuebung.Model;

import at.fabian.hausuebung.Main.Verwaltung;

public class Angesteller extends Mitarbeiter {

	private double grundgehalt;
	private double zulage;



//	@Override
//	public int compareTo(Mitarbeiter o) {
//		// TODO Auto-generated method stub
//		return super.compareTo(o);
//	}

	public Angesteller(int id, String name, double grundgehalt, double zulage) {
		super(id, name);
		this.grundgehalt = grundgehalt;
		this.zulage = zulage;
	}

	public double getGrundgehalt() {
		return grundgehalt;
	}

	public void setGrundgehalt(double grundgehalt) {
		this.grundgehalt = grundgehalt;
	}

	public double getZulage() {
		return zulage;
	}

	public void setZulage(double zulage) {
		this.zulage = zulage;
	}

	public Angesteller ausgabe() {
		return this;
	}

	@Override
	public double berechneBrutto() {
		double brutto = this.grundgehalt + this.zulage;
		setBrutto(brutto);
		return getBrutto();
	}

	@Override
	public double berechneNettoGehalt() {

		double brutto = this.berechneBrutto();

		double netto = (brutto) - (brutto * Verwaltung.TAX_ANG);

		return netto;
	}

	@Override
	public String toString() {
		return super.toString() + "\n" + "Grundgehalt: " + getGrundgehalt() + "\tZulage: " + getZulage()
				+ "\nBruttogehalt: " + berechneBrutto() + "\tNetto: " + berechneNettoGehalt();

	}

}
