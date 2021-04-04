package player;

import utils.Position;
import utils.Vector;

import java.awt.*;

public class MouseRunner implements PlayerAlgorythm {

    @Override
    public Vector getAction(Player you, Player enemy) {
        Point mouseLocation = MouseInfo.getPointerInfo().getLocation();
        float deltaX = mouseLocation.x - you.position.x;
        float deltaY = mouseLocation.y - you.position.y;
        System.out.println("runner vector  x: " + deltaX + ", runner vector y: " + deltaY);

        return new Vector(deltaX, deltaY);
    }
}
