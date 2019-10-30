package com.kata.tennis.services;

import com.kata.tennis.model.TennisGame;
import com.kata.tennis.model.TennisPlayer;

public class TennisServiceImpl implements TennisService {

	@Override
	public void winballSet(TennisPlayer player, boolean breakRule) {
		if (!breakRule) {
			player.setSetScore(player.getSetScore() + 1);
		} else {
			player.setBreakRuleScore(player.getBreakRuleScore() + 1);
		}

	}

	@Override
	public String getScore(TennisGame game) {
		TennisPlayer player1 = game.getPlayer1();
		TennisPlayer player2 = game.getPlayer2();
		if (!game.getBreakRuleScore()) {
			if (player1.getSetScore() > 3 || player2.getSetScore() > 3) {
				if (Math.abs(player2.getSetScore() - player1.getSetScore()) >= 2) {

					TennisPlayer wonPlayer = getWonPlayer(player1, player2);
					String labelScoreGame = "";

					winballGame(wonPlayer.getName().equals(player1.getName()) ? player1 : player2);

					if (player1.getGameScore() >= 6 || player2.getGameScore() >= 6) {
						if (Math.abs(player2.getGameScore() - player1.getGameScore()) >= 2) {
							labelScoreGame = " and the match";

						} else if (player1.getGameScore() == player2.getGameScore()) {
							// on est dans le cas de break rule
							game.setBreakRuleScore(true);
						}

					}

					String result = getWonPlayer(player1, player2).getName() + " win the set" + labelScoreGame;
					player1.setSetScore(0);
					player2.setSetScore(0);
					return result;
				} else if (player1.getSetScore() == player2.getSetScore()) {
					return "deuce";
				} else {
					return "advantage " + getWonPlayer(player1, player2).getName();
				}
			} else {
				return player1.getScoreSetValue() + ", " + player2.getScoreSetValue();
			}
		} else {
			System.out.println("the tie break rule is activated !");
			if (player1.getBreakRuleScore() >= 7 || player2.getBreakRuleScore() >= 7) {
				TennisPlayer wonPlayerBreakRule = getWonPlayerBreakRule(player1, player2);
				return wonPlayerBreakRule.getName() + " win the set and the match";

			} else {
				return "Tie Break Score :" + player1.getBreakRuleScore() + ", " + player2.getBreakRuleScore();

			}

		}

	}

	private TennisPlayer getWonPlayer(TennisPlayer player1, TennisPlayer player2) {
		return (player1.getSetScore() > player2.getSetScore()) ? player1 : player2;
	}

	private TennisPlayer getWonPlayerBreakRule(TennisPlayer player1, TennisPlayer player2) {
		return (player1.getBreakRuleScore() > player2.getBreakRuleScore()) ? player1 : player2;
	}

	private void winballGame(TennisPlayer player) {
		player.setGameScore(player.getGameScore() + 1);

	}

}
