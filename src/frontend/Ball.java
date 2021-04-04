package frontend;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Ball extends JPanel implements Runnable, KeyListener
{
	static Thread t;
	static JFrame frame;
	static Ball panel;
	static int width = 25;
	static int height = 25;
	
	int x;
	int y;
	float vx;
	float vy;
	
	public Ball()
	{
		frame.addKeyListener(this);
		x = 200;
		y = 200;
		vx = 10;
		vy = 10;
		
		t = new Thread(this);
		
		t.start();
	}
	
	public static void main(String[] args)
	{
		frame = new JFrame("Ball");
		panel = new Ball();
		
		frame.setSize(500, 500);
		frame.setLayout(null);
		frame.setBackground(Color.GRAY);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(panel);
		frame.setVisible(true);
	}
	
	public void run()
	{
		while(true)
		{
			if(x > this.getWidth() - width || x < 0)
			{
				vx = vx * -1;
			}
			if(y > this.getHeight() - height|| y < 0)
			{
				vy = vy * -1;
			}
			
			x += vx;
			y += vy;
			
			repaint();
			
			try
			{
				Thread.sleep(25);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public void paint(Graphics g)
	{
		g.clearRect(0, 0, this.getWidth(), this.getHeight());
	    g.fillOval(x, y, width, height);
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		float vxold = vx;
		float vyold = vy;
		if(e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			vx = (int) Math.cos(Math.PI / -2) * vxold - (int) Math.sin(Math.PI / -2) * vyold;
        	vy = (int) Math.sin(Math.PI / -2) * vxold + (int) Math.cos(Math.PI / -2) * vyold;
		}
		else if(e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			vx = (int) Math.cos(Math.PI / 2) * vxold - (int) Math.sin(Math.PI / 2) * vyold;
        	vy = (int) Math.sin(Math.PI / 2) * vxold + (int) Math.cos(Math.PI / 2) * vyold;
		}
		else if(e.getKeyCode() == KeyEvent.VK_UP)
		{
			if(vx > 1000 || vy > 1000)
			{
			}
			else
			{
				vx *= 1.1;
				vy *= 1.1;
			}
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			vx *= 0.9;
			vy *= 0.9;
		}
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
	}
}