package org.test;

import static org.junit.jupiter.api.Assertions.*;

import org.entity.MainPlay;
import org.junit.jupiter.api.Test;

class Task3TestCase {

	//Test case to test the comparison between the draw cards
	@Test
	void compareTest() {
		MainPlay.getPlayer1Draw().add(2);// Adding the elements to draw pile of player1
		MainPlay.getPlayer1Draw().add(4);
		MainPlay.getPlayer1Draw().add(3);
		MainPlay.getPlayer2Draw().add(4);// Adding the elements to draw pile of player2
		MainPlay.getPlayer2Draw().add(2);
		MainPlay.getPlayer2Draw().add(3);
		
		MainPlay.compareCard();
		MainPlay.compareCard();
		MainPlay.compareCard();
		System.out.println("The discarded pile of player1 after comparing: "+MainPlay.getPlayer1Discard());
		assertEquals(MainPlay.getPlayer1Discard().size(),4,"The test failed as the discarded pile of player 1 did not updated as expected due to the win with large valued card");
		//Here after the function compareCard the cards will be compared and if the card of player1 is higher then his discarded pile will be added with 2cards and same applies for player2 also.
		//But if the cards of both players are of same value then the two cards should be added to the winner of next round and in this test case the first round draw cards are of same value
		// in the second round player1 wins hence discarded pile of player1 will have 4 elements and if the size of discard pile is equal to 4 then the testcase passes.
	}
		
}
