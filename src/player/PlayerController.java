package player;

import java.awt.*;
import java.util.TimerTask;

public class PlayerController extends TimerTask {
    public Point playerLocation = new Point(960, 540);

    public void getStrategy() {
        Point mouseLocation = MouseInfo.getPointerInfo().getLocation();
        int deltaX = mouseLocation.x - playerLocation.x;
        int deltaY = mouseLocation.y - playerLocation.y;
        System.out.println("x: " + deltaX + ", y: " + deltaY);
    }

    @Override
    public void run() {
        getStrategy();
    }
}
