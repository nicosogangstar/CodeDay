package Main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;


public class ChoiceKeys extends JFrame implements KeyListener, ActionListener{
	private static final long serialVersionUID = 1L;

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_UP)
    	{
			if(Choice.selected>0){
				Choice.selected -= 1;
			}
    	}
    	else if(e.getKeyCode() == KeyEvent.VK_DOWN)
    	{
    		if(Choice.selected<Choice.countries.length){
    			Choice.selected += 1;
    		}
    	}
		for(int i=0;i<Choice.countries.length;i++){
			 Choice.jCountries[i].deselect();
		}
		Choice.jCountries[Choice.selected].select();
	}
	
	
	//NECESSARY METHODS::NOT USEFUL
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
