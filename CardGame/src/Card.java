
public class Card {
	
	public Card(CardValue value, CardSuit suit) {
		super();
		this.value = value;
		this.suit = suit;
	}
	public CardValue getValue() {
		return value;
	}
	public CardSuit getSuit() {
		return suit;
	}
	
	private CardValue value;
	private CardSuit suit;
	@Override
	public String toString() {
		return "Card [value=" + value + ", suit=" + suit + "]";
	}
	
}
