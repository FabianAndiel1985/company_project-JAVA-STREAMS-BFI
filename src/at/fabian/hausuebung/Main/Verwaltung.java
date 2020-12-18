package at.fabian.hausuebung.Main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import at.fabian.hausuebung.Model.Abteilung;
import at.fabian.hausuebung.Model.Angesteller;
import at.fabian.hausuebung.Model.Arbeiter;
import at.fabian.hausuebung.Model.Firma;
import at.fabian.hausuebung.Model.Mitarbeiter;

public class Verwaltung implements VerwaltungsInterface {
	
	List<Abteilung> abteilungs_liste = new ArrayList<Abteilung>(SIZE_ABTEILUNG);

	List<Mitarbeiter> mitarbeiter_liste = new ArrayList<Mitarbeiter>(SIZE_MITARBEITER);
	
	private Firma firma;

	public Verwaltung() {
		init();
	}
	
	public static void main(String[] args) {

		Verwaltung verwaltung = new Verwaltung();
		VerwaltungFilesService verwaltungService = new VerwaltungFilesService();
		
//		System.out.println(verwaltung.getMitarbeiter_liste());
//		
		
		
//		System.out.println(verwaltung.getAbteilungs_liste().toString());
		
//		System.out.println(verwaltung.searchMitarbeiterAusAlleAbteilungen(3));
		
//		System.out.println(verwaltung.getMitarbeiterListeVonAbteilung(2));		
		
//		System.out.println(verwaltung.searchAbteilung(4));		
		
//		verwaltung.ausgabe_AlleAbteilungen();	
		
//		Mitarbeiter m = verwaltung.suche(11);

//		verwaltung.ausgabe(m);
//		
//		verwaltung.ausgabeMitarbeiterListe();	
		
//		verwaltung.sortMitarbeiterNachNamen();
				
		List<String> mitarbeiternamen = verwaltungService.getMitarbeiterNamensliste(verwaltung);
		Path filePath = null;

		try {
			 filePath = verwaltungService.createFile("Angestelltenliste.txt");
			 verwaltungService.writeNamesToFile(mitarbeiternamen, filePath);
			 verwaltungService.readNamesFromFile(filePath);
			 
			 List<Mitarbeiter> meisteMitarbeiter = verwaltungService.getMeisteMitarbeiter(verwaltung);
			 
			 Path serFilePath = verwaltungService.createFile("Angestelltenliste.ser");
			 verwaltungService.writeMitarbeiterToFile(meisteMitarbeiter,serFilePath);
			 
		} 
		
		catch (FileAlreadyExistsException e) {
			System.out.println("Please delete existing files Angestelltenliste.ser and Angestelltenliste.txt and try again");
			e.printStackTrace();		}
		
		catch (IOException e) {
			e.printStackTrace();
		}
		
	
	}
		
		

	
	//---------------------------Ende ----------------------------------------------------------		

	
	private List<Mitarbeiter> sortMitarbeiterNachGehalt(List<Mitarbeiter> mitarbeiter) {
		System.out.println("--------sortMitarbeiterNachGehalt()");
		mitarbeiter.sort(new Comparator<Mitarbeiter>() {

			@Override
			public int compare(Mitarbeiter o1, Mitarbeiter o2) {
				
				if(o1.getBrutto() < o2.getBrutto())
					return -1;
				else if(o1.getBrutto() > o2.getBrutto())
					return 1;
				else return 0;
			}
			
		});
		
		return mitarbeiter;
	}
	
	
	
	private void sortMitarbeiterNachNamen() {
		System.out.println("---------------sortMitarbeiterNachNamen");
		
		this.mitarbeiter_liste.sort(new Comparator<Mitarbeiter>() {

			@Override
			public int compare(Mitarbeiter o1, Mitarbeiter o2) {
				return o1.getName().compareTo(o2.getName());
				
			}});
			
		
		ausgabeMitarbeiterListe(mitarbeiter_liste);
		
//		this.getMitarbeiter_liste().sort( (Mitarbeiter m1, Mitarbeiter m2)-> m1.getName().compareTo(m2.getName()));
//		
//		this.mitarbeiter_liste.forEach(e-> System.out.println(e));
//		
//		this.mitarbeiter_liste.stream().sorted( (Mitarbeiter m1, Mitarbeiter m2)-> m1.getName().compareTo(m2.getName()).forEach(e -> System.out.println(e)));
	
	}
	
	
	private Mitarbeiter searchMitarbeiterAusAlleAbteilungen(int i) {
		for (Abteilung abteilung : this.getAbteilungs_liste()) {
			for (Mitarbeiter m : abteilung.getMitarb_Liste()) {
				if (m.getId() == i)
					return m;
			}
		}
		return null;
	}
	
	
	private List<Mitarbeiter> getMitarbeiterListeVonAbteilung(int id) {
		for (Abteilung abteilung : abteilungs_liste) {
			if (abteilung.getId() == id)
				return abteilung.getMitarb_Liste();
		}
		return null;
	}
	

	private boolean searchAbteilung(int id) {
		for (Abteilung a : abteilungs_liste) {
			if (a.getId() == id) {
				return true;
			}
		}
		return false;
	}


	
	private void ausgabe_AlleAbteilungen() {
		
		for (Abteilung abteilung : abteilungs_liste) {
			System.out.println(abteilung);
		}
	}

	
	
