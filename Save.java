import java.util.*;
import java.io.*;

public class Save {
	
	//CAMPI
	private final boolean debug = true;
	private static File f;
	private static FileWriter fw;
	private static FileReader fr;
	private static BufferedReader br;
	private static BufferedWriter bw;
	private static Scanner token;
	private static boolean append;
	private static boolean presente;
	
	public Save() {
		f = new File("saves.txt");
	}
	
	//METODI
	public static void save(String n) throws IOException {
		presente = false;
		String nome = "";
		int vinte = 0;
		int perse = 0;
		int disputate = 0;
		try {
			fw = new FileWriter("saves.txt", append);
			fr = new FileReader("saves.txt");
			br = new BufferedReader(fr);
			bw = new BufferedWriter(fw);
			String line = br.readLine();
			while(line != null && line != "") {
				token = new Scanner(line);
				token.useDelimiter("-");
				if(token.next().equals(n)) {
					presente = true;
					break;
				}
			}
			if(!presente) {
				append = true;
				if(GiocoSingle.board.getWinnerX()) {
					vinte = 1;
					perse = 0;
				}
				else if(GiocoSingle.board.getWinnerO()) {
					vinte = 0;
					perse = 1;
				}
				disputate = 1;
				fw.write(n + "-" + vinte + "-" + perse + "-" + disputate + "\n");
			}
			else {
				append = false;
				if(GiocoSingle.board.getWinnerX()) {
					vinte = 1 + Integer.parseInt(token.next());
					perse = 0 + Integer.parseInt(token.next());
				}
				else if(GiocoSingle.board.getWinnerO()) {
					vinte = 0 + Integer.parseInt(token.next());
					perse = 1 + Integer.parseInt(token.next());
				}
				disputate = 1 + Integer.parseInt(token.next());
				fw.write(n + "-" + vinte + "-" + perse + "-" + disputate);
			}
			fr.close();
			//fw.flush();
			fw.close();
		}
		catch(IOException e) {}
	}

}
