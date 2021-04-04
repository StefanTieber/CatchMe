package frontend;

import player.Player;

import javax.swing.*;
import java.awt.*;

public class FrontendController extends JPanel {
    private static final int PLAYER_SIZE = 20;
    public static final int BORDER_THICKNESS = 10;

    private JFrame frame;

    private Player catcher;
    private Player runner;

    public FrontendController(int gamewidth, int gameheight, Player catcher, Player runner) {
        this.catcher = catcher;
        this.runner = runner;

        frame = new JFrame("Catch Me!");
        frame.setSize(adjustForBorders(gamewidth), adjustForBorders(gameheight));
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setContentPane(this);
        frame.setVisible(true);
    }

    private int adjustForBorders(int size) {
        return size + BORDER_THICKNESS * 2 + PLAYER_SIZE / 2;
    }

    private int adjustForBorder(int x) {
        return x + BORDER_THICKNESS;
    }

    @Override
    public void paint(Graphics g) {
        clearScreen(g);
        drawBorder((Graphics2D) g);
        drawCatcher(g);
        drawRunner(g);
    }

    private void clearScreen(Graphics g) {
        g.clearRect(0, 0, this.getWidth(), this.getHeight());
    }

    private void drawBorder(Graphics2D g) {
        Stroke oldStroke = g.getStroke();
        g.setStroke(new BasicStroke(BORDER_THICKNESS));
        g.drawRect(BORDER_THICKNESS / 2, BORDER_THICKNESS / 2, this.getWidth() - 1 - BORDER_THICKNESS / 2, this.getHeight() - 1 - BORDER_THICKNESS / 2);
        g.setStroke(oldStroke);
    }

    private void drawCatcher(Graphics g) {
        drawPlayer(g, catcher, Color.RED);
    }

    private void drawRunner(Graphics g) {
        drawPlayer(g, runner, Color.BLUE);
    }

    private void drawPlayer(Graphics g, Player player, Color red) {
        g.setColor(red);
        g.fillOval(adjustForBorder((int) player.position.x), adjustForBorder((int) player.position.y), PLAYER_SIZE, PLAYER_SIZE);
    }
}
