import java.util.*;
import java.io.*;

public class Save {
	
	//CAMPI
	private final boolean debug = true;
	private static FileWriter fw;
	private FileReader fr;
	private StringBuffer sb;
	private static Scanner line;
	private static Scanner token;
	
	//COSTRUTTORE
	public Save() throws IOException, FileNotFoundException {
		try {
			fw = new FileWriter("saves.txt");
			fr = new FileReader("saves.txt");
		}
		catch(FileNotFoundException e) {
			if(debug) {System.out.println("File di salvatagio non trovato, creato uno nuovo ");}
			File f = new File("saves.txt");
			fw = new FileWriter(f);
			fr = new FileReader(f);
			line = new Scanner(f);
			token = new Scanner(line.nextLine());
			token.useDelimiter("-");
		}
	}
	
	//METODI
	public static void save(String n) throws IOException {
		boolean presente = false;
		int vinte = 0;
		int perse = 0;
		int disputate = 0;
		String nome = "";
		if(line.hasNext()) {
			while(line.hasNext()) {
				if(token.next().equals(n)) {
					presente = true;
					break;
				}	
			}
		}
		if(presente) {
			vinte = token.nextInt() + GiocoSingle.vinteX();
			perse = token.nextInt() + GiocoSingle.vinteO();
			disputate = token.nextInt() + Main.disputateSingle;
		}
		else {
			nome = n;
			vinte = GiocoSingle.vinteX();
			perse = GiocoSingle.vinteO();
			disputate = Main.disputateSingle;
			fw.write(nome + "-" + vinte + "-" + perse + "-" + disputate);
		}
	}

}
