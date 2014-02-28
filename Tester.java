import java.util.*;

public class Tester {

	private static boolean debug = true;

	public static void main(String[] args) {
		Board b = new Board();
		int y2 = 0;
		int x2 = 0;
		boolean fatto = false;
		Random r = new Random();
		boolean continua = true;
		Scanner in = new Scanner(System.in);
		
		b.tic(0,0,"X"); //prima mossa giocatore

		System.out.println();
		System.out.println(b);
		System.out.println();

		while(continua) {
			if(Engine.puoPerdere()) {
				System.out.println("il PC puo' perdere, agisce di conseguenza ...");
				
				fatto = false;
				while(!fatto) {
					if(Engine.puoPerderePrimaColonna()) { //test puoPerdere()
						y2 = 0;
						x2 = (r.nextInt(3));
					}
					else if(Engine.puoPerdereSecondaColonna()) {
						y2 = 1;
						x2 = (r.nextInt(3));
					}
					else if(Engine.puoPerdereUltimaColonna()) {
						y2 = 2;
						x2 = (r.nextInt(3));
					}
					else if(Engine.puoPerderePrimaRiga()) {
						x2 = 0;
						y2 = (r.nextInt(3));
					}
					else if(Engine.puoPerdereSecondaRiga()) {
						x2 = 1;
						y2 = (r.nextInt(3));
					}
					else if(Engine.puoPerdereUltimaRiga()) {
						x2 = 2;
						y2 = (r.nextInt(3));
					}
					if(b.tic(x2,y2,"O"))
						fatto = true;
					else
						fatto = false;
				}
			}

			System.out.println();

			if(Engine.puoVincere()) {
				System.out.println("Il PC non rischia di perdere, ma puo' vincere, agisce di conseguenza ");
				fatto = false;
				while(!fatto) {
					if(Engine.puoVincerePrimaColonna()) { //test puoVincere()
						y2 = 0;
						x2 = (r.nextInt(3));
					}
					else if(Engine.puoVincereSecondaColonna()) {
						y2 = 1;
						x2 = (r.nextInt(3));
					}
					else if(Engine.puoVincereUltimaColonna()) {
						y2 = 2;
						x2 = (r.nextInt(3));
					}
					else if(Engine.puoVincerePrimaRiga()) {
						x2 = 0;
						y2 = (r.nextInt(3));
					}
					else if(Engine.puoVincereSecondaRiga()) {
						x2 = 1;
						y2 = (r.nextInt(3));
					}
					else if(Engine.puoVincereUltimaRiga()) {
						x2 = 2;
						y2 = (r.nextInt(3));
					}
					if(b.tic(x2,y2,"O"))
						fatto = true;
					else
						fatto = false;
				}
			}	

			System.out.println();
			if(!Engine.puoPerdere() && !Engine.puoVincere()) {
				System.out.println("Il PC non rischia di perdere ma non puo' neanche vincere, mette il tic a caso ");
				fatto = false;
				while(!fatto) {
					x2 = (r.nextInt(3)); //mossa casuale...
					y2 = (r.nextInt(3));
					if(b.tic(x2,y2,"O"))
						fatto = true;
					else
						fatto = false;
				}
			}

			System.out.println(b);
			System.out.println();
			System.out.println("Continuare? ");
			if(in.next().toUpperCase().equals("S"))
				continua = true;
			else
				continua = false;
		}
	}
}