import java.util.ArrayList;
import java.util.Collections;



public class Deck {
	
	public Deck()
	{
		super();
		deck  = new ArrayList<Card>();
	}
// multiplies the value by the suit so we can get the card type such as  "7 heart"
	public void populate()
	{
		for (CardSuit suit: CardSuit.values()) {
			for (CardValue value: CardValue.values()) {
				
				deck.add(new Card(value, suit));
			}
			
		}
			
	}
	// shuffles the deck
	public void shuffle()
	{
		Collections.shuffle(deck);
	}
	// gets rid of a card from deck once it was dealed
	public Card dealCard()
	{
		Card card;
		card = deck.remove(deck.size() - 1);
		return card;
	}
	
	@Override
	public String toString() {
		return "Deck [deck=" + deck + "]";
	}

	private ArrayList<Card> deck;
}
