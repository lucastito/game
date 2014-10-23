import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GameScreen extends JPanel implements MouseListener{

	PlanetarySystemController planetarySystemController;
	PiecesController piecesController;
	final int TERRITORYMAXSIZE = 80;
	final int PIECEMAXSIZE = 15;
	
	private BufferedImage background;
	
	public GameScreen(String backgroundImage, GameStateInputPort gameState, AttackInputPort attackInputPort, TroopsRedeployInputPort troopsRedeployInputPort) 
	{
		this.addMouseListener(this);
		
		try {
			String path = getClass().getResource(backgroundImage).getPath().toString(); 

			this.background = ImageIO.read(new File(path));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.setSize(background.getWidth(), background.getHeight());
		planetarySystemController = new PlanetarySystemController(gameState, troopsRedeployInputPort, attackInputPort);
		piecesController = new PiecesController(gameState, troopsRedeployInputPort);
	}
	
	protected void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		g.drawImage(background, 0, 0, null);	
	}	

	@Override
	public void mouseClicked(MouseEvent e) 
	{

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}