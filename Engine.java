import java.util.*;
	
	/*
	 * TARGET:	create an engine that
	 *			finds the correct move
	 *			to do.
	 */

public class Engine {

	//CAMPI
	static boolean playercanwin = false;
	static boolean computercanwin = false;

	//COSTRUTTORE
	public Engine() {
		//...
	}


	//METODI
	public static boolean puoVincere() {
		//if(puoVincereRiga() || puoVincereColonna()) || puoVincereDiagonale())
		if(puoVincerePrimaColonna() || puoVincereSecondaColonna() || puoVincereUltimaColonna() ||puoVincerePrimaRiga() || puoVincereSecondaRiga() || puoVincereUltimaRiga())
			return true;
		else 
			return false;
	}

	public static boolean puoPerdere() {
		//if(puoPerdereColonna() || puoPerdereRiga()) || puoPerdereDiagonale())
		if(puoPerderePrimaColonna() || puoPerdereSecondaColonna() || puoPerdereUltimaColonna() || puoPerderePrimaRiga() || puoPerdereSecondaRiga() || puoPerdereUltimaRiga())
			return true;
		else
			return false;
	}

	/*public static boolean puoPerdereColonna() {
		if(puoPerderePrimaColonna() || puoPerdereSecondaColonna() || puoPerdereUltimaColonna())
			return true;
		else
			return false;
	}

	public static boolean puoPerdereRiga() {
		if(puoPerderePrimaRiga() || puoPerdereSecondaRiga() || puoPerdereUltimaRiga())
			return true;
		else
			return false;
	}

	public static boolean puoPerdereDiagonale() {
		if(puoPerderePrimaDiagonale() || puoPerdereSecondaDiagonale())
			return true;
		else 
			return false;
	}

	public static boolean puoVincereColonna() {
		if(puoVincerePrimaColonna() || puoVincereSecondaColonna() || puoVincereUltimaColonna())
			return true;
		else
			return false;
	}

	public static boolean puoVincereRiga() {
		if(puoVincerePrimaRiga() || puoVincereSecondaRiga() || puoVincereUltimaRiga())
			return true;
		else
			return false;
	}

	public static boolean puoVincereDiagonale() {
		if(puoVincerePrimaDiagonale() || puoVincereSecondaDiagonale())
			return true;
		else 
			return false;
	}*/

	//Checking if it can loose ...
	public static boolean puoPerderePrimaColonna() {
		playercanwin = false;
		int h = 0;
		int y = 0;	//check the first column
		for (int x = 0; x < 3; x++) {
			if(Board.board[x][y] == "X") {
				h++;
				if(h == 2) {
					playercanwin = true;
					break;
				}
			}
		}
		return playercanwin;
	}

	public static boolean puoPerdereSecondaColonna() {
		playercanwin = false;
		int h = 0;
		int y = 1;	//check the middle column
		for (int x = 0; x < 3; x++) {
			if(Board.board[x][y] == "X") {
				h++;
				if(h == 2) {
					playercanwin = true;
					break;
				}
			}
		}
		return playercanwin;
	}

	public static boolean puoPerdereUltimaColonna() {
		playercanwin = false;
		int h = 0;
		int y = 2;	//check the last column
		for (int x = 0; x < 3; x++) {
			if(Board.board[x][y] == "X") {
				h++;
				if(h == 2) {
					playercanwin = true;
					break;
				}
			}
		}
		return playercanwin;
	}

	public static boolean puoPerderePrimaRiga() {
		playercanwin = false;
		int h = 0;
		int x = 0; //check the first row
		for (int y = 0; y < 3; y++) {
			if(Board.board[x][y] == "X") {
				h++;
				if(h == 2) {
					playercanwin = true;
					break;
				}
			}
		}
		return playercanwin;
	}

	public static boolean puoPerdereSecondaRiga() {
		playercanwin = false;
		int h = 0;
		int x = 1; //check the middle row
		for (int y = 0; y < 3; y++) {
			if(Board.board[x][y] == "X") {
				h++;
				if(h == 2) {
					playercanwin = true;
					break;
				}
			}
		}
		return playercanwin;
	}

