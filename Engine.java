import java.util.*;
	
	/*
	 * TARGET:	create an engine that
	 *			finds the correct move
	 *			to do.
	 */

public class Engine {

	//CAMPI
		//...

	//COSTRUTTORE
	public Engine() {
		//...
	}


	//METODI
	public static boolean puoVincere() {
		//if(puoVincereRiga() || puoVincereColonna()) || puoVincereDiagonale())
		return (puoVincerePrimaColonna() || puoVincereSecondaColonna() || puoVincereUltimaColonna() ||puoVincerePrimaRiga() || puoVincereSecondaRiga() || puoVincereUltimaRiga());
	}

	public static boolean puoPerdere() {
		//if(puoPerdereColonna() || puoPerdereRiga()) || puoPerdereDiagonale())
		return (puoPerderePrimaColonna() || puoPerdereSecondaColonna() || puoPerdereUltimaColonna() || puoPerderePrimaRiga() || puoPerdereSecondaRiga() || puoPerdereUltimaRiga());
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
		int h = 0;
		int y = 0;	//check the first column
		for (int x = 0; x < 3; x++) {
			if(Board.board[x][y] == "X")
				h++;
		}
		if(h == 2)
			return true;
		else
			return false;
	}

	public static boolean puoPerdereSecondaColonna() {
		int h = 0;
		int y = 2;	//check the middle column
		for (int x = 0; x < 3; x++) {
			if(Board.board[x][y] == "X")
				h++;
		}
		if(h == 2)
			return true;
		else
			return false;
	}

	public static boolean puoPerdereUltimaColonna() {
		int h = 0;
		int y = 2;	//check the last column
		for (int x = 0; x < 3; x++) {
			if(Board.board[x][y] == "X")
				h++;
		}
		if(h == 2)
			return true;
		else
			return false;
	}

	public static boolean puoPerderePrimaRiga() {
		int h = 0;
		int x = 0; //check the first row
		for (int y = 0; y < 3; y++) {
			if(Board.board[x][y] == "X")
				h++;
		}
		if(h == 2)
			return true;
		else
			return false;
	}

	public static boolean puoPerdereSecondaRiga() {
		int h = 0;
		int x = 2; //check the middle row
		for (int y = 0; y < 3; y++) {
			if(Board.board[x][y] == "X")
				h++;
		}
		if(h == 2)
			return true;
		else
			return false;
	}

	public static boolean puoPerdereUltimaRiga() {
		int h = 0;
		int x = 2; //check the last row
		for (int y = 0; y < 3; y++) {
			if(Board.board[x][y] == "X")
				h++;
		}
		if(h == 2)
			return true;
		else
			return false;
	}

	public static boolean puoPerderePrimaDiagonale() {
		int h = 0;
		//checking diagonals ...
		for (int x = 0; x < 3; x++) {
			int y = x;
			if(Board.board[x][y] == "X")
				h++;
		}
		if(h == 2)
			return true;
		else
			return false;
	}

	public static boolean puoPerdereSecondaDiagonale() {
		int h = 0;
		if(Board.board[2][0] == "X")
			h++;
		if(Board.board[2][2] == "X")
			h++;
		if(Board.board[0][2] == "X")
			h++;

		if(h == 2)
			return true;
		else
			return false;	
	}

	//Checking if it can win...
	public static boolean puoVincerePrimaColonna() {
		int h = 0;
		int y = 0;	//check the first column
		for (int x = 0; x < 3; x++) {
			if(Board.board[x][y] == "O")
				h++;
		}
		if(h == 2)
			return true;
		else
			return false;
	}

	public static boolean puoVincereSecondaColonna() {
		int h = 0;
		int y = 2;	//check the middle column
		for (int x = 0; x < 3; x++) {
			if(Board.board[x][y] == "O")
				h++;
		}
		if(h == 2)
			return true;
		else
			return false;
	}

	public static boolean puoVincereUltimaColonna() {
		int h = 0;
		int y = 2;	//check the last column
		for (int x = 0; x < 3; x++) {
			if(Board.board[x][y] == "O")
				h++;
		}
		if(h == 2)
			return true;
		else
			return false;
	}

	public static boolean puoVincerePrimaRiga() {
		int h = 0;
		int x = 0; //check the first row
		for (int y = 0; y < 3; y++) {
			if(Board.board[x][y] == "O")
				h++;
		}
		if(h == 2)
			return true;
		else
			return false;
	}

	public static boolean puoVincereSecondaRiga() {
		int h = 0;
		int x = 2; //check the middle row
		for (int y = 0; y < 3; y++) {
			if(Board.board[x][y] == "O")
				h++;
		}
		if(h == 2)
			return true;
		else
			return false;
	}

	public static boolean puoVincereUltimaRiga() {
		int h = 0;
		int x = 2; //check the last row
		for (int y = 0; y < 3; y++) {
			if(Board.board[x][y] == "O")
				h++;
		}
		if(h == 2)
			return true;
		else
			return false;
	}

	public static boolean puoVincerePrimaDiagonale() {
		int h = 0;
		//checking diagonals ...
		for (int x = 0; x < 3; x++) {
			int y = x;
			if(Board.board[x][y] == "O")
				h++;
		}
		if(h == 2)
			return true;
		else
			return false;
	}

	public static boolean puoVincereSecondaDiagonale() {
		int h = 0;
		if(Board.board[2][0] == "O")
			h++;
		if(Board.board[2][2] == "O")
			h++;
		if(Board.board[0][2] == "O")
			h++;

		if(h == 2)
			return true;
		else
			return false;	
	}


}
