package game;

import frontend.FrontendController;
import player.Player;
import player.PlayerAlgorithm;
import utils.Position;
import utils.Vector;

import java.util.Timer;
import java.util.TimerTask;

public class GameController extends TimerTask {
    public static final int GAME_WIDTH = 500;
    public static final int GAME_HEIGHT = 500;

    public static final float MAX_ACCELERATION = 1;
    public static final float MAX_VELOCITY = 10;

    private PlayerAlgorithm runnerAlgorithm;
    private PlayerAlgorithm catcherAlgorithm;

    private Player runner;
    private Player catcher;

    private FrontendController frontendController;

    public GameController(PlayerAlgorithm runnerAlgorithm, PlayerAlgorithm catcherAlgorithm) {
        this.runnerAlgorithm = runnerAlgorithm;
        this.catcherAlgorithm = catcherAlgorithm;

        this.runner = new Player(new Position(0, 0));
        this.catcher = new Player(new Position(300, 200));

        this.frontendController = new FrontendController(GAME_WIDTH, GAME_HEIGHT, runner, catcher);
    }

    public void startGame() {
        Timer timer = new Timer();
        timer.schedule(this, 0, 30);
    }

    public void run() {
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
