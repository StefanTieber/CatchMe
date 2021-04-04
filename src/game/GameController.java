package game;

import player.Player;
import utils.Position;
import utils.Vector;

public class GameController {
    public final float MAX_SPEED = 30;

    private Player runner;
    private Player catcher;

    private Position runnerPosition;
    private Position catcherPosition;

    private Vector runnerSpeed;
    private Vector catcherSpeed;

    public GameController(Player runner, Player catcher) {
        this.runner = runner;
        this.catcher = catcher;

        this.runnerPosition = new Position((float) Math.random(), (float) Math.random());
        this.catcherPosition = new Position((float) Math.random(), (float) Math.random());

        this.runnerSpeed = new Vector(0,0);
        this.catcherSpeed = new Vector(0,0);
    }

    public void tick() {
        Vector runnerMove = runner.getMove(runnerPosition, runnerSpeed, catcherPosition, catcherSpeed);
        Vector catcherMove = catcher.getMove(catcherPosition, catcherSpeed, runnerPosition, runnerSpeed);

        runnerSpeed.add(runnerMove);
        runnerPosition.move(runnerSpeed);

        catcherSpeed.add(catcherMove);
        catcherPosition.move(catcherSpeed);

        //TODO call frontend
    }
}
