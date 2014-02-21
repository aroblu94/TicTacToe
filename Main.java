import java.util.*;
import java.lang.*;

public class Main {

	public static String nome1, nome2;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		while(true) {
			System.out.println("Scegli che tipo di partita vuoi giocare (3 per uscire): ");
			System.out.println("(1) Singleplayer ");
			System.out.println("(2) Multiplayer ");

			int selettore = in.nextInt();

			switch(selettore) {
				case 1:
					System.out.println("Inserisci il nome ");
					nome1 = in.next();
					GiocoSingle gs = new GiocoSingle();
					gs.play();
					break;
				case 2:
					System.out.println("Inserisci il nome del primo giocatore (X) ");
					nome1 = in.next();
					System.out.println();
					System.out.println("Inserisci il nome del secondo giocatore (Y) ");
					nome2 = in.next();
					GiocoMulti gm = new GiocoMulti();
					gm.play();
					break;
				default:
					System.exit(0);
					break;
			}
		}
	}
}