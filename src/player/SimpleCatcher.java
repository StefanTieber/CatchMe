package player;

import game.GameController;
import utils.Vector;

public class SimpleCatcher implements PlayerAlgorithm {

    @Override
    public Vector getAction(Player you, Player enemy) {
        float deltaX = enemy.position.x - you.position.x;
        float deltaY = enemy.position.y - you.position.y;
        Vector wantedVelocity = new Vector(deltaX, deltaY);

        wantedVelocity.trimLength(GameController.MAX_VELOCITY);

        float deltaXv = wantedVelocity.x - you.velocity.x;
        float deltaYv = wantedVelocity.y - you.velocity.y;
        return new Vector(deltaXv, deltaYv);
    }
}
