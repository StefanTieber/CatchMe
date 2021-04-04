package game;

import player.Player;
import utils.Position;
import utils.Vector;

public class GameController {
    public final float MAX_VELOCITY = 30;

    private Player runner;
    private Player catcher;

    private Position runnerPosition;
    private Position catcherPosition;

    private Vector runnerVelocity;
    private Vector catcherVelocity;

    public GameController(Player runner, Player catcher) {
        this.runner = runner;
        this.catcher = catcher;

        this.runnerPosition = new Position((float) Math.random(), (float) Math.random());
        this.catcherPosition = new Position((float) Math.random(), (float) Math.random());

        this.runnerVelocity = new Vector(0,0);
        this.catcherVelocity = new Vector(0,0);
    }

    public void tick() {
        Vector runnerMove = runner.getMove(runnerPosition, runnerVelocity, catcherPosition, catcherVelocity);
        Vector catcherMove = catcher.getMove(catcherPosition, catcherVelocity, runnerPosition, runnerVelocity);

        runnerVelocity.add(runnerMove);
        runnerPosition.move(runnerVelocity);

        catcherVelocity.add(catcherMove);
        catcherPosition.move(catcherVelocity);

        //TODO call frontend
    }
}
