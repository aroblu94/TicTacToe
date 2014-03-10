import java.util.*;

public class GiocoMulti {

	//CAMPI
	private Board board;
	private String player1 = "X";
	private String player2 = "O";
	private static int counter;
	private static boolean fatto;
	private static Scanner in = new Scanner(System.in);
	private static Scanner token;
	private boolean continua;
	private static int vinteX = 0;
	private static int vinteO = 0;
	private static int pari = 0;

	//COSTRUTTORE
	public GiocoMulti() {
		board = new Board();
		vinteX = 0;
		vinteO = 0;
		pari = 0;
	}

	//METODI
	public void play() {
		counter = 0;
		continua = true;

		while(continua) {
			if((counter != 9) && (!board.getWinner())) { //when counter = 9 it's a tie
				System.out.println(Main.nome1 + " plays. Insert coordinates (row,column) ");
				fatto = false;
				while(!fatto) {
					try {
						token = new Scanner(in.next());
						token.useDelimiter(",");
						int x1 = Integer.parseInt(token.next());
						int y1 = Integer.parseInt(token.next());
						if(board.tic(x1-1,y1-1,player1))
							fatto = true;
						else
							fatto = false;
					}
					catch (NumberFormatException e) {
						System.out.println("Input is not in the correct format. Please try again");
						fatto = false;
					}
					catch (ArrayIndexOutOfBoundsException e) {
						System.out.println("Input is not in the correct format. Please try again");
						fatto = false;
					}
					catch (NoSuchElementException e) {
						System.out.println("Input is not in the correct format. Please try again");
						fatto = false;
					}
				}
				counter++; 

				System.out.println();
				System.out.println(board);
				System.out.println();

				if((counter != 9) && (!board.getWinner())) {
					System.out.println(Main.nome2 + " plays. Insert coordinates (row,column) ");
					fatto = false;
					while(!fatto) {
						try {
							token = new Scanner(in.next());
							token.useDelimiter(",");
							int x2 = Integer.parseInt(token.next());
							int y2 = Integer.parseInt(token.next());
							if(board.tic(x2-1,y2-1,player2))
								fatto = true;
							else
								fatto = false;
						}
						catch (NumberFormatException e) {
							System.out.println("Input is not in the correct format. Please try again");
							fatto = false;
						}
						catch (ArrayIndexOutOfBoundsException e) {
							System.out.println("Input is not in the correct format. Please try again");
							fatto = false;
						}
					}
					counter++; 

					System.out.println();
					System.out.println(board);
					System.out.println();
				
				}
				else {
					if((counter == 9) && (!board.getWinner())) {
						System.out.println();
						System.out.println("IT'S A TIE!");
						pari++;
					}
					else {
						board.getWinner();
						if(board.getWinnerX()) {
							System.out.println(Main.nome1.toUpperCase() + " (X) WINS! ");
							vinteX++;
						}
						else {
							System.out.println(Main.nome2.toUpperCase() + " (O) WINS! ");
							vinteO++;
						}
					}
					continua = false;
				}

			}
			else {
				if((counter == 9) && (!board.getWinner())) {
					System.out.println();
					System.out.println("IT'S A TIE!");
					pari++;
				}
				else {
					board.getWinner();
					if(board.getWinnerX()) {
						System.out.println(Main.nome1.toUpperCase() + " (X) WINS! ");
						vinteX++;
					}
					else {
						System.out.println(Main.nome2.toUpperCase() + " (O) WINS! ");
						vinteO++;
					}
				}
				continua = false;
			}
		}
	}

	public static int getCounter() {
		return counter;
	}

	public static void decCounter() { 
		counter--;
	}

	public Board getBoard() {
		return board;
	}

	public static int vinteX() {
		return vinteX;
	}

	public static int vinteO() {
		return vinteO;
	}

	public static int pari() {
		return pari;
	}


}
