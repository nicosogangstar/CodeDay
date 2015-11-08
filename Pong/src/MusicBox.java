import java.io.*;
import sun.audio.*;
import com.sun.media.sound.*;
public class MusicBox
{

	public static void playSong(String filename)
	{
		try
		{
			WaveFileReader wfv = new WaveFileReader();
			
		    // open the sound file as a Java input stream
		    InputStream in = new FileInputStream(filename);
		    wfv.getAudioInputStream(in);
		    // create an audiostream from the inputstream
		    // play the audio clip with the audioplayer class
		    AudioPlayer.player.start(in);
		} 
		catch (Exception e)
		{
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	}
}
