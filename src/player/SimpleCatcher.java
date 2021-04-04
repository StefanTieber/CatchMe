package player;

import utils.Vector;

public class SimpleCatcher implements PlayerAlgorythm {

    @Override
    public Vector getAction(Player you, Player enemy) {
        float deltaX = enemy.position.x - you.position.x;
        float deltaY = enemy.position.y - you.position.y;
        System.out.println("catcher vector x: " + deltaX + ", catcher vector y: " + deltaY);

        return new Vector(deltaX, deltaY);
    }
}
