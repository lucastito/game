import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class MenuScreen extends JPanel implements MouseListener {
	
	GameStateInputPort gameState;
	JLabel nextPlayerArrow = null;
	JLabel playerStepLabel = null;
    
	public MenuScreen(GameStateInputPort gameState)
	{
		setLayout(null);
		this.gameState = gameState;
		try 
		{
			nextPlayerArrow = new JLabel(new ImageIcon(ImageIO.read(new File(getClass().getResource("image/arrow.png").getPath().toString()))));		
			playerStepLabel = new JLabel();
			playerStepLabel.setText("Distribua suas 8 peças");
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		
	    nextPlayerArrow.setBounds(1270, 670, nextPlayerArrow.getIcon().getIconWidth(), nextPlayerArrow.getIcon().getIconHeight());
	    add(nextPlayerArrow);
	    add(playerStepLabel);
	    nextPlayerArrow.addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == nextPlayerArrow)
		{
			gameState.nextPlayerStep();
			String currentPhase = "";
			switch (gameState.currentPlayerStep())
			{
				case 0:
					currentPhase = "Receive Army Phase";
					break;
				case 1:
					currentPhase = "Attack Enemies Phase";
					break;
				case 2:
					currentPhase = "Redeploy Troops Phase";
					break;
				case 3:
					currentPhase = "End Turn";
					break;
			}
			playerStepLabel.setText(gameState.currentPlayerName() + " " + currentPhase);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}  
}
