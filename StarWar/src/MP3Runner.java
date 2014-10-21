import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import javazoom.jl.player.Player;
public class MP3Runner implements Runnable 
{
	  /**
	   * Objeto para nosso arquivo MP3 a ser tocado
	   */
	  private File mp3;
	  /**
	   * Objeto Player da biblioteca jLayer. Ele tocará o arquivo
	   * MP3
	   */
	  private Player player;
	
	  public MP3Runner(File mp3) {
	    this.mp3 = mp3;
	  }
	
	  public void run() 
	  {
	      try 
	      {
			FileInputStream fis     = new FileInputStream(mp3);
			BufferedInputStream bis = new BufferedInputStream(fis);
			this.player = new Player(bis);
			this.player.play();
	      }
          catch (Exception e) 
	      {
            	System.err.println("Problema ao tocar " + mp3);
	      }
	  }
}