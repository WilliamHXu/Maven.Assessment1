package com.zipcodewilmington.assessment1.part1;

/**
 * Created by leon on 2/16/18.
 */
public class RockPaperSissorsEvaluator {
    protected static final String ROCK = "rock";
    protected static final String PAPER = "paper";
    protected static final String SCISSOR = "scissor";

    /**
     * @param handSign a string representative of a hand sign
     * @return the respective winning move
     */
    public String getWinningMove(String handSign) {
        String winningMove= "";
        if (handSign.equals(ROCK)) {winningMove = PAPER;}
        else if (handSign.equals(PAPER)) {winningMove = SCISSOR;}
        else if (handSign.equals(SCISSOR)) {winningMove = ROCK;}
        return winningMove;
    }

    /**
     * @param handSign a string representative of a hand sign
     * @return the respective losing move
     */
    public String getLosingMove(String handSign) {
        return getWinningMove(getWinningMove(handSign));
    }

    /**
     * @param handSignOfPlayer1 a string representative of a hand sign of a player
     * @param handSignOfPlayer2 a string representative of a hand sign of a challenger
     * @return a string representative of the winning hand sign between the two players
     */
    public String getWinner(String handSignOfPlayer1, String handSignOfPlayer2) {
        String winner = "";
        if (getWinningMove(handSignOfPlayer1).equals(handSignOfPlayer2)) {winner= handSignOfPlayer2;}
        else if (getWinningMove(handSignOfPlayer2).equals(handSignOfPlayer1)) {winner= handSignOfPlayer1;}
        return winner;
    }
}
