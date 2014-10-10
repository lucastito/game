import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class MenuScreen extends JPanel implements MouseListener {
	
	GameStateInputPort gameState;
	JLabel nextPlayerArrow = null;
    
	public MenuScreen(GameStateInputPort gameState)
	{
		setLayout(null);
		this.gameState = gameState;
		try {
			nextPlayerArrow = new JLabel(new ImageIcon(ImageIO.read(new File(getClass().getResource("image/arrow.png").getPath().toString()))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    nextPlayerArrow.setBounds(1270, 670, nextPlayerArrow.getIcon().getIconWidth(), nextPlayerArrow.getIcon().getIconHeight());
	    add(nextPlayerArrow);
	    nextPlayerArrow.addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == nextPlayerArrow)
		{
			gameState.nextPlayer();
			System.out.println(gameState.currentPlayerId());
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