package Main;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Menu implements Runnable
{

	private Thread t;
	private String songName;
	public String songname = "res/songs/Menu.wav";
	static boolean running = true;
	Menu( String name){
		songName = name;
		System.out.println("Playing " +  songName );
	}
	
	public void run()
	{
		while (running)
		{
			System.out.println("Running Thread");
			MusicBox.playSound(songname);
		}
		MusicBox.sourceLine.stop();
		System.out.println("Thread  exiting.");
	}

	public void start ()
	{
		System.out.println("Starting Thread");
		if (t == null)
		{
			t = new Thread (this, "Music");
			t.start ();
		}
	}

	public static int sizeY = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	public static int index = 0;
	static long nextTime;
	static JButton connectButton, helpButton, settingsButton, creditButton;
	static JFrame menuContainer;
	static JPanel menu;
	static Thread initThread, musicThread;



	public static void init()
	{
		menuContainer = new JFrame();
		menuContainer.setUndecorated(true);
		JPanel menu = new JPanel();
		//JLabel text = new JLabel("<html><br><br>CONNECT<br>HELP<br>SETTINGS</html>", SwingConstants.CENTER);
		connectButton = new JButton("CONNECT");
		helpButton = new JButton("HELP");
		settingsButton = new JButton("SETTINGS");
		creditButton = new JButton("CREDIT");
		JLabel title = new JLabel("PONG");
		Font font = new Font("8BIT WONDER", 32, 40);
		//button.setForeground(Color.WHITE);
		connectButton.setFont(font);
		helpButton.setFont(font);
		settingsButton.setFont(font);
		creditButton.setFont(font);
		title.setFont(font);
		title.setForeground(Color.WHITE);
		menu.add(title);
		menu.add(connectButton);
		menu.add(helpButton);
		menu.add(settingsButton);
		menu.add(creditButton);

		menu.setBackground(Color.BLACK);
		//menu.setLayout(new OverlayLayout(menu));
		menuContainer.setSize(sizeY, sizeY);
		menuContainer.add(menu);
		menuContainer.setVisible(true);
		go();
	}
	public static void go()
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
				//Choice.init();
				return;
			}
		}
	}
}
