public class Board {

	//CAMPI
	private String[][] board;
	private static final int rows = 3;
  	private static final int columns = 3;
  	private static boolean occupato;
  	private static boolean winner;
  	private static boolean winnerO;
  	private static boolean winnerX;
  	private static int h, k;

	//COSTRUTTORE
	//building an empty field (3*3 matrix)
	public Board() {
		board = new String[rows][columns];
		for(int x = 0; x < rows; x++) {
			for(int y = 0; y < columns; y++) {
				board[x][y] = " ";
			}
		}
	}

	//METODI
	//printing the matrix
	public String toString() {
		StringBuilder s = new StringBuilder();
		for(int x = 0; x < rows; x++) {
			for(int y = 0; y<columns; y++) {
				if (board[x][y] == " ")
					s.append("   ");
				else
					s.append(" " + board[x][y] + " ");
				if (y < columns -1)
					s.append("|");
			}
			if(x < rows -1) {
				s.append("\n");
				s.append("---+---+---");
				s.append("\n");
			}


		}
		return s.toString();
	}

	public String toStringInit() {
		StringBuilder sb = new StringBuilder();
		sb.append("1,1|1,2|1,3\n");
		sb.append("---+---+---\n");
		sb.append("2,1|2,2|2,3\n");
		sb.append("---+---+---\n");
		sb.append("3,1|3,2|3,3");
		return sb.toString();
	}

	//check the position isn't occupied
	public boolean Control(int x, int y) {
		if(board[x][y] != " ") {
			occupato = true;
			GiocoMulti.decCounter();
		}
		else
			occupato = false;

		return occupato;
	}

	public boolean tic(int x, int y, String player) {
			this.Control(x,y); //checking position ...
			if(!occupato) {
				board[x][y] = player;
				return true;
			}
			else {
				System.out.println("Position occupied, made no move. Retry ");
				return false;
			}
	}

	/*
	 * TARGET:	when there are 3 identical symbols
	 * 			in a row, a column or in diagonal
	 * 			the match finishes and the winner is
	 * 			the one has done a "tris".
	 * 			when there is a winner => winner = true
	 * 			and the match finishes.
	 */
	public boolean trisColonna() { //checking if there's a "tris" in a column
		h = 0;
		k = 0;
		winner = false;
		winnerX = false;
		winnerO = false;

		int y = 0;	//check the first column
		for (int x = 0; x < rows; x++) {
			if(board[x][y] == "X") {
				h++;
				if(h == 3) {
					winner = true;
					winnerX = true;
					break;
				}
			}
			else if(board[x][y] == "O") {
				k++;
				if(k == 3) {
					winner = true;
					winnerO = true;
					break;
				}
			}
		}
		k = 0;
		h = 0;

		y = 1;	//check the middle column
		for (int x = 0; x < rows; x++) {
			if(board[x][y] == "X") {
				h++;
				if(h == 3) {
					winner = true;
					winnerX = true;
					break;
				}
			}
			else if(board[x][y] == "O") {
				k++;
				if(k == 3) {
					winner = true;
					winnerO = true;
					break;
				}
			}
		}
		k = 0;
		h = 0;

		y = 2;	//check the last column
		for (int x = 0; x < rows; x++) {
			if(board[x][y] == "X") {
				h++;
				if(h == 3) {
					winner = true;
					winnerX = true;
					break;
				}
			}
			else if(board[x][y] == "O") {
				k++;
				if(k == 3) {
					winner = true;
					winnerO = true;
					break;
				}
			}
		}
		k = 0;
		h = 0;
		return winner;
	}

	public boolean trisRiga() { //check that there is the "tris" in row
		h = 0;
		k = 0;
		winner = false;
		winnerX = false;
		winnerO = false;

		int x = 0; //check the first row
		for (int y = 0; y < columns; y++) {
			if(board[x][y] == "X") {
				h++;
				if(h == 3) {
					winner = true;
					winnerX = true;
					break;
				}
			}
			else if(board[x][y] == "O") {
				k++;
				if(k == 3) {
					winner = true;
					winnerO = true;
					break;
				}
			}
		}
		k = 0;
		h = 0;

		x = 1; //check the middle row
		for (int y = 0; y < columns; y++) {
			if(board[x][y] == "X") {
				h++;
				if(h == 3) {
					winner = true;
					winnerX = true;
					break;
				}
			}
			else if(board[x][y] == "O") {
				k++;
				if(k == 3) {
					winner = true;
					winnerO = true;
					break;
				}
			}
		}
		k = 0;
		h = 0;

		x = 2; //check the last row
		for (int y = 0; y < columns; y++) {
			if(board[x][y] == "X") {
				h++;
				if(h == 3) {
					winner = true;
					winnerX = true;
					break;
				}
			}
			else if(board[x][y] == "O") {
				k++;
				if(k == 3) {
					winner = true;
					winnerO = true;
					break;
				}
			}
		}
		k = 0;
		h = 0;
		return winner;
	}

	public boolean trisDiagonale() { //check that there is the "tris" in diagonal
		h = 0;
		k = 0;
		winner = false;
		winnerX = false;
		winnerO = false;

		/*
		 * check the "tris" happen so:
		 * X
		 *  X
		 *   X
		 */
		for (int x = 0; x < rows; x++) {
			int y = x;
			if(board[x][y] == "X") {
				h++;
				if(h == 3) {
					winner = true;
					winnerX = true;
					break;
				}
			}
			else if(board[x][y] == "O") {
				k++;
				if(k == 3) {
					winner = true;
					winnerO = true;
					break;
				}
			}
		}
		k = 0;
		h = 0;

		/*
		 * check the "tris" happen so:
		 *   X
		 *  X
		 * X
		 */
		if(board[2][0] == "X")
			h++;
		else if(board[2][0] == "O")
			k++;
		if(board[1][1] == "X")
			h++;
		else if(board[1][1] == "O")
			k++;
		if(board[0][2] == "X")
			h++;
		else if(board[0][2] == "O")
			k++;

		if(h == 3) {
			winnerX = true;
			winner = true;
		}

		if(k == 3) {
			winnerO = true;
			winner = true;
		}

		k = 0;
		h = 0;
		return winner;	
	}

	public boolean getWinner() {
		if(this.trisRiga())
			this.trisRiga();
		else if(this.trisColonna())
			this.trisColonna();
		else if(this.trisDiagonale())
			this.trisDiagonale();
		else
			winner = false;
		return winner;
	}

	public boolean getWinnerX() {
		return winnerX;
	}

	public boolean getWinnerO() {
		return winnerO;
	}
}
