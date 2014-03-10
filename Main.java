import java.util.*;
import java.lang.*;

public class Main {

	public static String nome1, nome2;
	public static boolean single = true;

	public static void main(String[] args) {
		Scanner in = null;
		boolean continua = true;
		boolean fatto;
		int selettore = 0;
		int disputateSingle = 0;
		int disputateMulti = 0;
		double percX = 0;
		double percO = 0;
		double percPari = 0;
		double percVinteSingle = 0;
		double percPerseSingle = 0;
		double percPariSingle = 0;
		double percPariMulti = 0;
			
		while(continua) {
			fatto = false;
			while(!fatto) {
				System.out.println("Choose what you want to do (5 or more to exit): ");
				System.out.println("(1) Singleplayer ");
				System.out.println("(2) Multiplayer ");
				System.out.println("(3) View results ");
				System.out.println("(4) Help ");
				try {
					in = new Scanner(System.in);
					selettore = in.nextInt();
					fatto = true;
					break;
				}
				catch(InputMismatchException e) {
					System.out.println("Input is not in the correct format. Please try again");
					fatto = false;
				}
				System.out.println();
			}

			switch(selettore) {
				case 1:
					single = true;
					Clear.clear();
					System.out.println("Enter player's name ");
					nome1 = in.next();
					//System.out.println();
					GiocoSingle gs = new GiocoSingle();
					System.out.println();
					Clear.clear();
					//System.out.println();
					gs.play();
					disputateSingle++;
					break;
				case 2:
					single = false;
					Clear.clear();
					System.out.println("Enter first player's name (X) ");
					nome1 = in.next();
					//System.out.println();
					Clear.clear();
					System.out.println("Enter second player's name (Y) ");
					nome2 = in.next();
					//System.out.println();
					Clear.clear();
					GiocoMulti gm = new GiocoMulti();
					//System.out.println();
					Clear.clear();
					gm.play();
					disputateMulti++;
					break;
				case 3:
					Clear.clear();
					int vinteX = GiocoMulti.vinteX();
					int vinteO = GiocoMulti.vinteO();
					int pariMulti = GiocoMulti.pari();
					if(disputateMulti != 0) {
						percX = (double)vinteX / (double)disputateMulti * 100;
						percO = (double)vinteO / (double)disputateMulti * 100;
						percPariMulti = (double)pariMulti / (double)disputateMulti * 100;
					}
					else {
						percX = 0;
						percO = 0;
						percPariMulti = 0;
					}

					int vinteSingle = GiocoSingle.vinteX();
					int perseSingle = GiocoSingle.vinteO();
					int pariSingle = GiocoSingle.pari();
					if(disputateSingle != 0) {
						percVinteSingle = (double)vinteSingle / (double)disputateSingle * 100;
						percPerseSingle = (double)perseSingle / (double)disputateSingle * 100;
						percPariSingle = (double)pariSingle / (double)disputateSingle * 100;
					}
					else {
						percVinteSingle = 0;
						percPerseSingle = 0;
						percPariSingle = 0;
					}

					System.out.println(".:RESULTS:.");
					System.out.println();
					System.out.println("Singleplayer: ");
					System.out.println("Wons: " + vinteSingle + " (" + percVinteSingle + "%) ");
					System.out.println("Losts: " + perseSingle + " (" + percPerseSingle + "%) ");
					System.out.println("Ties: " + pariSingle + " (" + percPariSingle + "%) ");
					System.out.println();
					System.out.println("Multiplayer: ");
					System.out.println("Wons by " + nome1 + ": " + vinteX + " (" + percX + "%) ");
					System.out.println("Wons by " + nome2 + ": " + vinteO + " (" + percO + "%) ");
					System.out.println("Ties: " + pariMulti + " (" + percPariMulti + "%) ");
					System.out.println();
					break;
				case 4:
					Clear.clear();
					System.out.println(".:HOW TO PLAY:. ");
					System.out.println("The target of the game is to do a 'tris'.");
					System.out.println("A 'tris' is when you put 3 times the same symbol (X or O)");
					System.out.println("in row, column or diagonal. ");
					System.out.println();
					System.out.println("The input is in the format 'x,y': ");
					System.out.println();
					System.out.println(Board.toStringInit());
					System.out.println();
					break;
				default:
					System.exit(0);
					break;
			}
			//System.out.println();
			System.out.println("Want to play again? (y/n) ");
			if(in.next().toUpperCase().equals("Y"))
				continua = true;
			else
				continua = false;
			//System.out.println();
			Clear.clear();
		}
	}
}