	private void init() {
		
		Mitarbeiter[] mitarbeiter_listeTmp = new Mitarbeiter[12];
		
		
		mitarbeiter_listeTmp[0] = new Angesteller(1, "a1", 10000, 200);
		mitarbeiter_listeTmp[1] = new Angesteller(2, "a2", 10010, 201);
		mitarbeiter_listeTmp[2] = new Angesteller(3, "a3", 10020, 202);
		mitarbeiter_listeTmp[3] = new Angesteller(4, "a4", 10030, 203);
		mitarbeiter_listeTmp[4] = new Angesteller(5, "a5", 10040, 204);
		mitarbeiter_listeTmp[5] = new Angesteller(6, "a6", 10005, 205);

		mitarbeiter_listeTmp[6] = new Arbeiter(7, "b1", 1000, 4, 200);
		mitarbeiter_listeTmp[7] = new Arbeiter(8, "b2", 1004, 6, 201);
		mitarbeiter_listeTmp[8] = new Arbeiter(9, "b3", 1003, 8, 202);
		mitarbeiter_listeTmp[9] = new Arbeiter(10, "b4", 1005, 10, 203);
		mitarbeiter_listeTmp[10] = new Arbeiter(11, "b5", 1001, 14, 204);
		mitarbeiter_listeTmp[11] = new Arbeiter(12, "b6", 1002, 19, 205);
		
		this.mitarbeiter_liste.addAll(Arrays.asList(mitarbeiter_listeTmp));

		
		Mitarbeiter[] mitarbeitListePRTmp = new Mitarbeiter[4];
		mitarbeitListePRTmp[0] = suche(1);
		mitarbeitListePRTmp[1] = suche(6);
		mitarbeitListePRTmp[2] = suche(7);
		mitarbeitListePRTmp[3] = suche(8);
		
		List<Mitarbeiter> mitarbeitListePR = new ArrayList<Mitarbeiter>();
		mitarbeitListePR.addAll(Arrays.asList(mitarbeitListePRTmp));
		
		
		Mitarbeiter[] mitarbeitListeSALESTmp = new Mitarbeiter[5];
		mitarbeitListeSALESTmp[0] = suche(2);
		mitarbeitListeSALESTmp[1] = suche(3);
		mitarbeitListeSALESTmp[2] = suche(9);
		mitarbeitListeSALESTmp[3] = suche(10);
		mitarbeitListeSALESTmp[4] = suche(11);
		
		
		List<Mitarbeiter> mitarbeitListeSALES = new ArrayList<Mitarbeiter>();
		mitarbeitListeSALES.addAll(Arrays.asList(mitarbeitListeSALESTmp));
		

		Mitarbeiter[] mitarbeitListeITTemp = new Mitarbeiter[3];
		mitarbeitListeITTemp[0] = suche(5);
		mitarbeitListeITTemp[1] = suche(6);
		mitarbeitListeITTemp[2] = suche(4);
		
		
		List<Mitarbeiter> mitarbeitListeIT= new ArrayList<Mitarbeiter>();
		mitarbeitListeIT.addAll(Arrays.asList(mitarbeitListeITTemp));
		
		List<Mitarbeiter> mitarbeitListeHR= new ArrayList<Mitarbeiter>();
		
		mitarbeitListeHR.add(suche(4));
		
		this.abteilungs_liste.add(new Abteilung(1, "PR", mitarbeitListePR));

		this.abteilungs_liste.add(new Abteilung(2, "SALES", mitarbeitListeSALES));

		this.abteilungs_liste.add(new Abteilung(3, "IT", mitarbeitListeIT));

		this.abteilungs_liste.add(new Abteilung(4, "HR", mitarbeitListeHR));
		
		Firma firma = new Firma(this.abteilungs_liste, this.mitarbeiter_liste);
		
		firma.name = "BFI";

	}
	
	

	public Mitarbeiter suche(int i) {
		return mitarbeiter_liste.get(i);
	}

//	ok tested
	public void ausgabe(Mitarbeiter m) {

		System.out.println("==========Mitarbeiter Ausgabe:==========");
		System.out.println(m.ausgabe());

	}
	
	

	public void ausgabeMitarbeiterListe(List<Mitarbeiter> mitarbeiter_liste) {

		System.out.println("==========Mitarbeiter Liste Ausgabe:==========");

		System.out.println(mitarbeiter_liste);

	}
	

	public int countAngestellte() {
		int counter = 0;

		for (Mitarbeiter m : mitarbeiter_liste) {
			if (m instanceof Angesteller) {
				counter++;
			}
		}
		return counter;

	}

	public int countArbeiter() {
		int counter = 0;

		for (Mitarbeiter m : mitarbeiter_liste) {
			if (m instanceof Arbeiter) {
				counter++;
			}
		}
		return counter;

	}

	public void berechneSummeAlleGehaelter() {

		double gesamteBezuege = 0;

		for (Mitarbeiter mitarbeiter : mitarbeiter_liste) {
			gesamteBezuege += mitarbeiter.berechneBrutto();
		}

		System.out.println("Gesamtbrutto Bezuege: " + gesamteBezuege);
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



	public Firma getFirma() {
		return firma;
	}



	public void setFirma(Firma firma) {
		this.firma = firma;
	}
	
	

}
