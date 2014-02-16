public class Board {

	//CAMPI
	private String[][] board;
	private static final int rows = 3;
  	private static final int columns = 3;

	//COSTRUTTORE
	//costruisco il campo (matrice 3*3) vuoto
	public Board() {
		board = new String[rows][columns];
		for(int x = 0; x < rows; x++) {
			for(int y = 0; y < columns; y++) {
				board[x][y] = "";
			}
		}
	}

	//METODI
	//stampo lo stato della matrice
	public String toString() {
		StringBuilder s = new StringBuilder();
		for(int x = 0; x < rows; x++) {
			for(int y = 0; y<columns; y++) {
				if (board[x][y] == "")
					s.append(" ");
				else
					s.append(board[x][y]);
				if (y < columns -1)
					s.append("|");
			}
			if(x < rows -1) {
				s.append("\n");
				s.append("=====");
				s.append("\n");
			}


		}
		return s.toString();
	}


}