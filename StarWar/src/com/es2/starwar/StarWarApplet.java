package com.es2.starwar;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class StarWarApplet extends JApplet implements Runnable {

	public static final int SCREEN_WIDTH = 800;
	public static final int SCREEN_HEIGHT = 600;
	
	private static final String WINDOW_TITLE = "StarWar";

	private static GameScreen gameScreen = new GameScreen();
	
	/**
     * Main program (used when run as application instead of applet).
     */
	public static void main(String[] args)
	{
		StarWarApplet applet = new StarWarApplet();
		applet.init();
		JFrame window = new JFrame();
		window.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		window.setTitle(WINDOW_TITLE);
		window.setLayout(new BorderLayout());
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		window.add(applet);
		window.setVisible(true);
		
	}
	
	/**
     * Initialize the applet.
     * As recommended, the actual use of Swing components takes place in the
     * event-dispatching thread.
     */
	 public void init () {
        try {SwingUtilities.invokeAndWait(this);}
        catch (Exception e) {
        	System.err.println("Initialization failure");
//	        	e.printStackTrace();
        }
    }

	 /**
	 * Set up the applet's GUI.
	 * As recommended, the init method executes this in the event-dispatching
	 * thread.
	 */
	@Override
	public void run() {
		this.add(gameScreen);
	}
}
