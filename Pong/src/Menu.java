import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Menu
{
	public static int sizeY = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	public static int index = 0;
	static long nextTime;
	static JButton connectButton, helpButton, settingsButton, creditButton;
	static JFrame menuContainer;
	public static void init()
	{
		//initialize all countries
		Country[] countries = new Country[]
		{
				new Country("America", "flags/America.jpeg","songs/America.wav", new String[]{"The last democratic nation to abolish slavery", "Our only export is diabetes"}),
				new Country("Russia", "flags/Russia.jpeg","songs/Russia.wav", new String[]{"Cyka blyat", "You wish you were as cool as us."})
		};
		
		
		menuContainer = new JFrame();
		JPanel all = new JPanel();
		//JLabel text = new JLabel("<html><br><br>CONNECT<br>HELP<br>SETTINGS</html>", SwingConstants.CENTER);
		connectButton = new JButton("CONNECT");
		helpButton = new JButton("HELP");
		settingsButton = new JButton("SETTINGS");
		creditButton = new JButton("CREDIT");
		Font font = new Font("8BIT WONDER", 32, 40);
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
		//MusicBox.playSound("/Users/NicolasG/Desktop/Russia.wav");
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
