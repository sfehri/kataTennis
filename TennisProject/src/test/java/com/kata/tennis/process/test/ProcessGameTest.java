package com.kata.tennis.process.test;

import static org.junit.Assert.assertEquals;

import java.util.stream.IntStream;

import org.junit.Before;
import org.junit.Test;

import com.kata.tennis.model.TennisGame;
import com.kata.tennis.model.TennisPlayer;
import com.kata.tennis.services.TennisService;
import com.kata.tennis.services.TennisServiceImpl;

public class ProcessGameTest {
	
	TennisService tennisService;
    TennisPlayer player1;
    TennisPlayer player2;
    TennisGame game;

    @Before
    public void beforeProcessTest() {
    	
    	tennisService = new TennisServiceImpl();
    	player1 = new TennisPlayer("player1");
    	player2 = new TennisPlayer("player2");
    	game = new TennisGame(player1, player2, false);
    }
    
    
    
	@Test
	public void gameNullScoreSetTest() {
		assertEquals ("0, 0",tennisService.getScore(game));
	}
	
	@Test
	public void gamePlayer1WinTest() {

		 IntStream.rangeClosed(1, 4).forEach((Integer) -> {
	            tennisService.winballSet(player1, game.getBreakRuleScore());
	        });
		//game.setPlayer1(player1); 
		assertEquals ("player1 win the set",tennisService.getScore(game));
		
	}
	
	@Test
	public void gameDeuceTest() {

		IntStream.rangeClosed(1, 4).forEach((Integer) -> {
			tennisService.winballSet(player1, game.getBreakRuleScore());
		});
		IntStream.rangeClosed(1, 4).forEach((Integer) -> {
			tennisService.winballSet(player2, game.getBreakRuleScore());
		});

		assertEquals("deuce", tennisService.getScore(game));

	}

	
	@Test
	public void gameAdvPlayer2Test() {

		IntStream.rangeClosed(1, 4).forEach((Integer) -> {
			tennisService.winballSet(player1, game.getBreakRuleScore());
		});
		IntStream.rangeClosed(1, 5).forEach((Integer) -> {
			tennisService.winballSet(player2, game.getBreakRuleScore());
		});

		assertEquals("advantage player2", tennisService.getScore(game));

	}
	
	@Test
	public void gameDeuceAfterAdvTest() {

		IntStream.rangeClosed(1, 5).forEach((Integer) -> {
			tennisService.winballSet(player1, game.getBreakRuleScore());
		});
		IntStream.rangeClosed(1, 5).forEach((Integer) -> {
			tennisService.winballSet(player2, game.getBreakRuleScore());
		});
		assertEquals("deuce", tennisService.getScore(game));

	}
	
	@Test
	public void gamePlayer1WonTheSetTest() {

		IntStream.rangeClosed(1, 4).forEach((Integer) -> {
			tennisService.winballSet(player1, game.getBreakRuleScore());
		});

		assertEquals("player1 win the set", tennisService.getScore(game));
	}
	
	@Test
	public void gamePlayer1WonTheGameTest() {
		String result = "";
		for (int i = 0; i < 6; i++) {
			IntStream.rangeClosed(1, 4).forEach((Integer) -> {
				tennisService.winballSet(player1, game.getBreakRuleScore());
			});
			result = tennisService.getScore(game);
			
			// 
		}
		assertEquals(6,  game.getPlayer1().getGameScore());
		assertEquals(0,  game.getPlayer2().getGameScore());
		assertEquals("player1 win the set and the match",  result);

	}
	
	@Test
	public void gamePlayer1WonTheTieBreakGameTest() {
		String result = "";
		for (int i = 0; i < 6; i++) {
			IntStream.rangeClosed(1, 4).forEach((Integer) -> {
				tennisService.winballSet(player1, game.getBreakRuleScore());
			});
			result = tennisService.getScore(game);
			IntStream.rangeClosed(1, 4).forEach((Integer) -> {
				tennisService.winballSet(player2, game.getBreakRuleScore());
			});
			result = tennisService.getScore(game);

		}

		IntStream.rangeClosed(1, 7).forEach((Integer) -> {
			tennisService.winballSet(player1, game.getBreakRuleScore());
		});
		result = tennisService.getScore(game);
		System.out.println(" result : " + result);

		assertEquals("player1 win the set and the match", result);

	}	
	


}
