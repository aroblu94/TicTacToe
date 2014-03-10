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
		int disputate = 0;
		double percX = 0;
		double percO = 0;
		double percPari = 0;
			
		while(continua) {
			fatto = false;
			while(!fatto) {
				System.out.println("Choose what you want to do (4 or more to exit): ");
				System.out.println("(1) Singleplayer ");
				System.out.println("(2) Multiplayer ");
				System.out.println("(3) View results ");
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
					System.out.println("Enter player's name ");
					nome1 = in.next();
					System.out.println();
					GiocoSingle gs = new GiocoSingle();
					System.out.println(gs.getBoard().toStringInit());
					System.out.println();
					gs.play();
					break;
				case 2:
					single = false;
					System.out.println("Enter first player's name (X) ");
					nome1 = in.next();
					System.out.println();
					System.out.println("Enter second player's name (Y) ");
					nome2 = in.next();
					System.out.println();
					GiocoMulti gm = new GiocoMulti();
					System.out.println(gm.getBoard().toStringInit());
					System.out.println();
					gm.play();
					break;
				case 3:
					int vinteX = GiocoMulti.vinteX() + GiocoSingle.vinteX();
					int vinteO = GiocoMulti.vinteO() + GiocoSingle.vinteO();
					int pari = GiocoMulti.pari() + GiocoSingle.pari();
					if(disputate != 0) {
						percX = (double)vinteX / (double)disputate * 100;
						percO = (double)vinteO / (double)disputate * 100;
						percPari = (double)pari / (double)disputate * 100;
					}
					else {
						percX = 0;
						percO = 0;
						percPari = 0;
					}

					System.out.println("RESULTS:");
					System.out.println("Player X: " + vinteX + " game(s) won (" + percX + "%) ");
					System.out.println("Player O: " + vinteO + " game(s) won (" + percO + "%) ");
					System.out.println("Ties: " + pari + " (" + percPari + "%) ");
					break;
				default:
					System.exit(0);
					break;
			}
			System.out.println();
			System.out.println("Want to play again? (y/n) ");
			if(in.next().toUpperCase().equals("Y"))
				continua = true;
			else
				continua = false;
			disputate++;
			System.out.println();
		}
	}
}