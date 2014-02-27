import java.util.*;

public class GiocoSingle {

	//CAMPI
	private Board board;
	private String player1 = "X";
	private String player2 = "O";
	private static int counter;
	private static boolean fatto;
	private static Scanner in = new Scanner(System.in);
	private static Scanner token;
	private boolean continua;
	private Random r = new Random();

	//COSTRUTTORE
	public GiocoSingle() {
		board = new Board();
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
						counter++; 
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

				System.out.println();
				System.out.println(board);
				System.out.println();

				if((counter != 9) && (!board.getWinner())) {
					System.out.println("Computer plays. ");
					fatto = false;
					while(!fatto) {
						int x2 = (r.nextInt(3));//(int)Math.random() * 2;
						int y2 = (r.nextInt(3));//(int)Math.random() * 2;
						if(board.tic(x2,y2,player2))
							fatto = true;
						else
							fatto = false;
						counter++;
					}
					System.out.println();
					System.out.println(board);
					System.out.println();
				}
				
				else {
					if((counter == 9) && (!board.getWinner())) {
						System.out.println();
						System.out.println("IT'S A TIE!");
					}
					else {
						board.getWinner();
						if(board.getWinnerX())
							System.out.println(Main.nome1.toUpperCase() + " WINS! ");
						else
							System.out.println("COMPUTER WINS! ");
					}
					continua = false;
				}

			}
			else {
				if((counter == 9) && (!board.getWinner())) {
					System.out.println();
					System.out.println("IT'S A TIE!");
				}
				else {
					board.getWinner();
					if(board.getWinnerX())
						System.out.println(Main.nome1.toUpperCase() + " WINS! ");
					else
						System.out.println("COMPUTER WINS! ");
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
}
