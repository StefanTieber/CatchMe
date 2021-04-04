package game;

import player.Player;
import player.PlayerAlgorythm;
import utils.Position;
import utils.Vector;

public class GameController {
    public final float MAX_ACCELERATION = 1;
    public final float MAX_VELOCITY = 30;

    private PlayerAlgorythm runnerAlgorythm;
    private PlayerAlgorythm catcherAlgorythm;

    private Player runner;
    private Player catcher;

    public GameController(PlayerAlgorythm runnerAlgorythm, PlayerAlgorythm catcherAlgorythm) {
        this.runnerAlgorythm = runnerAlgorythm;
        this.catcherAlgorythm = catcherAlgorythm;

        this.runner = new Player(new Position());
        this.catcher = new Player(new Position());
    }

    private void tick() {
        Vector runnerAction = runnerAlgorythm.getAction(runner, catcher);
        Vector catcherAction = catcherAlgorythm.getAction(catcher, runner);

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
