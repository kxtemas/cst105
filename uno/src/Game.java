//Name: Katie Munoz
//Date: 04/02/2020
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {
	public void Play() {
		
			// Create Deck
			Deck playDeck = new Deck();
			playDeck.shuffle();
				
				
			int NumOfPlayers = 4;
			Hand[] playerHands = new Hand[NumOfPlayers];
			int[] playerScores = new int[NumOfPlayers];
			for(int p = 0; p < NumOfPlayers; p++) 
			{
			    // Create hand for player p
				// Hand hand = new Hand(); // Setup blank hand and add to list of players
				playerHands[p] = new Hand();
				playerScores[p] = 0;
			}
			
			// Set up initial hands – each player gets 7 cards
			
			int NumOfCards = 7;
			for(int c = 0; c < NumOfCards; c++)
			    for(int p = 0; p < NumOfPlayers; p++)
			    {
			    	// Deal a card to player p
			    	playerHands[p].drawCard(playDeck.deal());
			    }
			
			    for(int p = 0; p < NumOfPlayers; p++)
			    {
			    	System.out.print("Player "+String.valueOf(p)+": ");
			    	// Show hand of player p
			    	for(Card c : playerHands[p].getHand())
			    	{
			    		System.out.print(String.valueOf("[" + c.getColor()) + " " + c.getValue() + "]");
			    	}
			    	System.out.println(); 
			    }
			
			// Setup Top Card for UNO game
			playDeck.playCard(playDeck.deal());
			
			System.out.print("Top Card is " + "[" + String.valueOf(playDeck.getTopCard().getColor()) + " "+ playDeck.getTopCard().getValue() + "]");
			System.out.println(); 
			
			// Game	
			int player = 0;
			int dir = 1; // Keeps track of direction for reverse card
			List<Card> playableCards;
			Random rng = new Random();
			int randomCard;
			int won = 0;
			Card playCard;
			Scanner scan = new Scanner(System.in);
			while(won == 0) {
				if(dir == 1) {
					
					if(player < 0) {	
						player = 4 + player;
					} else if(player > 3 ) {
						player = player - 4;
					} 
						
					for(int p = player; p < 4; p++) {
						System.out.print("Player " + p + " turn, Score: " + playerScores[p] + "\n");
						// Determine cards that can be played
						playableCards = playerHands[p].playableCard(playDeck.getTopCard(), playDeck.getTopColor());
						
						if(playableCards.size() == 0) {
							System.out.print("Player " + p + " couldn't play a card, drawing...\nPlayer " + p + "'s hand:");
							playerHands[p].drawCard(playDeck.deal());
							for(Card c : playerHands[p].getHand()) {
					    		System.out.print(c.toString());
					    	}
							System.out.println();
							continue;
						}
						
						// Decide which card to play
						randomCard = rng.nextInt(playableCards.size());
						
						// Play and discard card from hand
						playCard = playableCards.get(randomCard);
						playerHands[p].discard(playCard);
						
						System.out.print("Player " + p + " played " + playCard.toString() + "\nPlayer " + p +"'s hand:");
						for(Card c : playerHands[p].getHand()) {
				    		System.out.print(c.toString());
				    	}
						System.out.println();
						if(playerHands[p].handSize() == 0) {
							System.out.print("Player " + p + " Wins!\n");
							won = 1;
							break;
						}
						
						// If special card determine effect
						if(playCard.getValue() >= 10) {
							
							switch(playCard.getValue()) {
								case 10: // Skip card 
									playDeck.playCard(playCard);
									p = p +  dir;
									break;
									
								case 11:  // Draw 2
									playDeck.playCard(playCard);
									p = p + dir; // Drawing 2 skips turn
									playerHands[Math.abs((p + dir) % 4)].drawCard(playDeck.deal());
									playerHands[Math.abs((p + dir) % 4)].drawCard(playDeck.deal());
									break;
									
								case 12: // Reverse
									dir = dir * -1;
									break;
								
								case 13: // Wild
									playDeck.playCard(playCard, playerHands[p].mostColor());
									System.out.print("Player " + p + " changed color to " + playerHands[p].mostColor() + "\n");
									p = p++;
									break;
								
								case 14: // Wild draw 4
									playDeck.playCard(playCard, playerHands[p].mostColor());
									playerHands[Math.abs((p + dir) % 4)].drawCard(playDeck.deal());
									playerHands[Math.abs((p + dir) % 4)].drawCard(playDeck.deal());
									playerHands[Math.abs((p + dir) % 4)].drawCard(playDeck.deal());
									playerHands[Math.abs((p + dir) % 4)].drawCard(playDeck.deal());
									System.out.print("Player " + p + " changed color to " + playerHands[p].mostColor() + "\n");
									p = p + dir; // Drawing 4 skips turn
									break;
							}
							
						} else {
							playDeck.playCard(playCard);
						}
						
						if(p == 3) {
							player = 0;
						} else {
							player = p;
						}
						
						
						if(dir == -1) { 
							player--;
							break;
						}
						
					}
				} else {
					if(player < 0) {	
						player = 4 + player;
					} else if(player > 3 ) {
						player = player - 4;
					}
					
					
					for(int p = player; p >= 0; p--) {
						System.out.print("Player " + p + " turn, Score: " + playerScores[p] + "\n");
						
						// Determine cards that can be played
						playableCards = playerHands[p].playableCard(playDeck.getTopCard(), playDeck.getTopColor());
						
						if(playableCards.size() == 0) {
							System.out.print("Player " + p + " couldn't play a card, drawing...\nPlayer " + p + "'s hand:");
							playerHands[p].drawCard(playDeck.deal());
							for(Card c : playerHands[p].getHand()) {
					    		System.out.print(c.toString());
					    	}
							System.out.println();
							continue;
						}
						
						// Decide which card to play
						randomCard = rng.nextInt(playableCards.size());
						
						// Play and discard card from hand
						playCard = playableCards.get(randomCard);
						playerHands[p].discard(playCard);
						
						System.out.print("Player " + p + " played " + playCard.toString() + "\nPlayer " + p +"'s hand:");
						for(Card c : playerHands[p].getHand()) {
				    		System.out.print(c.toString());
				    	}
						System.out.println();
						if(playerHands[p].handSize() == 0) {
							System.out.print("Player " + p + " Wins!\n");
							won = 1;
							for(int i = 0; i < 4; i++) {
								playerScores[p] += playerHands[i].handScore();
							}
							break;
						}
					
					// If special card determine effect
					if(playCard.getValue() >= 10) {
						
						switch(playCard.getValue()) {
							case 10: // Skip card 
								p = p +  dir;
								break;
								
							case 11:  // Draw 2
								playDeck.playCard(playCard);
								playerHands[Math.abs((p + dir) % 4)].drawCard(playDeck.deal());
								playerHands[Math.abs((p + dir) % 4)].drawCard(playDeck.deal());
								p = p + dir; // Drawing 2 skips turn
								break;
								
							case 12: // Reverse
								playDeck.playCard(playCard);
								dir = dir * -1;
								break;
							
							case 13: // Wild
								playDeck.playCard(playCard, playerHands[p].mostColor());
								System.out.print("Player " + p + " changed color to " + playerHands[p].mostColor() + "\n");
								p = p++;
								break;
							
							case 14: // Wild draw 4
								playDeck.playCard(playCard, playerHands[p].mostColor());
								playerHands[Math.abs((p + dir) % 4)].drawCard(playDeck.deal());
								playerHands[Math.abs((p + dir) % 4)].drawCard(playDeck.deal());
								playerHands[Math.abs((p + dir) % 4)].drawCard(playDeck.deal());
								playerHands[Math.abs((p + dir) % 4)].drawCard(playDeck.deal());
								System.out.print("Player " + p + " changed color to " + playerHands[p].mostColor() + "\n");
								p = p + dir; // Drawing 4 skips turn
								break;
						}
						
					}
					else {
						playDeck.playCard(playCard);
						}
						
						if(p == 0) {
							player = 3;
						} else {
							player = p;
						}
						
						if(dir == 1) { 
							player++;
							break;						}
						
				}
			}
				
						
				if(won == 1) {
					int scoreCheck = 0;
					for(int i = 0; i < 4; i++) {
						if(playerScores[i] > 500) {
							scoreCheck = 1;
							player = i;
							break;
						}
					}
					if(scoreCheck == 1) {
						System.out.print("Player " + player + " wins! Score: " + playerScores[player] + "\n");
					} else {
		won = 0;

		playDeck = new Deck();
	playDeck.shuffle();
	
	for(int c = 0; c < NumOfCards; c++)
	    for(int i = 0; i < NumOfPlayers; i++)
	    {
	    	// Deal a card to player p
	   	playerHands[i].drawCard(playDeck.deal());
	    }
	
	  for(int i = 0; i < NumOfPlayers; i++)
	    {
	    	System.out.print("Player "+String.valueOf(i)+": ");
	    	// Show hand of player p
	   	for(Card c : playerHands[i].getHand())
	    	{
	    		System.out.print(String.valueOf("[" + c.getColor()) + " " + c.getValue() + "]");
	    	}
	   	System.out.println(); 
	    }
	
	// Setup Top Card for UNO game
		playDeck.playCard(playDeck.deal());
		
		System.out.print("Top Card is " + "[" + String.valueOf(playDeck.getTopCard().getColor()) + " "+ playDeck.getTopCard().getValue() + "]");
		System.out.println(); 
		
		// Game	
	player = 0;
		dir = 1; // Keeps track of direction for reverse card
		continue;
	}
			
					
					System.out.print("Do you want to play again? [Y/N]\n");
					String result = scan.next();
					
					
					if(result.matches("Y")) {
						won = 0;
						
						playDeck = new Deck();
						playDeck.shuffle();
						
						for(int c = 0; c < NumOfCards; c++)
						    for(int i = 0; i < NumOfPlayers; i++)
						    {
						    	// Deal a card to player p
						    	playerHands[i].drawCard(playDeck.deal());
						    }
						
						    for(int i = 0; i < NumOfPlayers; i++)
						    {
						    	System.out.print("Player "+String.valueOf(i)+": ");
						    	// Show hand of player p
						    	for(Card c : playerHands[i].getHand())
						    	{
						    		System.out.print(String.valueOf("[" + c.getColor()) + " " + c.getValue() + "]");
						    	}
						    	System.out.println(); 
						    	playerScores[i] = 0;
						    }
						
						// Setup Top Card for UNO game
						playDeck.playCard(playDeck.deal());
						
						System.out.print("Top Card is " + "[" + String.valueOf(playDeck.getTopCard().getColor()) + " "+ playDeck.getTopCard().getValue() + "]");
						System.out.println(); 
						
						// Game	
						player = 0;
						dir = 1; // Keeps track of direction for reverse card
					}
				}
			}
				
	
			scan.close();
			System.out.print("Game ended\n");
	}	
	}
			


	

