

import java.awt.EventQueue;

import javax.swing.JFrame;

public class GameScreenPresenter 
{
	private GameStateInputPort gameState;
	
	public GameScreenPresenter(GameStateInputPort gameState)
	{
		this.gameState = gameState;
	}
	
	public void show() {
    	EventQueue.invokeLater(new Runnable(){
	    	public void run(){ 
		    	JFrame frame = new JFrame();
		        frame.setLayout(null);
		        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		        frame.setTitle("StarWar");
		        frame.setSize(1366, 768);
		        
		        GameScreen panel = new GameScreen("img.png", gameState);
		
		        frame.add(panel);
		        frame.repaint();
		        frame.validate();
		        frame.setLocationRelativeTo(null);
		        frame.setVisible(true);
		    }
    	});
	}
}
