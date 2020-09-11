//Name; Katie Munoz
//Date: 4/01/2020
//File: Discard 
import java.util.ArrayList;

  
import java.util.List;

public class Discard {
	
	List<Card> discardDeck = new ArrayList<Card>();

	public Discard() {} // Start with empty list and add from deck or player

	public void receiveDiscard(Card c)
	{
		discardDeck.add(0,c); // discardDeck receives cards and never take from discard
	}
}
