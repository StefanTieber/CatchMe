package frontend;

import player.Player;

import javax.swing.*;
import java.awt.*;

public class FrontendController extends JPanel {
    private static final int PLAYER_SIZE = 20;
    private static final int FRAME_WIDTH = 500;
    private static final int FRAME_HEIGHT = 500;

    private JFrame frame;

    private Player catcher;
    private Player runner;

    public FrontendController(Player catcher, Player runner) {
        this.catcher = catcher;
        this.runner = runner;

        frame = new JFrame("Catch Me!");
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setContentPane(this);
        frame.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        g.clearRect(0, 0, this.getWidth(), this.getHeight());

        drawCatcher(g);
        drawRunner(g);
    }

    private void drawCatcher(Graphics g) {
        drawPlayer(g, catcher, Color.RED);
    }

    private void drawRunner(Graphics g) {
        drawPlayer(g, runner, Color.BLUE);
    }

    private void drawPlayer(Graphics g, Player player, Color red) {
        g.setColor(red);
        g.fillOval((int) player.position.x, (int) player.position.y, PLAYER_SIZE, PLAYER_SIZE);
    }
}
