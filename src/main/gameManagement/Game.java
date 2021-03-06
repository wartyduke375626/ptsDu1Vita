package gameManagement;

import gameComponents.*;

public class Game implements GameInterface {

    private final TurnInterface turnInterface;
    private boolean isPlayCardPhase;
    private final EndGameStrategy endGameStrategy;

    public Game(TurnInterface turnInterface, EndGameStrategy endGameStrategy) {
        isPlayCardPhase = false;
        this.turnInterface = turnInterface;
        this.endGameStrategy = endGameStrategy;
        endTurn();
    }

    @Override
    public boolean playCard(int handIndex) {
        if (isGameOver()) return false;
        if (isPlayCardPhase) return turnInterface.playCard(handIndex);
        return false;
    }

    @Override
    public boolean endPlayCardPhase() {
        if (isGameOver()) return false;
        if (!isPlayCardPhase) return false;
        isPlayCardPhase = false;
        return true;
    }

    @Override
    public boolean buyCard(GameCardType gameCardType) {
        if (isGameOver()) return false;
        if (!isPlayCardPhase) return turnInterface.buyCard(gameCardType);
        return false;
    }

    @Override
    public boolean endTurn() {
        if (isGameOver()) return false;
        if (isPlayCardPhase) return false;
        isPlayCardPhase = true;
        turnInterface.newTurn();
        return true;
    }

    @Override
    public boolean isGameOver() {
        return endGameStrategy.isGameOver();
    }

}
