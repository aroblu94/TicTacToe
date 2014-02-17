import java.util.*;

public class Gioco {

	//CAMPI
	private Board board;
	private String player1 = "X";
	private String player2 = "O";
	private static int counter;

	//COSTRUTTORE
	public Gioco() {
		board = new Board();
	}

	//METODI
	public void play() {
		counter = 0;

		while(1==1) {
			if((counter != 9) && (board.getWinner() == false)) { //quando arriva a 9 e non ha vinto nessuno il gioco finisce
				System.out.println("Gioca il giocatore X. Inserisci le coordinate (x,y) ");
				Scanner in = new Scanner(System.in);
				Scanner token = new Scanner(in.next());
				token.useDelimiter(",");
				int x1 = Integer.parseInt(token.next());
				int y1 = Integer.parseInt(token.next());
				board.tic(x1-1,y1-1,player1);
				counter++; 

				System.out.println();
				System.out.println(board);
				System.out.println();

				if((counter != 9) && (board.getWinner() == false)) {
					System.out.println("Gioca il giocatore O. Inserisci le coordinate (x,y) ");
					token = new Scanner(in.next());
					token.useDelimiter(",");
					int x2 = Integer.parseInt(token.next());
					int y2 = Integer.parseInt(token.next());
					board.tic(x2-1,y2-1,player2);
					counter++;

					System.out.println();
					System.out.println(board);
					System.out.println();
				
				}
				else {
					if((counter == 9) && (board.getWinner() == false)){
						System.out.println();
						System.out.println("PARTITA TERMINATA IN PARITA'");
					}
					else {
						board.getWinner();
					}
					System.exit(0);
				}

			}
			else {
				if((counter == 9) && (board.getWinner() == false)){
					System.out.println();
					System.out.println("PARTITA TERMINATA IN PARITA'");
				}
				else {
					board.getWinner();
				}
				System.exit(0);
			}
		}
	}


}