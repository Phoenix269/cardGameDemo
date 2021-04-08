//////////////////The java class used to do normal deck operations like creating, shuffling, ///////
///////////////////////////drawing the card, removing the card etc,.//////////////////////////

package org.entity;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;


public class Deck {
	
	List<Integer> mydeck = new ArrayList<Integer>(); 

	//Function to create the deck valued between 1 to 10
	public List<Integer> createDeck()
	{
		for(int i = 0; i<4 ; i++)
		{
			for(int j =0; j<10 ; j++)
			{
				mydeck.add(j+1);
			}
		}
		return mydeck;
	}
	
	//Function to shuffle the deck using Fischer-Yates shuffle
	public List<Integer> shuffledeck(List<Integer> ar) {
		List<Integer> shuffledDeck = new ArrayList<Integer>();
		shuffledDeck.addAll(ar);
		Random rnd = ThreadLocalRandom.current();
	    for (int i = shuffledDeck.size() - 1; i > 0; i--)
	    {
	      int index = rnd.nextInt(i + 1);
	      Collections.swap(shuffledDeck,index,i);
	    }
		return shuffledDeck;
	}
	
	//Function to draw the top card from the draw deck
	public int drawCard(List<Integer> drawDeck)
	{
		if (drawDeck.size() !=0)
		{
			return drawDeck.get(drawDeck.size()-1);
		}
		else {
			return 0;
		}
	}
	
	
	//Function to add an card to the deck
	public List<Integer> add2Deck(List<Integer> discardDeck, int card) {
		discardDeck.add(card);
		return discardDeck;
	}
	
	//Function to remove card from the deck after comparing 
	public List<Integer> removeCard(List<Integer> drawDeck) {
		drawDeck.remove(drawDeck.size()-1);
		return drawDeck;
	}

	//Function to fill and shuffle draw pile
	public List<Integer> fillDraw(List<Integer> discardDeck) {
		List<Integer> draw1 = new ArrayList<Integer>();
		for(int x= discardDeck.size()-1;x>=0;x--)
		{
			if(x>19)
			{
				discardDeck.remove(x);
			}
			//System.out.println(discardDeck);
		}
		draw1 = shuffledeck(discardDeck);
		return draw1;
	}

	//Function to delete the elements that are transfered to draw pile
	public List<Integer> reorgDiscard(List<Integer> ar) {
		
		for(int x= ar.size()-1;x>=0;x--)
		{
			if(x<=19)
			{
			ar.remove(x);
			}
		}
		return ar;
	}

}
