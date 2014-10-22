import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;

public class SetUpGameScreenPresenter 
{
    SetUpGameScreen setUpScreenPanel;
    JFrame frame;
    
    public SetUpGameScreenPresenter()
    {
    	frame = new JFrame();
    	setUpScreenPanel = new SetUpGameScreen("image/setupgamescreenbackground.jpg");
    }
    
	public void show() 
	{
		EventQueue.invokeLater(new Runnable(){
	    	public void run(){ 		    	
		        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        frame.setTitle("StarWar");
		        frame.setSize(1366, 768);
		        
		        setUpScreenPanel.setLayout(new BorderLayout());
			    
			    frame.add(setUpScreenPanel);
			    
		        frame.repaint();
		        frame.validate();
		        frame.setLocationRelativeTo(null);
		        frame.setVisible(true);
		    }
    	});
	}
}
