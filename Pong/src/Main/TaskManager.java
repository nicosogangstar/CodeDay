package Main;

public class TaskManager
{
	public static void main(String[] main)
	{
		Menu n = new Menu("Music");
		Thread thread = new Thread(n);
		thread.start();
		n.init();
		//MusicBox.sourceLine.drain();
		//MusicBox.sourceLine.drain();
		n.running=false;
		MusicBox.sourceLine.stop();
        n.songname = "res/songs/inGame.wav";
        n.running=true;
		Game.init();
		Game.run();
		//MusicBox.playSong("/Users/NicolasG/Desktop/bonfire.mp3");
	}
}
