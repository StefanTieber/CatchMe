package player;

import utils.Position;
import utils.Vector;

public interface Player {
    public Vector getMove(Position yourPosition, Vector yourVector, Position enemyPosition, Vector enemyVector);
}
