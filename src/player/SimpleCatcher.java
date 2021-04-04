package player;

import utils.Position;
import utils.Vector;

public class SimpleCatcher implements Player {

    @Override
    public Vector getMove(Position yourPosition, Vector yourVector, Position enemyPosition, Vector enemyVector) {
        float deltaX = enemyPosition.x - yourPosition.x;
        float deltaY = enemyPosition.y - yourPosition.y;
        System.out.println("catcher vector x: " + deltaX + ", catcher vector y: " + deltaY);

        return new Vector(deltaX, deltaY);
    }
}
