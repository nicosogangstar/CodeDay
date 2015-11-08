import java.awt.event.*;
import javax.swing.*;

public class KeyTester extends JFrame implements KeyListener, ActionListener
{
     public KeyTester()
     {
	    	addKeyListener(this);
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
    	else if(e.getKeyCode() == KeyEvent.VK_LEFT)
    	{
    		Game.upPaddle.direction = -1;
    	}
    	else if(e.getKeyCode() == KeyEvent.VK_RIGHT)
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
    	else if(e.getKeyCode() == KeyEvent.VK_A)
    	{
    		Game.downPaddle.direction = -1;
    	}
    	else if(e.getKeyCode() == KeyEvent.VK_D)
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
    	else if(e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_RIGHT)
    	{
    		Game.upPaddle.direction = 0;
    	}
    	
    	//P2
    	else if(e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_S)
    	{
    		Game.leftPaddle.direction = 0;
    	}
    	
    	else if(e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_D)
    	{
    		Game.downPaddle.direction = 0;
    	}
    }
    public void actionPerformed(ActionEvent e)
    {
    	
    }
}