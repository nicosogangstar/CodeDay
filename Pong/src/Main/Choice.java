package Main;
import java.awt.Color;

import javax.swing.JPanel;


public class Choice{
	public static Country p1choice;
	public static Country p2choice;
	public static int selected;
	public static ChoiceKeys ck;
	//init countries
	public static Country[] countries = new Country[]
			{
					new Country("America", "flags/America.jpeg","songs/America.wav", new String[]{"The last democratic nation to abolish slavery", "Our only export is diabetes"}),
					new Country("Russia", "flags/Russia.jpeg","songs/Russia.wav", new String[]{"Cyka blyat", "You wish you were as cool as us."})
			};
	public static JCountry[] jCountries = new JCountry[countries.length];
	
	public static void init(){
		JPanel choiceAll = new JPanel();
		ck = new ChoiceKeys();
		for(int i=0;i<countries.length;i++){
			jCountries[i] = new JCountry(countries[i]);
			choiceAll.add(jCountries[i]);
		}
		ck.setBackground(Color.BLACK);
		ck.setSize(Game.sizeX, Game.sizeY);
		ck.add(choiceAll);
		ck.setVisible(true);
		run();
	}
	public static void run(){
		
	}
}