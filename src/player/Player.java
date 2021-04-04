package player;

import utils.Position;
import utils.Vector;

public class Player {
    public Position position;
    public Vector velocity;

    public Player(Position position) {
        this.position = position;
        this.velocity = new Vector(0,0);
    }

    public void accelerate(Vector acceleration) {
        velocity.add(acceleration);
    }

    public void move() {
        position.add(velocity);
    }
}
