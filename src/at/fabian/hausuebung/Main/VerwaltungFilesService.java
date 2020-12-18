package at.fabian.hausuebung.Main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import at.fabian.hausuebung.Model.Abteilung;
import at.fabian.hausuebung.Model.Mitarbeiter;

public class VerwaltungFilesService {
	
void readNamesFromFile(Path path) throws IOException {
		
		BufferedReader reader = Files.newBufferedReader(path);
	
	    StringBuilder content = new StringBuilder();
	    String line;
	    
		while ((line = reader.readLine()) != null) {
			  content.append(line);
			  content.append(System.lineSeparator());
			}
		
	     System.out.println(content.toString());
	}
	

	void writeNamesToFile(List<String> mitarbeiternamen,Path path) throws IOException {
		
		  BufferedWriter writer = Files.newBufferedWriter(path);
		 
	      for (String namen : mitarbeiternamen) {  
				writer.write(namen + "\n"+ "");
	       }
	    
	    	writer.close();

	}
	

	Path createFile(String targetFileName) throws IOException,FileAlreadyExistsException {
		
		String currentWorkingDirectory = System.getProperty("user.dir");

		Path targetFile = Paths.get(currentWorkingDirectory,targetFileName);
		
		Files.createFile(targetFile);
		
		return targetFile;
	}
	

	List<String> getMitarbeiterNamensliste(Verwaltung verwaltung) {
		List<String> mitarbeiternamen = new ArrayList<>();
		
		for(Mitarbeiter mia : verwaltung.mitarbeiter_liste) {
			mitarbeiternamen.add(mia.getName());
		}
		
		return mitarbeiternamen;
	}
	
	
	List<Mitarbeiter> getMeisteMitarbeiter(Verwaltung verwaltung) {
		List<Mitarbeiter> meisteMitarbeiter = null;
		int mitarbeiterCount = 0;
		
		for( Abteilung abt : verwaltung.abteilungs_liste) {
					if(abt.getMitarb_Liste().size() > mitarbeiterCount) {
						mitarbeiterCount = abt.getMitarb_Liste().size();
						meisteMitarbeiter = abt.getMitarb_Liste(); 
					}
			}
		return meisteMitarbeiter;
	}
	
	void writeMitarbeiterToFile(List<Mitarbeiter> ma, Path path) throws IOException {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		fos = new FileOutputStream (path.toString());
	
		oos = new ObjectOutputStream (fos);

		for(Mitarbeiter m: ma) {
			oos.writeObject(m);
		}
		
		fos.close();
		oos.close();
		
	}
	
	
	
	List<Mitarbeiter> readMitarbeiterFromFile(Path path) throws FileNotFoundException, IOException, ClassNotFoundException {
		
		List<Mitarbeiter> mitarbeiterListe = new ArrayList<>();
		
		FileInputStream fis = new FileInputStream (path.toString());
		ObjectInputStream ois = new ObjectInputStream (fis);
	
		
		Object obj = null;
		
		try {
		
			while(!(obj = ois.readObject()).equals(null)){
				if(obj instanceof Mitarbeiter){
					mitarbeiterListe.add((Mitarbeiter) obj);
				}
			}
		}
		
		catch(EOFException eof){
			
		}
		
		
		fis.close();
		ois.close();
		
		return mitarbeiterListe;
	}
	
	

}
