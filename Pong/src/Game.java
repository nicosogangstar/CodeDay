import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;


public class Game 
{

	public static final long serialVersionUID = 1;
	//final static int sizeX = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	final static int 
			sizeY = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight(), 
			sizeX = sizeY,
			paddleHeight = 75,
			paddleWidth = 20,
			ballSize = 35,
			maxYDist = ballSize/2+paddleHeight/2,
			maxXDist = ballSize/2+paddleWidth/2;
	final static double absSpeed = 1.0;
	
	static int hitter = -1;
	
	static long nextTime, restart;
	static Ball theBall;
	static int winner = -1;
	static KeyTester topContainer;
	
	static Paddle leftPaddle, rightPaddle, upPaddle, downPaddle;
	public static void init()
	{
		leftPaddle  = new Paddle(paddleWidth, paddleHeight, 15,                  sizeY/2 - paddleHeight/2, 1, Color.white, sizeY-30, false);
		rightPaddle = new Paddle(paddleWidth, paddleHeight, sizeX-2*paddleWidth, sizeY/2 - paddleHeight/2, 1, Color.white, sizeY-30, false);
		downPaddle  = new Paddle(paddleHeight, paddleWidth, sizeX/2-paddleHeight/2, sizeY - paddleHeight,    1, Color.white, sizeY-30, true);
		upPaddle    = new Paddle(paddleHeight, paddleWidth, sizeX/2-paddleHeight/2, paddleWidth,            1, Color.white, sizeY-30, true);
		
		theBall = new Ball(ballSize,Color.WHITE,sizeX/2,sizeY/2,sizeX,sizeY,absSpeed,Math.PI);
		topContainer = new KeyTester();
		JPanel all = new JPanel();
		topContainer.setBackground(Color.BLACK);
		topContainer.setSize(Game.sizeX, Game.sizeY);
		all.add(theBall);
		all.add(downPaddle);
		all.add(leftPaddle);
		all.add(rightPaddle);
		all.add(upPaddle);
		all.setLayout(new OverlayLayout(all));
		topContainer.add(all);
		topContainer.setVisible(true);
		
	}
	
	public static void run()
	{
		while(true){
			while(System.currentTimeMillis()<nextTime)
			{
				try
				{
					Thread.sleep(1);
				} catch (InterruptedException e)
				{
					Thread.currentThread().interrupt();
				}
			}
			nextTime = System.currentTimeMillis()+2;
			theBall.tick();
			leftPaddle.tick();
			rightPaddle.tick();
			upPaddle.tick();
			downPaddle.tick();
			
			//System.out.println(rightPaddle.paddle.y);
			//simulate collisions
			if(rightPaddle.paddle.intersects(theBall.ball))
			{
				theBall.xBounce(rightPaddle.posX-paddleWidth);
				theBall.absSpeed+=0.05;
				theBall.setDirection(Math.PI - (theBall.y - rightPaddle.posY - rightPaddle.sizeY / 2) / 37.5 * Math.PI/3);
				hitter = 0;
			}
			else if(leftPaddle.paddle.intersects(theBall.ball))
			{
				theBall.xBounce(leftPaddle.posX+2*paddleWidth);
				theBall.absSpeed+=0.05;
				theBall.setDirection((theBall.y - leftPaddle.posY - leftPaddle.sizeY / 2) / 37.5 * Math.PI/3);
				hitter = 1;
			}
			else if(upPaddle.paddle.intersects(theBall.ball))
			{
				theBall.yBounce(upPaddle.posY+2*paddleWidth);
				theBall.absSpeed+=0.05;
				theBall.setDirection((Math.PI/2-(((theBall.x - upPaddle.posX - upPaddle.sizeX / 2) / 37.5)*Math.PI/3)));
				hitter = 2;
			}
			else if(downPaddle.paddle.intersects(theBall.ball))
			{
				theBall.yBounce(downPaddle.posY-paddleWidth);
				theBall.absSpeed+=0.05;
				theBall.setDirection(-(Math.PI/2-(((theBall.x - downPaddle.posX - downPaddle.sizeX / 2) / 37.5)*Math.PI/3)));
				hitter = 3;
			}
			
			if(theBall.x>rightPaddle.posX)
			{
				System.out.println("RIGHT LOSES");
				winner = hitter;
			}
			else if(theBall.x<leftPaddle.posX)
			{
				System.out.println("LEFT LOSES");
				winner = hitter;
			}
			if(theBall.y>downPaddle.posY)
			{
				System.out.println("DOWN LOSES");
				winner = hitter;
			}
			else if(theBall.y<upPaddle.posY)
			{
				System.out.println("UP LOSES");
				winner = hitter;
			}
			if(winner!=-1)
			{
				restart = System.currentTimeMillis()+1000;
				leftPaddle.clr = Color.red;
				rightPaddle.clr = Color.red;
				upPaddle.clr = Color.red;
				downPaddle.clr = Color.red;
				if(winner == 0)
				{
					rightPaddle.clr = Color.green;
				}
				else if(winner == 1)
				{
					leftPaddle.clr = Color.green;
				}
				else if(winner == 2)
				{
					upPaddle.clr = Color.green;
				}
				else if(winner == 3)
				{
					downPaddle.clr = Color.green;
				}
				theBall.x = sizeX/2;
				theBall.y = sizeY/2;
				theBall.absSpeed = absSpeed;
				topContainer.repaint();
				
				while(System.currentTimeMillis()<restart)
				{
					try
					{
						Thread.sleep(1);
					}
					catch (InterruptedException e)
					{
						Thread.currentThread().interrupt();
					}
				}
				rightPaddle.clr = Color.white;
				leftPaddle.clr = Color.white;
				upPaddle.clr = Color.white;
				downPaddle.clr = Color.white;
				
				rightPaddle.posY = sizeY/2 - paddleHeight/2;
				leftPaddle.posY = sizeY/2 - paddleHeight/2;
				upPaddle.posX = sizeX/2 - paddleHeight/2;
				downPaddle.posX = sizeX/2 - paddleHeight/2;
				theBall.setDirection(Math.PI);				
				winner=-1;
			}
			topContainer.repaint();
		}
		
	}
	
}
