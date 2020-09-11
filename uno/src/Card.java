//Name: Katie Munoz
//Date: 04/01/2020
//File: Card Class
public class Card 
{
	int value = -1;
	String color = "none";
	
	public Card() {}
	
	public Card(int pValue, String pColor)
	{
		value = pValue;
		color = pColor;
	}

	public int getValue() {return value;}
	// public void setValue(int pValue) {value = pValue;}
	
	public String getColor() {return color;}
	// public void setColor(String pColor) {color = pColor;}
	
	// Prints the card's color and value
	public String toString() 
	{
		return "[" + color.toString() + ": "+ value + "]";
	}
	
	public boolean isMatch(Card c)
	{
		boolean match = false;
		if(this.value == c.value || this.color == c.color)
		{
			match = true;
		}
		return match;
	}
	
}