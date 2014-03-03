import java.util.*;
	
	/*
	 * TARGET:	create an engine that
	 *			finds the correct move
	 *			to do.
	 */

public class Engine {

	//CAMPI
	private static boolean vuoto = true;
	//COSTRUTTORE
	public Engine() {
		//...
	}


	//METODI
	public static boolean puoVincere() {
		return (puoVincerePrimaColonna() || puoVincereSecondaColonna() || puoVincereUltimaColonna() ||puoVincerePrimaRiga() || puoVincereSecondaRiga() || puoVincereUltimaRiga());
	}

	public static boolean puoPerdere() {
		return (puoPerderePrimaColonna() || puoPerdereSecondaColonna() || puoPerdereUltimaColonna() || puoPerderePrimaRiga() || puoPerdereSecondaRiga() || puoPerdereUltimaRiga());
	}

	//Checking if it can loose ...
	public static boolean puoPerderePrimaColonna() {
		vuoto = false;
		int h = 0;
		int y = 0;	//check the first column
		for (int x = 0; x < 3; x++) {
			if(Board.board[x][y] == "X")
				h++;
		}
		for(int x = 0; x < 3; x++) {
			if(Board.board[x][y] == " ") {
				vuoto = true;
				break;
			}
		}
		if(h > 1 && vuoto)
			return true;
		else
			return false;
	}

	public static boolean puoPerdereSecondaColonna() {
		vuoto = false;
		int h = 0;
		int y = 1;	//check the middle column
		for (int x = 0; x < 3; x++) {
			if(Board.board[x][y] == "X")
				h++;
		}
		for(int x = 0; x < 3; x++) {
			if(Board.board[x][y] == " ") {
				vuoto = true;
				break;
			}
		}
		if(h > 1 && vuoto)
			return true;
		else
			return false;
	}

	public static boolean puoPerdereUltimaColonna() {
		vuoto = false;
		int h = 0;
		int y = 2;	//check the last column
		for (int x = 0; x < 3; x++) {
			if(Board.board[x][y] == "X")
				h++;
		}
		for(int x = 0; x < 3; x++) {
			if(Board.board[x][y] == " ") {
				vuoto = true;
				break;
			}
		}
		if(h > 1 && vuoto)
			return true;
		else
			return false;
	}

	public static boolean puoPerderePrimaRiga() {
		vuoto = false;
		int h = 0;
		int x = 0; //check the first row
		for (int y = 0; y < 3; y++) {
			if(Board.board[x][y] == "X")
				h++;
		}
		for(int y = 0; y < 3; y++) {
			if(Board.board[x][y] == " ") {
				vuoto = true;
				break;
			}
		}
		if(h > 1 && vuoto)
			return true;
		else
			return false;
	}

	public static boolean puoPerdereSecondaRiga() {
		vuoto = false;
		int h = 0;
		int x = 1; //check the middle row
		for (int y = 0; y < 3; y++) {
			if(Board.board[x][y] == "X")
				h++;
		}
		for(int y = 0; y < 3; y++) {
			if(Board.board[x][y] == " ") {
				vuoto = true;
				break;
			}
		}
		if(h > 1 && vuoto)
			return true;
		else
			return false;
	}

	public static boolean puoPerdereUltimaRiga() {
		vuoto = false;
		int h = 0;
		int x = 2; //check the last row
		for (int y = 0; y < 3; y++) {
			if(Board.board[x][y] == "X")
				h++;
		}
		for(int y = 0; y < 3; y++) {
			if(Board.board[x][y] == " ") {
				vuoto = true;
				break;
			}
		}
		if(h > 1 && vuoto)
			return true;
		else
			return false;
	}

	public static boolean puoPerderePrimaDiagonale() {
		vuoto = false;
		int h = 0;
		//checking diagonals ...
		for (int x = 0; x < 3; x++) {
			int y = x;
			if(Board.board[x][y] == "X")
				h++;
		}
		for (int x = 0; x < 3; x++) {
			int y = x;
			if(Board.board[x][y] == " ") {
				vuoto = true;
				break;
			}
		}
		if(h > 1 && vuoto)
			return true;
		else
			return false;
	}

