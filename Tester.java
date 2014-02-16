public class Tester {

	private static boolean debug = true;

	public static void main(String[] args) {
		Board b = new Board();
		b.tic(0,0,"X");

		b.getWinner();

		if(debug) {System.out.println(b);}

		b.tic(1,1,"X");

		b.getWinner();

		if(debug) {System.out.println(); System.out.println(b);}

		b.tic(0,1,"X");

		b.getWinner();

		if(debug) {System.out.println(); System.out.println(b);}

		b.tic(0,0,"O");

		b.getWinner();

		if(debug) {System.out.println(); System.out.println(b);}

		b.tic(0,2, "O");

		b.getWinner();

		if(debug) {System.out.println(); System.out.println(b);}

		b.tic(2,2, "X");

		b.getWinner();

		if(debug) {System.out.println(); System.out.println(b);}
	}

}