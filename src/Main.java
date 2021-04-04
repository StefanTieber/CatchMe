import game.GameController;
import player.MouseRunner;
import player.PlayerAlgorithm;
import player.SimpleCatcher;

public class Main {
    public static void main(String[] args) {
        PlayerAlgorithm runnerAlgorithm = new MouseRunner();
        PlayerAlgorithm catcherAlgorithm = new SimpleCatcher();

        GameController gameController = new GameController(runnerAlgorithm, catcherAlgorithm);
        gameController.startGame();
    }
}
