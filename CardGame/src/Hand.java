import java.util.ArrayList;

public class Hand {
	
	public void drawCard (Card card)
	{
		hand.add(card);
	}
	
	
	@Override
	public String toString() {
		return "Hand [hand=" + hand + "]\n";
	}
	private ArrayList<Card> hand = new ArrayList<Card>();
	

}
