package player;

import utils.Position;
import utils.Vector;

import java.awt.*;

public class MouseRunner implements Player {

    @Override
    public Vector getMove(Position yourPosition, Vector yourVelocity, Position enemyPosition, Vector enemyVelocity) {
        Point mouseLocation = MouseInfo.getPointerInfo().getLocation();
        float deltaX = mouseLocation.x - yourPosition.x;
        float deltaY = mouseLocation.y - yourPosition.y;
        System.out.println("runner vector  x: " + deltaX + ", runner vector y: " + deltaY);

        return new Vector(deltaX, deltaY);
    }
}
