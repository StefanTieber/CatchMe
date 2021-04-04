package player;

import utils.Position;
import utils.Vector;

public interface PlayerAlgorythm {
    public Vector getAction(Player you, Player enemy);
}
