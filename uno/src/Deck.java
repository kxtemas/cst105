//Name: Katie Munoz
//Date: 04/01/2020
//File: Deck


import java.util.ArrayList;     
import java.util.List;

public class Deck 
{
	int unoCount = 108;
	Card topCard; 
	String topColor; // For tracking wild cards
	List<Card> deckOfCards = new ArrayList<Card>(unoCount);
	List<Card> discardCards = new ArrayList<Card>(unoCount);
	
	public Deck() 
	{	
		int[] arrayValues = {0,1,1,2,2,3,3,4,4,5,5,6,6,7,7,8,8,9,9,10,10,11,11,12,12};

		String[] arrayColors = {"RED","BLUE","GREEN","YELLOW","WILD"};
		int value;
		int color;
		
		for(int deckIndex = 0; deckIndex < unoCount; deckIndex++)
		{
			if(deckIndex < 100)
			{
				value = deckIndex % arrayValues.length;
				color = (deckIndex / arrayValues.length);
				
				Card deckCard = new Card(arrayValues[value], arrayColors[color]);
				deckOfCards.add(deckCard);
			}
			else if(deckIndex < 104)
			{
				value = 13;			// 13 = WILD
				color = (deckIndex / arrayValues.length);
				
				Card deckCard = new Card(value, arrayColors[color]);
				deckOfCards.add(deckCard);
			}
			else
			{
				value = 14;			// 14 = WILD DRAW 4
				color = (deckIndex / arrayValues.length);
				
				Card deckCard = new Card(value, arrayColors[color]);
				deckOfCards.add(deckCard);
			}
			
		}
	}
	
	
		public List<Card> getDeck() {return deckOfCards;}
		
		public void shuffle()
		{
			for(int deckIndex = 0; deckIndex < deckOfCards.size(); deckIndex++)
			{
				int index1 = (int)(Math.random()*deckOfCards.size());
				Card card2 = deckOfCards.get(index1);
				Card card1 = deckOfCards.get(deckIndex);
				deckOfCards.set(index1, card1);
				deckOfCards.set(deckIndex, card2);
			}
		}

		public Card deal()
		{
			if(deckOfCards.size() == 0) {
				for(int i = 0; i < discardCards.size(); i++) {
					deckOfCards.add(discardCards.get(i));
					discardCards.remove(i);
				}
				
				shuffle();
				
			}
			
			Card card1 = deckOfCards.get(0);
			deckOfCards.remove(0);
			return card1;
		}
		
		public void playCard(Card card) {
			topCard = card;
			topColor = card.getColor();
			discardCards.add(card);
		}
		
		public void playCard(Card card, String color) {
			topCard = card;
			topColor = color;
			discardCards.add(card);
			
		}
		
		public String getTopColor() {
			return topColor;
		}
		
		public Card getTopCard() {
			return topCard;
		}
}
