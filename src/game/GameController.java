package game;

import frontend.FrontendController;
import player.Player;
import player.PlayerAlgorithm;
import utils.Position;
import utils.Vector;

public class GameController {
    public final int GAME_WIDTH = 500;
    public final int GAME_HEIGHT = 500;

    public final float MAX_ACCELERATION = 1;
    public final float MAX_VELOCITY = 10;

    private PlayerAlgorithm runnerAlgorithm;
    private PlayerAlgorithm catcherAlgorithm;

    private Player runner;
    private Player catcher;

    private FrontendController frontendController;

    public GameController(PlayerAlgorithm runnerAlgorithm, PlayerAlgorithm catcherAlgorithm) {
        this.runnerAlgorithm = runnerAlgorithm;
        this.catcherAlgorithm = catcherAlgorithm;

        this.runner = new Player(new Position());
        this.catcher = new Player(new Position());

        this.frontendController = new FrontendController(GAME_WIDTH, GAME_HEIGHT, runner, catcher);
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

        frontendController.repaint();
    }
}
