import java.util.*;

public class GiocoSingle {

	//CAMPI
	private final boolean debug = false;
	static Board board;
	private String player1 = "X";
	private String player2 = "O";
	private static int counter;
	private static boolean fatto;
	private static Scanner in = new Scanner(System.in);
	private static Scanner token;
	private boolean continua;
	private Random r = new Random();
	private int x2 = 0, y2 = 0;
	private static int vinteX = 0;
	private static int vinteO = 0;
	private static int pari = 0;

	//COSTRUTTORE
	public GiocoSingle() {
		board = new Board();
	}

	//METODI
	public void play() {
		counter = 0;
		continua = true;
		Clear.clear();
		System.out.println();
		System.out.println(board);
		System.out.println();

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

				Clear.clear();
				System.out.println();
				System.out.println(board);
				System.out.println();

				if((counter != 9) && (!board.getWinner())) {
					System.out.println("Computer plays... ");
					try {
						Thread.sleep(2000);
					}
					catch(InterruptedException e) {}
					fatto = false;
					while(!fatto) {
						//Can computer win?
						if(Engine.puoVincerePrimaColonna()) {
							if(debug) {System.out.println("Il pc puo' vincere sulla prima colonna");}
							y2 = 0;
							for(int x = 0; x < 3; x++) {
								if(Board.board[x][y2] == " ") {
									x2 = x;
									break;
								}
							}
						}
						else if(Engine.puoVincereSecondaColonna()) {
							if(debug) {System.out.println("Il pc puo' vincere sulla seconda colonna");}
							y2 = 1;
							for(int x = 0; x < 3; x++) {
								if(Board.board[x][y2] == " ") {
									x2 = x;
									break;
								}
							}
						}
						else if(Engine.puoVincereUltimaColonna()) {
							if(debug) {System.out.println("Il pc puo' vincere sull'ultima colonna");}
							y2 = 2;
							for(int x = 0; x < 3; x++) {
								if(Board.board[x][y2] == " ") {
									x2 = x;
									break;
								}
							}
						}
						else if(Engine.puoVincerePrimaRiga()) {
							if(debug) {System.out.println("Il pc puo' vincere sulla prima riga");}
							x2 = 0;
							for(int y = 0; y < 3; y++) {
								if(Board.board[x2][y] == " ") {
									y2 = y;
									break;
								}
							}
						}
						else if(Engine.puoVincereSecondaRiga()) {
							if(debug) {System.out.println("Il pc puo' vincere sulla seconda riga");}
							x2 = 1;
							for(int y = 0; y < 3; y++) {
								if(Board.board[x2][y] == " ") {
									y2 = y;
									break;
								}
							}
						}
						else if(Engine.puoVincereUltimaRiga()) {
							if(debug) {System.out.println("Il pc puo' vincere sull'ultima riga");}
							x2 = 2;
							for(int y = 0; y < 3; y++) {
								if(Board.board[x2][y] == " ") {
									y2 = y;
									break;
								}
							}
						}
						else if(Engine.puoVincerePrimaDiagonale()) {
							for(int x = 0; x < 3; x++) {
								if(Board.board[x][x] == " ") {
									x2 = x;
									y2 = x;
									break;
								}
							}
						}
						else if(Engine.puoVincereSecondaDiagonale()) {
							if(Board.board[2][0] == " ") {
								x2 = 2;
								y2 = 0;
							}
							else if(Board.board[1][1] == " ") {
								x2 = 1;
								y2 = 1;
							}
							else if(Board.board[0][2] == " ") {
								x2 = 0;
								y2 = 2;
							}
						}
						//Can computer loose?
						else if(Engine.puoPerderePrimaColonna()) {
							if(debug) {System.out.println("Il pc puo' perdere sulla prima colonna");}
							y2 = 0;
							for(int x = 0; x < 3; x++) {
								if(Board.board[x][y2] == " ") {
									x2 = x;
									break;
								}
							}
						}
						else if(Engine.puoPerdereSecondaColonna()) {
							if(debug) {System.out.println("Il pc puo' perdere sulla seconda colonna");}
							y2 = 1;
							for(int x = 0; x < 3; x++) {
								if(Board.board[x][y2] == " ") {
									x2 = x;
									break;
								}
							}
						}
						else if(Engine.puoPerdereUltimaColonna()) {
							if(debug) {System.out.println("Il pc puo' perdere sull'ultima colonna");}
							y2 = 2;
							for(int x = 0; x < 3; x++) {
								if(Board.board[x][y2] == " ") {
									x2 = x;
									break;
								}
							}
						}
						else if(Engine.puoPerderePrimaRiga()) {
							if(debug) {System.out.println("Il pc puo' perdere sulla prima riga");}
							x2 = 0;
							for(int y = 0; y < 3; y++) {
								if(Board.board[x2][y] == " ") {
									y2 = y;
									break;
								}
							}
						}
						else if(Engine.puoPerdereSecondaRiga()) {
							if(debug) {System.out.println("Il pc puo' perdere sulla seconda riga");}
							x2 = 1;
							for(int y = 0; y < 3; y++) {
								if(Board.board[x2][y] == " ") {
									y2 = y;
									break;
								}
							}
						}
						else if(Engine.puoPerdereUltimaRiga()) {
							if(debug) {System.out.println("Il pc puo' perdere sull'ultima riga");}
							x2 = 2;
							for(int y = 0; y < 3; y++) {
								if(Board.board[x2][y] == " ") {
									y2 = y;
									break;
								}
							}
						}
						else if(Engine.puoPerderePrimaDiagonale()) {
							for(int x = 0; x < 3; x++) {
								if(Board.board[x][x] == " ") {
									x2 = x;
									y2 = x;
									break;
								}
							}
						}
						else if(Engine.puoPerdereSecondaDiagonale()) {
							if(Board.board[2][0] == " ") {
								x2 = 2;
								y2 = 0;
							}
							else if(Board.board[1][1] == " ") {
								x2 = 1;
								y2 = 1;
							}
							else if(Board.board[0][2] == " ") {
								x2 = 0;
								y2 = 2;
							}	
						}
						//Controllo se il centro e' vuoto
						else if(Board.board[1][1].equals(" ")) {
							x2 = 1;
							y2 = 1;
						}
						else {
							if(debug) {System.out.println("Mossa casuale");}
							x2 = (r.nextInt(3));
							y2 = (r.nextInt(3));
						}
						if(board.tic(x2,y2,player2))
							fatto = true;
						else
							fatto = false;
					}
					counter++;
					Clear.clear();
					System.out.println();
					System.out.println(board);
					System.out.println();
				}
				
				else {
					if((counter == 9) && (!board.getWinner())) {
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
							System.out.println("COMPUTER (O) WINS! ");
							vinteO++;
						}
					}
					continua = false;
				}
			}

			else {
				if((counter == 9) && (!board.getWinner())) {
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
						System.out.println("COMPUTER (O) WINS! ");
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

	public static Board getBoard() {
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
