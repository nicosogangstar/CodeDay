package Main;
import java.awt.event.*;
import javax.swing.*;

public class KeyTester extends JFrame implements KeyListener, ActionListener
{
	
	private static final long serialVersionUID = 1L;
	public KeyTester()
     {
	    	addKeyListener(this);
	    	setUndecorated(true);
     }
     
    /** Handle the key typed event from the text field. */
    public void keyTyped(KeyEvent e)
    {
    	//System.out.println(e.getKeyChar());
    }
     
    /** Handle the key pressed event from the text field. */
    public void keyPressed(KeyEvent e)
    {
    	//P1
    	if(e.getKeyCode() == KeyEvent.VK_UP)
    	{
    		Game.rightPaddle.direction = -1;
    	}
    	else if(e.getKeyCode() == KeyEvent.VK_DOWN)
    	{
    		Game.rightPaddle.direction = 1;
    	}
    	else if(e.getKeyCode() == KeyEvent.VK_I)
    	{
    		Game.upPaddle.direction = -1;
    	}
    	else if(e.getKeyCode() == KeyEvent.VK_P)
    	{
    		Game.upPaddle.direction = 1;
    	}
    	
    	//P2
    	else if(e.getKeyCode() == KeyEvent.VK_W)
    	{
    		Game.leftPaddle.direction = -1;
    	}
    	else if(e.getKeyCode() == KeyEvent.VK_S)
    	{
    		Game.leftPaddle.direction = 1;
    	}
    	else if(e.getKeyCode() == KeyEvent.VK_Z)
    	{
    		Game.downPaddle.direction = -1;
    	}
    	else if(e.getKeyCode() == KeyEvent.VK_C)
    	{
    		Game.downPaddle.direction = 1;
    	}
    }
     
    /** Handle the key released event from the text field. */
    public void keyReleased(KeyEvent e)
    {
    	//P1
    	if(e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN)
    	{
    		Game.rightPaddle.direction = 0;
    	}
    	else if(e.getKeyCode() == KeyEvent.VK_I || e.getKeyCode() == KeyEvent.VK_P)
    	{
    		Game.upPaddle.direction = 0;
    	}
    	
    	//P2
    	else if(e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_S)
    	{
    		Game.leftPaddle.direction = 0;
    	}
    	
    	else if(e.getKeyCode() == KeyEvent.VK_Z || e.getKeyCode() == KeyEvent.VK_C)
    	{
    		Game.downPaddle.direction = 0;
    	}
    }
    public void actionPerformed(ActionEvent e)
    {
    	
    }
}