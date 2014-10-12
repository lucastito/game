import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Piece;
import model.Territory;


@SuppressWarnings("serial")
public class GameScreen extends JPanel implements MouseListener{

	PlanetarySystemController planetarySystemController;
	PiecesController piecesController;
	final int PLANETMAXSIZE = 70;
	
	private BufferedImage background;
	private boolean arePlanetsHighlighted;
	
	public GameScreen(String backgroundImage, GameStateInputPort gameState, AttackInputPort attackInputPort, TroopsRedeployInputPort troopsRedeployInputPort) 
	{
		this.addMouseListener(this);
		arePlanetsHighlighted = false;
		try {
			String path = getClass().getResource(backgroundImage).getPath().toString(); 

			this.background = ImageIO.read(new File(path));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.setSize(background.getWidth(), background.getHeight());
		planetarySystemController = new PlanetarySystemController(gameState, troopsRedeployInputPort, attackInputPort);
		piecesController = new PiecesController();
	}
	
	protected void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		g.drawImage(background, 0, 0, null);
		for(Territory planet : planetarySystemController.getAllPlanets())
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
		String planetName = findPlanetOnClick(e.getX(), e.getY());
		highlightPlanets(planetName);
	}

	private void highlightPlanets(String planetName) {
		if (planetName == null)
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
		planetarySystemController.getActivities(planetName, playerId);
	}

	private String findPlanetOnClick(int x, int y) 
	{
		for(Territory planet : planetarySystemController.getAllPlanets())
		{
			if(x < planet.getxAxisCoordinate() + PLANETMAXSIZE && x > planet.getxAxisCoordinate() 
					&& y < planet.getyAxisCoordinate() + PLANETMAXSIZE && y > planet.getyAxisCoordinate())
				return planet.getName();
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
