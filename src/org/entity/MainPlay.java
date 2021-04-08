//////////////The main file which controls the game play///////////////////

package org.entity;

import java.util.ArrayList;
import java.util.List;

public class MainPlay {

	static int next1=0,next2=0;
	static Deck deck = new Deck();
	private static List<Integer> player1Draw =new ArrayList<Integer>();
	private static List<Integer> player2Draw =new ArrayList<Integer>();
	private static List<Integer> player1Discard=new ArrayList<Integer>();
	private static List<Integer> player2Discard = new ArrayList<Integer>();
	
	//Function to compare the drawn cards
	public static void compareCard() {
	
		int card1 = deck.drawCard(getPlayer1Draw());// Player1 draws card
		System.out.println("Player 1 draw card (Draw pile: "+getPlayer1Draw().size()+" Discard pile: "+getPlayer1Discard().size()+") :"+card1);
    	
		int card2 = deck.drawCard(getPlayer2Draw()); // Player2 draws card
		System.out.println("Player 2 draw card (Draw pile: "+getPlayer2Draw().size()+" Discard pile: "+getPlayer2Discard().size()+") :"+card2);
		
		if(card1>card2)
    	{
    		setPlayer1Discard(deck.add2Deck(getPlayer1Discard(),card1));
    		setPlayer1Discard(deck.add2Deck(getPlayer1Discard(),card2));
    		setPlayer1Draw(deck.removeCard(getPlayer1Draw()));
    		setPlayer2Draw(deck.removeCard(getPlayer2Draw()));
    	
    		if(next1!=0 && next2!=0)
    		{
    			setPlayer1Discard(deck.add2Deck(getPlayer1Discard(),next1));
    			setPlayer1Discard(deck.add2Deck(getPlayer1Discard(),next2));
    			next1=next2=0;
	    		
    		}
    		System.out.println("Player 1 wins this round!!");
    	}
    	else if(card1==card2) {
    		next1=card1;
    		next2 =card2;
    		setPlayer1Draw(deck.removeCard(getPlayer1Draw()));
    		setPlayer2Draw(deck.removeCard(getPlayer2Draw()));
    		System.out.println("No winner in this round!!");
    		}
    	else {
    		setPlayer2Discard(deck.add2Deck(getPlayer2Discard(),card1));
    		setPlayer2Discard(deck.add2Deck(getPlayer2Discard(),card2));
    		setPlayer1Draw(deck.removeCard(getPlayer1Draw()));
    		setPlayer2Draw(deck.removeCard(getPlayer2Draw()));
    		
    		if(next1!=0 && next2!=0)
    		{
    			setPlayer2Discard(deck.add2Deck(getPlayer2Discard(),next1));
    			setPlayer2Discard(deck.add2Deck(getPlayer2Discard(),next2));
    			next1=next2=0;
    		}
    		System.out.println("Player 2 wins this round!!");
    	}	    	
	}
	
	//Function to play the turns
	public static void playTurn() {
		
	    while( true)
	    {
	    	if(getPlayer1Draw().size()!=0)
	    	{
	    		if(getPlayer2Draw().size()!=0){
	    	    	compareCard();
	    		}
	    		else {
	    			if(getPlayer2Discard().size()!=0) {	  
	    				List<Integer> player2Dummy = new ArrayList<Integer>();
						player2Dummy .addAll(getPlayer2Discard());
		    			setPlayer2Draw(deck.fillDraw(player2Dummy));
		    			setPlayer2Discard(deck.reorgDiscard(getPlayer2Discard()));
		    			}
	    			}
	    		}
	    	else {
	    		if(getPlayer1Discard().size()!=0)
	    			{
    				List<Integer> player1Dummy = new ArrayList<Integer>();
    				player1Dummy.addAll(getPlayer1Discard());
	    			setPlayer1Draw(deck.fillDraw(player1Dummy));
	    			setPlayer1Discard(deck.reorgDiscard(getPlayer1Discard()));
	    			}
	    		}
	    	
	    	if(getPlayer1Draw().size()==0 && getPlayer1Discard().size()==0 )
	    	{
	    		System.out.println("PLayer 2 Wins the game!");
	    		break;
	    	}
	    	else if(getPlayer2Draw().size()==0 && getPlayer2Discard().size()==0) {
	    		System.out.println("PLayer 1 Wins the game!");
	    		break;
	    	}
	    	else if((getPlayer1Draw().size()==0 && getPlayer1Discard().size()==0)||(getPlayer2Draw().size()==0 && getPlayer2Discard().size()==0)) {
	    		System.out.println("Match was a tie");
	    		break;
	    	}
	    	else {
	    		continue;
	    	}
	    	    
	    }
	}
	
	
	private static void createPlayers() {
		
		List<Integer> newdeck =	deck.createDeck();
		List<Integer> dum = deck.shuffledeck(newdeck);

	    for (int i =0; i< dum.size()-1; i++) { 		      
	    		getPlayer1Draw().add(dum.get(i));
	    		getPlayer2Draw().add(dum.get(i+1));
	    		i++;
	    }
		
	}
	
	public static void main(String[] args) {
		

		createPlayers();
	    
	    playTurn();
	}


	public static List<Integer> getPlayer1Discard() {
		return player1Discard;
	}


	public static void setPlayer1Discard(List<Integer> player1Discard) {
		MainPlay.player1Discard = player1Discard;
	}


	public static List<Integer> getPlayer2Discard() {
		return player2Discard;
	}


	public static void setPlayer2Discard(List<Integer> player2Discard) {
		MainPlay.player2Discard = player2Discard;
	}


	public static List<Integer> getPlayer1Draw() {
		return player1Draw;
	}


	public static void setPlayer1Draw(List<Integer> player1Draw) {
		MainPlay.player1Draw = player1Draw;
	}


	public static List<Integer> getPlayer2Draw() {
		return player2Draw;
	}


	public static void setPlayer2Draw(List<Integer> player2Draw) {
		MainPlay.player2Draw = player2Draw;
	}
	
}
