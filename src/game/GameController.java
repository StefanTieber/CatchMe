package game;

import player.Player;
import utils.Position;
import utils.Vector;

public class GameController {
    Player runner;
    Player catcher;

    Position runnerPosition;
    Position catcherPosition;

    Vector runnerSpeed;
    Vector catcherSpeed;

    public void tick() {
        Vector runnerMove = runner.getMove(runnerPosition, runnerSpeed, catcherPosition, catcherSpeed);
        Vector catcherMove = catcher.getMove(catcherPosition, catcherSpeed, runnerPosition, runnerSpeed);

        runnerSpeed.add(runnerMove);
        runnerPosition.move(runnerSpeed);

        catcherSpeed.add(catcherMove);
        catcherPosition.move(catcherSpeed);
    }
}
