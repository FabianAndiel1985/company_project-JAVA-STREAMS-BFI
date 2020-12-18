package at.fabian.hausuebung.Model;

import at.fabian.hausuebung.Main.Verwaltung;

public class Arbeiter extends Mitarbeiter {

	private double stundenlohn;
	private double anz_stunden;
	private double schicht_Zulagen;


	public Arbeiter() {

	}

//
//	@Override
//	public int compareTo(Mitarbeiter o) {
//		// TODO Auto-generated method stub
//		return super.compareTo(o);
//	}


	public Arbeiter(int id, String name, double stundenlohn, double anz_stunden, double schicht_Zulagen) {
		super(id, name);
		this.stundenlohn = stundenlohn;
		this.anz_stunden = anz_stunden;
		this.schicht_Zulagen = schicht_Zulagen;
	}

	public double getStundenlohn() {
		return stundenlohn;
	}

	public void setStundenlohn(double stundenlohn) {
		this.stundenlohn = stundenlohn;
	}

	public double getAnz_stunden() {
		return anz_stunden;
	}

	public void setAnz_stunden(double anz_stunden) {
		this.anz_stunden = anz_stunden;
	}

	public double getSchicht_Zulagen() {
		return schicht_Zulagen;
	}

	public void setSchicht_Zulagen(double schicht_Zulagen) {
		this.schicht_Zulagen = schicht_Zulagen;
	}

	public Arbeiter ausgabe() {
		return this;
	}

	@Override
	public double berechneBrutto() {
		double brutto = (this.stundenlohn * this.anz_stunden) + this.schicht_Zulagen;
		return brutto;
	}

	@Override
	public double berechneNettoGehalt() {

		double brutto = this.berechneBrutto();

		double netto = (brutto) - (brutto * Verwaltung.TAX_ARB);

		return netto;
	}

	@Override
	public String toString() {
		return super.toString() + "\n" + "Stundenlohn: " + getStundenlohn() + "\tStundenanzahl: " + getAnz_stunden()
				+ "\tSchicht Zulage: " + getSchicht_Zulagen() + "\nBruttogehalt: " + berechneBrutto() + "\tNetto: "
				+ berechneNettoGehalt();
	}

}
