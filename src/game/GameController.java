package game;

import player.Player;
import player.PlayerAlgorithm;
import utils.Position;
import utils.Vector;

public class GameController {
    public final float MAX_ACCELERATION = 1;
    public final float MAX_VELOCITY = 30;

    private PlayerAlgorithm runnerAlgorithm;
    private PlayerAlgorithm catcherAlgorithm;

    private Player runner;
    private Player catcher;

    public GameController(PlayerAlgorithm runnerAlgorithm, PlayerAlgorithm catcherAlgorithm) {
        this.runnerAlgorithm = runnerAlgorithm;
        this.catcherAlgorithm = catcherAlgorithm;

        this.runner = new Player(new Position());
        this.catcher = new Player(new Position());
    }

    private void tick() {
        Vector runnerAction = runnerAlgorithm.getAction(runner, catcher);
        Vector catcherAction = catcherAlgorithm.getAction(catcher, runner);

        runnerAction.trimLength(MAX_ACCELERATION);
        catcherAction.trimLength(MAX_ACCELERATION);

        runner.accelerate(runnerAction);
        catcher.accelerate(catcherAction);

        runner.velocity.trimLength(MAX_VELOCITY);
        catcher.velocity.trimLength(MAX_VELOCITY);

        runner.move();
        catcher.move();

        //TODO call frontend
    }
}
