
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JPanel;
public class Ball extends JPanel{
	public static final long serialVersionUID = 1;
	Color clr;
	public int radius, pageY, pageX;
	public double x,y,ySpeed,xSpeed,absSpeed;
	public Rectangle ball = new Rectangle((int)x-radius/2, (int)y-radius/2, radius, radius);;
	
	public Ball(int size, Color c,int startX,int startY, int pSizeX, int pSizeY, double absSpeed, double angle)
	{
		this.radius = size;
		this.clr = c;
		this.x = startX;
		this.y = startY;
		this.pageX = pSizeX;
		this.pageY = pSizeY;
		this.ySpeed = (Math.sin(angle)*absSpeed);
		this.xSpeed = (Math.cos(angle)*absSpeed);
		this.absSpeed = absSpeed;
	}
	
	public void paint(Graphics gr)
	{
		Graphics2D g = (Graphics2D) gr;
		g.setColor(clr);
		g.setBackground(new Color(0f,0f,0f,0f ));
		ball = new Rectangle((int)x-radius/2, (int)y-radius/2, radius, radius);
		g.fill(ball);
	}
	public void tick(){
		
		x+=xSpeed;
		y+=ySpeed;
		if(y+radius+10 >= pageY || y-radius/2<=0)
		{
			yBounce();
		}
		if(x+radius/2 >= pageX || x-radius/2<=0)
		{
			xBounce();
		}
	}
	public void yBounce()
	{
		this.ySpeed=-this.ySpeed;
	}
	public void yBounce(double _y)
	{
		this.ySpeed=-this.ySpeed;
		this.y = _y;
	}
	
	
	public void xBounce(double _x)
	{
		this.xSpeed=-this.xSpeed;
		this.x = _x;
	}
	public void xBounce()
	{
		this.xSpeed= -this.xSpeed;
	}
	public void setDirection(double angle){
		this.ySpeed = (Math.sin(angle)*absSpeed);
		this.xSpeed = (Math.cos(angle)*absSpeed);
	}
}
