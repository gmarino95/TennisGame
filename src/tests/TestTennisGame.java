package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

import tennisScore.TennisGame;
import tennisScore.TennisGameException;

public class TestTennisGame {

	TennisGame game;
	
	@Before
	public void setUp() {
		game = new TennisGame();
	}
	
	/*@Test
	public void testStartGame() {	
		//Act
		String score = game.getScore();
		
		//Assert
		assertEquals(, score);
	}*/
	
	@Test
	public void testTennisGame_EahcPlayerWin4Points_Score_Deuce() throws TennisGameException {

		//Arrange
		TennisGame game = new TennisGame();

		//Act
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();

		game.player2Scored();
		game.player2Scored();
		game.player2Scored();

		game.player1Scored();
		game.player2Scored();

		String score = game.getScore() ;

		// Assert
		assertEquals("Tie score incorrect", "deuce", score);		
	}

	@Test (expected = TennisGameException.class)
	public void testTennisGame_Player1WinsPointAfterGameEnded_ResultsException() throws TennisGameException {
		//Act
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		// This statement should cause an exception
		game.player1Scored();		
	}
}