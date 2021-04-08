package org.test;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.entity.Deck;


class Task1TestCase {
	Deck mydeck = new Deck();
	List<Integer> newdeck = mydeck.createDeck();
	
	//Test case to test the deck creation
	@Test
	void testCreateDeck() {
		assertEquals(newdeck.size(),40,"There should be 40 cards in the new deck");
	}
	
	//Test case to test the deck is shuffled or not
	@Test
	void testShuffleDeck() {
		List<Integer> shuffledDeck = mydeck.shuffledeck(newdeck);
		boolean check = newdeck.equals(shuffledDeck);
		assertEquals(false, check, "Both are same"); //To pass the test the check variable value should be false as the shuffled and the normal deck won't be same
	}
	


}
