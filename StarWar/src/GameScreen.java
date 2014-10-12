import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import model.Piece;
import model.Territory;


@SuppressWarnings("serial")
public class GameScreen extends JPanel implements MouseListener{

	PlanetarySystemController planetarySystemController;
	PiecesController piecesController;
	final int TERRITORYMAXSIZE = 70;
	final int PIECEMAXSIZE = 15;
	
	private BufferedImage background;
	private boolean arePlanetsHighlighted;
	private Piece highlightedPiece;
	private Territory actualTerritory;
	
	public GameScreen(String backgroundImage, GameStateInputPort gameState, AttackInputPort attackInputPort, TroopsRedeployInputPort troopsRedeployInputPort) 
	{
		this.addMouseListener(this);
		arePlanetsHighlighted = false;
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
		for(Territory planet : planetarySystemController.getAllTerritories())
		{
			try 
			{
				String path = getClass().getResource(planet.getImagePath()).getPath().toString(); 
				g.drawImage(ImageIO.read(new File(path)), planet.getxAxisCoordinate(), planet.getyAxisCoordinate(), null);
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		
		for(Piece piece : piecesController.getAllPieces())
		{
			try 
			{
				String path = getClass().getResource(piece.getImagePath()).getPath().toString(); 
				g.drawImage(ImageIO.read(new File(path)), piece.getxAxisCoordinate(), piece.getyAxisCoordinate(), null);
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
	}	

	@Override
	public void mouseClicked(MouseEvent e) 
	{
		if (actualTerritory == null)
		{
			actualTerritory = findTerritoryOnClick(e.getX(), e.getY());
			if (actualTerritory != null)
			{
				highlightTerritories();
				if (arePlanetsHighlighted)
					highlightedPiece = findPieceOnClick(e.getX(), e.getY());
			}				
		}			
		else
		{
			if (highlightedPiece != null)
			{
				Territory nextTerritory = findTerritoryOnClick(e.getX(), e.getY());
				piecesController.redeployTroops(actualTerritory.getName(), nextTerritory.getName());
				actualTerritory = nextTerritory;
				highlightTerritories();
				if (arePlanetsHighlighted)
					highlightedPiece = findPieceOnClick(e.getX(), e.getY());
			}
			else
			{
				highlightTerritories();
				if (arePlanetsHighlighted)
					highlightedPiece = findPieceOnClick(e.getX(), e.getY());
			}
		}
	}

	private void highlightTerritories() {
		if (actualTerritory == null)
		{
			this.planetarySystemController.clearHighlights();
			arePlanetsHighlighted = false;
			return;
		}
		
		if (arePlanetsHighlighted)
		{
			planetarySystemController.clearHighlights();	
		}
		
		arePlanetsHighlighted = true;			
		int playerId = 0;
		planetarySystemController.getPlanetsToRedeploy(actualTerritory.getName(), playerId);
	}

	private Territory findTerritoryOnClick(int x, int y) 
	{
		for(Territory territory : planetarySystemController.getAllTerritories())
		{
			if(x < territory.getxAxisCoordinate() + TERRITORYMAXSIZE && x > territory.getxAxisCoordinate() 
					&& y < territory.getyAxisCoordinate() + TERRITORYMAXSIZE && y > territory.getyAxisCoordinate())
				return territory;
		}		
		return null;
	}
	
	private Piece findPieceOnClick(int x, int y) 
	{
		for(Piece piece : piecesController.getAllPieces())
		{
			if(x < piece.getxAxisCoordinate() + PIECEMAXSIZE && x > piece.getxAxisCoordinate() 
					&& y < piece.getyAxisCoordinate() + PIECEMAXSIZE && y > piece.getyAxisCoordinate())
				return piece;
		}		
		return null;
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
