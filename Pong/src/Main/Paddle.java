package Main;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class Paddle extends JPanel
{
	public static final long serialVersionUID = 1;
	public int sizeX, sizeY, speed, direction,pSize;
	public double posX,posY;
	public Color clr;
	public boolean xaxis;
	public Rectangle paddle = new Rectangle((int)posX, (int)posY, sizeX, sizeY);
	int size = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	public Polygon p1 = new Polygon(new int[]{0, 0, 50}, new int[]{0, 50, 0}, 3);
	public Polygon p2 = new Polygon(new int[]{size-50, size, size}, new int[]{0, 0, 50}, 3);
	public Polygon p3 = new Polygon(new int[]{0, 0, 50}, new int[]{size, size-50, size}, 3);
	public Polygon p4 = new Polygon(new int[]{size-50, size, size}, new int[]{size, size, size-50}, 3);
	
	@Override
	public void paint(Graphics gr)
	{
		Graphics2D g = (Graphics2D) gr;
		g.setColor(clr);
		paddle = new Rectangle((int)posX, (int)posY, sizeX, sizeY);
		g.fill(paddle);
//		g.fill(p1);
//		g.fill(p2);
//		g.fill(p3);
//		g.fill(p4);
	}
	public Paddle(int sizeX, int sizeY, int posX, int posY, int speed, Color c, int pSize, boolean xaxis)
	{
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.posX = posX;
		this.posY = posY;
		this.clr = c;
		this.speed = speed;
		this.pSize = pSize;
		this.direction = 0;
		this.xaxis = xaxis;
	}
	public void tick()
	{
		//System.out.println(Drawing.rightPaddle.direction);
		if(this.direction==1 && this.posY+sizeY<pSize)
		{
			if(this.xaxis)
			{
				this.posX+=speed;
			}
			else
			{
				this.posY+=speed;
			}
		}
		if(this.direction==-1 && this.posY>0)
		{
			if(this.xaxis)
			{
				this.posX-=speed;
			}
			else
			{
				this.posY-=speed;
			}
		}
	}
}
