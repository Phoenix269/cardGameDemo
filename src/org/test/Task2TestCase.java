package org.test;

import org.entity.Deck;
import org.entity.MainPlay;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class Task2TestCase {

	
	// Test case to test when the draw pile is empty the cards in discard pile is transferred to draw pile or not
	@Test
	void fillDrawTest() {
		MainPlay.getPlayer1Discard().add(2); //Adding the elements to discarded pile and the draw pile does not contain any elements as of now
		MainPlay.getPlayer1Discard().add(4);
		MainPlay.getPlayer2Discard().add(1);
		MainPlay.getPlayer2Discard().add(2);
		MainPlay.playTurn(); // Calling the function where the process of filling draw pile happens
		System.out.println("The discarded pile of player1 after comparing: "+MainPlay.getPlayer1Discard());
		assertEquals(MainPlay.getPlayer1Discard().size(),4,"The test failed as the draw pile cannot be updated");
		//After the playTurn function the the draw pile of player1 and player 2 gets loaded and the comparison happens and as we can see the player1 cards are hight valued 
		// in both the turns hence his discarded pile should be having 4 elements in the end to pass the test
	}

}
