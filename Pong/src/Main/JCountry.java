package Main;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class JCountry extends JPanel{
	private static final long serialVersionUID = 1L;
	Country country;
	int y;
	Color c;
	public JCountry(Country _kek){
		this.country = _kek;
		add(new JLabel(country.name));
	}
	public void select(){
		c = Color.GREEN;
	}
	public void deselect(){
		c = Color.WHITE;
	}
	@Override
    public void paint(Graphics gr) {
		Graphics2D g = (Graphics2D) gr;
		g.setColor(Color.white);
		try {
			g.drawImage(ImageIO.read(new File(country.flag)), 10, y, null);
		} catch (IOException e) {
			System.out.println("There was an error calling the image of "+country.name+":\n"+e.getMessage());
			//System.out.println(country.flag);
		}
	}
}
