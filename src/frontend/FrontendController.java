package frontend;

import javax.swing.*;
import java.awt.*;

public class FrontendController extends JPanel {
    static int width = 25;
    static int height = 25;

    int x;
    int y;
    float vx;
    float vy;

    private JFrame frame;

    public FrontendController() {
        x = 200;
        y = 200;
        vx = 10;
        vy = 10;

        frame = new JFrame("Catch Me!");

        frame.setSize(500, 500);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(this);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        g.clearRect(0, 0, this.getWidth(), this.getHeight());
        g.fillOval(x, y, width, height);
    }
}
