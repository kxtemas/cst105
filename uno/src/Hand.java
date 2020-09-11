// Name: Katie Munoz
//Date: 04/01/2020
//File: Hand Class
import java.util.ArrayList;
   
import java.util.List;

public class Hand {
	List<Card> handDeck = new ArrayList<Card>();

	public Hand() {}

	public List<Card> getHand() {return handDeck;}
	public void drawCard(Card c) 
	{
		handDeck.add(c);
	}
	
	public void discard(Card c)
	{
		handDeck.remove(c);
	}
	
	public int handSize() {
		return handDeck.size();
	}
	
	public List<Card> playableCard(Card c, String color) {
		List<Card> playableCards = new ArrayList<Card>();
		
		for(int i = 0; i < handDeck.size(); i++) 
		{
			// Color Matches
			if(handDeck.get(i).getColor().matches(c.getColor()) || 
					handDeck.get(i).getColor().matches(color)) 
			{
				playableCards.add(handDeck.get(i));
				
			} // Number matches or same special card
			else if(handDeck.get(i).getValue() == c.getValue()) 
			{
				playableCards.add(handDeck.get(i));
			} // Wild cards
			else if(handDeck.get(i).getValue() == 13 || handDeck.get(i).getValue() == 14) 
			{
				playableCards.add(handDeck.get(i));
			}
			
		}
		
		return playableCards;
	}
	
	// Defines the Card's color
	public String mostColor() { // Defaults to yellow
		int blue = 0;
		int red = 0;
		int green = 0;
		int yellow = 0;
		
		for(int i = 0; i < handDeck.size(); i++) {
			switch(handDeck.get(i).getColor()) {
				case "BLUE":
					blue++;
					break;
					
				case "RED":
					red++;
					break;
					
				case "GREEN":
					green++;
					break;
				
				case "YELLOW":
					yellow++;
					break;
				
				default:
					// Do nothing
					break;
			
			}
		}
		// For Wild Cards, counts which color the player has greater of and chooses that color
		if(blue > red && blue > green && blue > yellow) {
			return "BLUE";
		} else if(red > blue && red > green && red > yellow) {
			return "RED";
		} else if(green > blue && green > red && green > yellow) {
			return "GREEN";
		} else {
			return "YELLOW";
		}
	
	}
	
	public int handScore() {
		int score = 0;
		for(int i = 0; i < handDeck.size(); i++) {
			if(handDeck.get(i).getValue() >= 10) {
				switch(handDeck.get(i).getValue()) {
					case 10:
						score += 20;
						break;
						
					case 11:
						score += 20;
						break;
						
					case 12:
						score += 20;
						break;
						
					case 13:
						score += 50;
						break;
						
					case 14:
						score += 50;
						break; 	
				}
			} else {
				score += handDeck.get(i).getValue();
			}
		} 
		return score;
	}
}
