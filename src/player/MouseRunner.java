package player;

import frontend.FrontendController;
import game.GameController;
import utils.Vector;

import java.awt.*;

public class MouseRunner implements PlayerAlgorithm {

    @Override
    public Vector getAction(Player you, Player enemy) {
        Point mouseLocation = FrontendController.frame.getMousePosition();

        if (mouseLocation != null) {
            float deltaX = mouseLocation.x - you.position.x;
            float deltaY = mouseLocation.y - you.position.y;
            Vector wantedVelocity = new Vector(deltaX, deltaY);

            wantedVelocity.trimLength(GameController.MAX_VELOCITY);

            float deltaXv = wantedVelocity.x - you.velocity.x;
            float deltaYv = wantedVelocity.y - you.velocity.y;
            return new Vector(deltaXv, deltaYv);
        } else {
            return new Vector();
        }
    }
}
