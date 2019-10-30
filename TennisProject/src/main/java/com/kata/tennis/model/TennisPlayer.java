package com.kata.tennis.model;

import java.util.Arrays;
import java.util.List;

/**
 * @author fehri samar
 *
 */
public class TennisPlayer {

	public static final List<Integer> scoreSteValues = Arrays.asList(0, 15, 30, 40);

	/**
	 * le nom du joueur
	 */
	private String name;

	/**
	 * le score du jeu
	 */
	private int gameScore;

	/**
	 * le score de la partie
	 */
	private int setScore;
	
	
	/**
	 * le score de la partie break rule
	 */
	private int breakRuleScore;

	/**
	 * @param name initialiser le nom du joeur
	 */
	public TennisPlayer(String name) {
		this.name = name;
	}

	/**
	 * @return le nom du joueur
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return le score du jeu
	 */
	public int getGameScore() {
		return gameScore;
	}

	/**
	 * @param gameScore
	 *            gameScore
	 */
	public void setGameScore(int gameScore) {
		this.gameScore = gameScore;
	}

	/**
	 * @return le score de la partie
	 */
	public int getSetScore() {
		return setScore;
	}

	/**
	 * @param setScore
	 *            setScore
	 */
	public void setSetScore(int setScore) {
		this.setScore = setScore;
	}

	/**
	 * @return la valeur réelle du score de la partie
	 */
	public Integer getScoreSetValue() {
		return scoreSteValues.get(setScore);
	}

	/**
	 * @return le score de la partie break rule
	 */
	public int getBreakRuleScore() {
		return breakRuleScore;
	}

	/**
	 * @param breakRuleScore breakRuleScore
	 */
	public void setBreakRuleScore(int breakRuleScore) {
		this.breakRuleScore = breakRuleScore;
	}
	
	

}
