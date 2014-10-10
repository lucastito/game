import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import model.Territory;


@SuppressWarnings("serial")
public class GameScreen extends JPanel implements MouseListener{

	PlanetarySystemController planetarySystemController;
	
	private BufferedImage background;
	
	public GameScreen(String backgroundImage, GameStateInputPort gameState) 
	{
		try {
			String path = getClass().getResource(backgroundImage).getPath().toString(); 

			this.background = ImageIO.read(new File(path));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.setSize(background.getWidth(), background.getHeight());
		planetarySystemController = new PlanetarySystemController(gameState);
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(background, 0, 0, null);
		for(Territory planet : planetarySystemController.getAllPlanets()){
			try {
				String path = getClass().getResource(planet.getImagePath()).getPath().toString(); 
				g.drawImage(ImageIO.read(new File(path)), planet.getxAxisCoordinate(), planet.getyAxisCoordinate(), null);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}	

	@Override
	public void mouseClicked(MouseEvent e) {
		
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