	public static boolean puoPerdereSecondaDiagonale() {
		vuoto = false;
		int h = 0;
		if(Board.board[2][0] == "X")
			h++;
		if(Board.board[1][1] == "X")
			h++;
		if(Board.board[0][2] == "X")
			h++;
		if(Board.board[2][0] == " " || Board.board[1][1] == " " || Board.board[0][2] == " ")
			vuoto = true;
		if(h > 1 && vuoto)
			return true;
		else
			return false;	
	}

	//Checking if it can win...
	public static boolean puoVincerePrimaColonna() {
		vuoto = false;
		int h = 0;
		int y = 0;	//check the first column
		for (int x = 0; x < 3; x++) {
			if(Board.board[x][y] == "O")
				h++;
		}
		for(int x = 0; x < 3; x++) {
			if(Board.board[x][y] == " ") {
				vuoto = true;
				break;
			}
		}
		if(h > 1 && vuoto)
			return true;
		else
			return false;
	}

	public static boolean puoVincereSecondaColonna() {
		vuoto = false;
		int h = 0;
		int y = 1;	//check the middle column
		for (int x = 0; x < 3; x++) {
			if(Board.board[x][y] == "O")
				h++;
		}
		for(int x = 0; x < 3; x++) {
			if(Board.board[x][y] == " ") {
				vuoto = true;
				break;
			}
		}
		if(h > 1 && vuoto)
			return true;
		else
			return false;
	}

	public static boolean puoVincereUltimaColonna() {
		vuoto = false;
		int h = 0;
		int y = 2;	//check the last column
		for (int x = 0; x < 3; x++) {
			if(Board.board[x][y] == "O")
				h++;
		}
		for(int x = 0; x < 3; x++) {
			if(Board.board[x][y] == " ") {
				vuoto = true;
				break;
			}
		}
		if(h > 1 && vuoto)
			return true;
		else
			return false;
	}

	public static boolean puoVincerePrimaRiga() {
		vuoto = false;
		int h = 0;
		int x = 0; //check the first row
		for (int y = 0; y < 3; y++) {
			if(Board.board[x][y] == "O")
				h++;
		}
		for(int y = 0; y < 3; y++) {
			if(Board.board[x][y] == " ") {
				vuoto = true;
				break;
			}
		}
		if(h > 1 && vuoto)
			return true;
		else
			return false;
	}

	public static boolean puoVincereSecondaRiga() {
		vuoto = false;
		int h = 0;
		int x = 1; //check the middle row
		for (int y = 0; y < 3; y++) {
			if(Board.board[x][y] == "O")
				h++;
		}
		for(int y = 0; y < 3; y++) {
			if(Board.board[x][y] == " ") {
				vuoto = true;
				break;
			}
		}
		if(h > 1 && vuoto)
			return true;
		else
			return false;
	}

	public static boolean puoVincereUltimaRiga() {
		vuoto = false;
		int h = 0;
		int x = 2; //check the last row
		for (int y = 0; y < 3; y++) {
			if(Board.board[x][y] == "O")
				h++;
		}
		for(int y = 0; y < 3; y++) {
			if(Board.board[x][y] == " ") {
				vuoto = true;
				break;
			}
		}
		if(h > 1 && vuoto)
			return true;
		else
			return false;
	}

	public static boolean puoVincerePrimaDiagonale() {
		vuoto = false;
		int h = 0;
		//checking diagonals ...
		for (int x = 0; x < 3; x++) {
			int y = x;
			if(Board.board[x][y] == "O")
				h++;
		}
		for (int x = 0; x < 3; x++) {
			int y = x;
			if(Board.board[x][y] == " ") {
				vuoto = true;
				break;
			}
		}
		if(h > 1 && vuoto)
			return true;
		else
			return false;
	}

	public static boolean puoVincereSecondaDiagonale() {
		vuoto = false;
		int h = 0;
		if(Board.board[2][0] == "O")
			h++;
		if(Board.board[1][1] == "O")
			h++;
		if(Board.board[0][2] == "O")
			h++;
		if(Board.board[2][0] == " " || Board.board[1][1] == " " || Board.board[0][2] == " ")
			vuoto = true;
		if(h > 1 && vuoto)
			return true;
		else
			return false;	
	}


}
