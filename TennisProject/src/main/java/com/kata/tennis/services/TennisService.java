package com.kata.tennis.services;

import com.kata.tennis.model.TennisGame;
import com.kata.tennis.model.TennisPlayer;

/**
 * @author fehri samar
 *
 */
public interface TennisService {
	
	/**
	 * @param player 
	 */
	public void winballSet(TennisPlayer player, boolean breakRule);
	

	/**
	 * @param game
	 * @return
	 */
	public String getScore(TennisGame game);

}
