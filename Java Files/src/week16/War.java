package week16;

import java.util.LinkedList;
import java.util.Random;


public class War {

	public static void main(String[] args) {
		LinkedList<Integer> p1deck = new LinkedList<Integer> ();
		LinkedList<Integer> p2deck = new LinkedList<Integer> ();

		LinkedList<Integer> dealDeck = new LinkedList<Integer> ();		
		for (int i = 2; i < 14; i ++) {
			dealDeck.add(i); dealDeck.add(i); dealDeck.add(i); dealDeck.add(i);
		}

		Random rand = new Random();
		while (! dealDeck.isEmpty()) {
			int dealIndex = rand.nextInt(dealDeck.size());
			p1deck.add(dealDeck.get(dealIndex));

			dealDeck.remove(dealIndex);

			dealIndex = rand.nextInt(dealDeck.size());
			p2deck.add(dealDeck.get(dealIndex));

			dealDeck.remove(dealIndex);
		}

		if (p1deck.equals(p2deck)) {
			System.out.println("Tie");
		}

		else {		
			while (! p1deck.isEmpty() && ! p2deck.isEmpty()) {
				int p1card = p1deck.pop();
				int p2card = p2deck.pop();

				if (p1card > p2card) {
					p1deck.add(p2card);
					p1deck.add(p1card);
				}

				else if (p2card > p1card) {
					p2deck.add(p1card);
					p2deck.add(p2card);
				}

				else {
					p1deck.add(p1card);
					p2deck.add(p2card);
				}
				
				System.out.println("Player 1's card: " + p1card);
				System.out.println("Player 2's card: " + p2card);
				System.out.println("Player 1 has " + p1deck.size() + " cards");
				System.out.println("Player 2 has " + p2deck.size() + " cards");
				System.out.println();
			}
		}
		
		if (p1deck.isEmpty()) {
			System.out.println("Player 2 wins");
		}
		
		else {
			System.out.println("Player 1 wins");
		}
	}

}
