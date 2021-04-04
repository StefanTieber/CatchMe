package player;

import utils.Position;
import utils.Vector;

public interface PlayerAlgorithm {
    public Vector getAction(Player you, Player enemy);
}
