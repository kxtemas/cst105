import java.util.ArrayList;

public class Game {
	public void Play()
	{
		Deck deck = new Deck();
		deck.populate();
		System.out.println(deck);
		deck.shuffle();
		System.out.println(deck);
		ArrayList<Hand> hands = new ArrayList<Hand>();
		hands.add(new Hand());
		hands.add(new Hand());
		hands.add(new Hand());
		hands.add(new Hand());
		
		for (int i =0; i < 7; i ++)
		{
			for (Hand hand : hands)
			{
				hand.drawCard(deck.dealCard());
			}
		}
				System.out.println(hands);
			
		}
		
	}


