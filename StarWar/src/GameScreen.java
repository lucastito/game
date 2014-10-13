import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.TransferHandler;

import org.w3c.dom.events.EventListener;

import model.Piece;
import model.Territory;


@SuppressWarnings("serial")
public class GameScreen extends JPanel implements MouseListener{

	PlanetarySystemController planetarySystemController;
	PiecesController piecesController;
	final int TERRITORYMAXSIZE = 80;
	final int PIECEMAXSIZE = 15;
	
	private BufferedImage background;
	private Piece highlightedPiece;
	private Territory actualTerritory;
	
	public GameScreen(String backgroundImage, GameStateInputPort gameState, AttackInputPort attackInputPort, TroopsRedeployInputPort troopsRedeployInputPort) 
	{
		this.addMouseListener(this);
		highlightedPiece = null;
		actualTerritory = null;
		
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

	private void highlightTerritories() {
		if (actualTerritory == null)
		{
			this.planetarySystemController.clearHighlights();
			return;
		}

		planetarySystemController.clearHighlights();			
		int playerId = 0;
		planetarySystemController.getPlanetsToRedeploy(actualTerritory.getName(), playerId);
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