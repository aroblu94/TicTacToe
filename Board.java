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
	//costruisco il campo (matrice 3*3) vuoto
	public Board() {
		board = new String[rows][columns];
		for(int x = 0; x < rows; x++) {
			for(int y = 0; y < columns; y++) {
				board[x][y] = " ";
			}
		}
	}

	//METODI
	//stampo lo stato della matrice
	public String toString() {
		StringBuilder s = new StringBuilder();
		for(int x = 0; x < rows; x++) {
			for(int y = 0; y<columns; y++) {
				if (board[x][y] == " ")
					s.append(" ");
				else
					s.append(board[x][y]);
				if (y < columns -1)
					s.append("|");
			}
			if(x < rows -1) {
				s.append("\n");
				s.append("------");
				s.append("\n");
			}


		}
		return s.toString();
	}

	//controllo che la posizione non sia occupata
	public boolean Control(int x, int y) {
		if(board[x][y] != " ") {
			occupato = true;
			Gioco.decCounter();
		}
		else
			occupato = false;

		return occupato;
	}

	public void tic(int x, int y, String player) {
		this.Control(x,y); //controllo posizione
		if(occupato == false)
			board[x][y] = player;
		else
			System.out.println("Posizione occupata, nessuna mossa effettuata ");
	}

	/*
	 * OBIETTIVO: quando ci sono 3 simboli uguali
	 * in colonna, in riga o in diagonale
	 * la partita finisce segnalando come vincitore
	 * il giocatore con il simbolo che ha fatto "tris"
	 * quando trova un vincitore => winner = true
	 * e la partita finisce
	 */
	public boolean trisColonna() { //controllo che ci sia il "tris" in colonna
		h = 0;
		k = 0;
		winner = false;
		winnerX = false;
		winnerO = false;

		int y = 0;	//controllo sulla riga in alto
		for (int x = 0; x < rows; x++) {
			if(board[x][y] == "X") {
				h++;
				if(h == 3) {
					//System.out.println("VINCE IL GIOCATORE X (colonna)");
					winner = true;
					winnerX = true;
					break;
				}
			}
			else if(board[x][y] == "O") {
				k++;
				if(k == 3) {
					//System.out.println("VINCE IL GIOCATORE O (colonna)");
					winner = true;
					winnerO = true;
					break;
				}
			}
		}
		k = 0;
		h = 0;

		y = 1;	//controllo sulla colonna centrale
		for (int x = 0; x < rows; x++) {
			if(board[x][y] == "X") {
				h++;
				if(h == 3) {
					//System.out.println("VINCE IL GIOCATORE X (colonna)");
					winner = true;
					winnerX = true;
					break;
				}
			}
			else if(board[x][y] == "O") {
				k++;
				if(k == 3) {
					//System.out.println("VINCE IL GIOCATORE O (colonna)");
					winner = true;
					winnerO = true;
					break;
				}
			}
		}
		k = 0;
		h = 0;

		y = 2;	//controllo sull'ultima colonna
		for (int x = 0; x < rows; x++) {
			if(board[x][y] == "X") {
				h++;
				if(h == 3) {
					//System.out.println("VINCE IL GIOCATORE X (colonna)");
					winner = true;
					winnerX = true;
					break;
				}
			}
			else if(board[x][y] == "O") {
				k++;
				if(k == 3) {
					//System.out.println("VINCE IL GIOCATORE O (colonna)");
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

	public boolean trisRiga() { //controllo che ci sia il "tris" in riga
		h = 0;
		k = 0;
		winner = false;
		winnerX = false;
		winnerO = false;

		int x = 0; //controllo riga sinistra
		for (int y = 0; y < columns; y++) {
			if(board[x][y] == "X") {
				h++;
				if(h == 3) {
					//System.out.println("VINCE IL GIOCATORE X (riga)");
					winner = true;
					winnerX = true;
					break;
				}
			}
			else if(board[x][y] == "O") {
				k++;
				if(k == 3) {
					//System.out.println("VINCE IL GIOCATORE O (riga)");
					winner = true;
					winnerO = true;
					break;
				}
			}
		}
		k = 0;
		h = 0;

		x = 1; //controllo colonna centrale
		for (int y = 0; y < columns; y++) {
			if(board[x][y] == "X") {
				h++;
				if(h == 3) {
					//System.out.println("VINCE IL GIOCATORE X (riga)");
					winner = true;
					winnerX = true;
					break;
				}
			}
			else if(board[x][y] == "O") {
				k++;
				if(k == 3) {
					//System.out.println("VINCE IL GIOCATORE O (riga)");
					winner = true;
					winnerO = true;
					break;
				}
			}
		}
		k = 0;
		h = 0;

		x = 2; //controllo riga destra
		for (int y = 0; y < columns; y++) {
			if(board[x][y] == "X") {
				h++;
				if(h == 3) {
					//System.out.println("VINCE IL GIOCATORE X (riga)");
					winner = true;
					winnerX = true;
					break;
				}
			}
			else if(board[x][y] == "O") {
				k++;
				if(k == 3) {
					//System.out.println("VINCE IL GIOCATORE O (riga)");
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

	public boolean trisDiagonale() { //controllo che ci sia il "tris" in diagonale
		h = 0;
		k = 0;
		winner = false;
		winnerX = false;
		winnerO = false;

		/*
		 * Controllo che il tris avvenga così:
		 * X
		 *  X
		 *   X
		 */
		for (int x = 0; x < rows; x++) {
			int y = x;
			if(board[x][y] == "X") {
				h++;
				if(h == 3) {
					//System.out.println("VINCE IL GIOCATORE X (diagonale)");
					winner = true;
					winnerX = true;
					break;
				}
			}
			else if(board[x][y] == "O") {
				k++;
				if(k == 3) {
					//System.out.println("VINCE IL GIOCATORE O (diagonale)");
					winner = true;
					winnerO = true;
					break;
				}
			}
		}
		k = 0;
		h = 0;

		/*
		 * Ora controllo che avvenga dall'altra parte:
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
			//System.out.println("VINCE IL GIOCATORE X (diagonale contrario)");
			winnerX = true;
			winner = true;
		}

		if(k == 3) {
			//System.out.println("VINCE IL GIOCATORE O (diagonale contrario)");
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