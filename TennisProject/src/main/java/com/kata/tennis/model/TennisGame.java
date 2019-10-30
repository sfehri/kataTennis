package com.kata.tennis.model;

/**
 * @author fehri samar
 *
 */
public class TennisGame {
	
	/**
	 * 
	 */
	private TennisPlayer player1;
	/**
	 * 
	 */
	private TennisPlayer player2;
	/**
	 * 
	 */
	private boolean breakRuleScore;
	/**
	 * @return
	 */
	
	/**
	 * @param player1
	 * @param player2
	 * @param breakRuleScore
	 */
	public TennisGame(TennisPlayer player1, TennisPlayer player2, boolean breakRuleScore) {
		super();
		this.player1 = player1;
		this.player2 = player2;
		this.breakRuleScore = breakRuleScore;
	}
	
	
	public TennisPlayer getPlayer1() {
		return player1;
	}

	/**
	 * @param player1
	 */
	public void setPlayer1(TennisPlayer player1) {
		this.player1 = player1;
	}
	/**
	 * @return
	 */
	public TennisPlayer getPlayer2() {
		return player2;
	}
	/**
	 * @param player2
	 */
	public void setPlayer2(TennisPlayer player2) {
		this.player2 = player2;
	}
	/**
	 * @return
	 */
	public boolean getBreakRuleScore() {
		return breakRuleScore;
	}
	/**
	 * @param breakRuleScore
	 */
	public void setBreakRuleScore(boolean breakRuleScore) {
		this.breakRuleScore = breakRuleScore;
	}
	
	
	

}
