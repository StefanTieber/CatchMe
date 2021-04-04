package player;

import utils.Position;
import utils.Vector;

import java.awt.*;

public class MouseRunner implements Player {

    @Override
    public Vector getMove(Position yourPosition, Vector yourVector, Position enemyPosition, Vector enemyVector) {
        Point mouseLocation = MouseInfo.getPointerInfo().getLocation();
        float deltaX = mouseLocation.x - yourPosition.x;
        float deltaY = mouseLocation.y - yourPosition.y;
        System.out.println("x: " + deltaX + ", y: " + deltaY);

        return new Vector(deltaX, deltaY);
    }
}