	public static boolean puoPerdereUltimaRiga() {
		playercanwin = false;
		int h = 0;
		int x = 2; //check the last row
		for (int y = 0; y < 3; y++) {
			if(Board.board[x][y] == "X") {
				h++;
				if(h == 2) {
					playercanwin = true;
					break;
				}
			}
		}
		return playercanwin;
	}

	public static boolean puoPerderePrimaDiagonale() {
		playercanwin = false;
		int h = 0;
		//checking diagonals ...
		for (int x = 0; x < 3; x++) {
			int y = x;
			if(Board.board[x][y] == "X") {
				h++;
				if(h == 2) {
					playercanwin = true;
					break;
				}
			}
		}
		return playercanwin;
	}

	public static boolean puoPerdereSecondaDiagonale() {
		int h = 0;
		if(Board.board[2][0] == "X")
			h++;
		if(Board.board[1][1] == "X")
			h++;
		if(h != 2 && Board.board[0][2] == "X")
			h++;

		if(h == 2)
			playercanwin = true;
		return playercanwin;	
	}

	public static boolean puoVincerePrimaColonna() {
		computercanwin = false;
		int h = 0;
		int y = 0;	//check the first column
		for (int x = 0; x < 3; x++) {
			if(Board.board[x][y] == "O") {
				h++;
				if(h == 2) {
					computercanwin = true;
					break;
				}
			}
		}
		return computercanwin;
	}

	//Checking if it can win ...
	public static boolean puoVincereSecondaColonna() {
		computercanwin = false;
		int h = 0;
		int y = 1;	//check the middle column
		for (int x = 0; x < 3; x++) {
			if(Board.board[x][y] == "X") {
				h++;
				if(h == 2) {
					computercanwin = true;
					break;
				}
			}
		}
		return computercanwin;
	}

	public static boolean puoVincereUltimaColonna() {
		computercanwin = false;
		int h = 0;
		int y = 2;	//check the last column
		for (int x = 0; x < 3; x++) {
			if(Board.board[x][y] == "X") {
				h++;
				if(h == 2) {
					computercanwin = true;
					break;
				}
			}
		}
		return computercanwin;
	}

	public static boolean puoVincerePrimaRiga() {
		computercanwin = false;
		int h = 0;
		int x = 0; //check the first row
		for (int y = 0; y < 3; y++) {
			if(Board.board[x][y] == "X") {
				h++;
				if(h == 2) {
					computercanwin = true;
					break;
				}
			}
		}
		return computercanwin;
	}

	public static boolean puoVincereSecondaRiga() {
		computercanwin = false;
		int h = 0;
		int x = 1; //check the middle row
		for (int y = 0; y < 3; y++) {
			if(Board.board[x][y] == "X") {
				h++;
				if(h == 2) {
					computercanwin = true;
					break;
				}
			}
		}
		return computercanwin;
	}

	public static boolean puoVincereUltimaRiga() {
		computercanwin = false;
		int h = 0;
		int x = 2; //check the last row
		for (int y = 0; y < 3; y++) {
			if(Board.board[x][y] == "X") {
				h++;
				if(h == 2) {
					computercanwin = true;
					break;
				}
			}
		}
		return computercanwin;
	}

	public static boolean puoVincerePrimaDiagonale() {
		computercanwin = false;
		int h = 0;
		//checking diagonals ...
		for (int x = 0; x < 3; x++) {
			int y = x;
			if(Board.board[x][y] == "X") {
				h++;
				if(h == 2) {
					computercanwin = true;
					break;
				}
			}
		}
		return computercanwin;
	}

	public static boolean puoVincereSecondaDiagonale() {
		int h = 0;
		if(Board.board[2][0] == "X")
			h++;
		if(Board.board[1][1] == "X")
			h++;
		if(h != 2 && Board.board[0][2] == "X")
			h++;

		if(h == 2)
			computercanwin = true;
		return computercanwin;	
	}


}
