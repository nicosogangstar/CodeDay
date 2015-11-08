import java.awt.Color;
import java.awt.Font;
import java.awt.MenuContainer;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class Menu
{
	public static int sizeY = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	public static int index = 0;
	static long nextTime;
	static JButton connectButton, helpButton, settingsButton, creditButton;
	static JFrame menuContainer;
	public static void init()
	{
		menuContainer = new JFrame();
		JPanel all = new JPanel();
		//JLabel text = new JLabel("<html><br><br>CONNECT<br>HELP<br>SETTINGS</html>", SwingConstants.CENTER);
		connectButton = new JButton("CONNECT");
		helpButton = new JButton("HELP");
		settingsButton = new JButton("SETTINGS");
		creditButton = new JButton("CREDIT");
		Font font = new Font("Helvetica", 32, 40);
		//button.setForeground(Color.WHITE);
		connectButton.setFont(font);
		helpButton.setFont(font);
		settingsButton.setFont(font);
		creditButton.setFont(font);
		all.add(connectButton);
		all.add(helpButton);
		all.add(settingsButton);
		all.add(creditButton);
		
		all.setBackground(Color.BLACK);
		//all.setLayout(new OverlayLayout(all));
		menuContainer.setSize(sizeY, sizeY);
		menuContainer.add(all);
		menuContainer.setVisible(true);
	}
	public static void run()
	{
		while(true)
		{
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
			if(connectButton.getModel().isPressed())
			{
				menuContainer.dispose();
				return;
			}
		}
	}
	
}
