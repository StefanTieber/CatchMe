import frontend.FrontendController;
import player.Player;
import utils.Position;

public class Main {
    public static void main(String[] args) {
        Player catcher = new Player(new Position(0, 0));
        Player runner = new Player(new Position(300, 200));
        FrontendController frontendController = new FrontendController(500, 500, catcher, runner);

        System.out.println("Du Schneckli!");
    }
}
