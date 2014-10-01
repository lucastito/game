import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Territory;


@SuppressWarnings("serial")
public class GameScreen extends JPanel implements MouseListener{

	JLabel teste;
	PlanetarySystemController planetarySystemController;
	
	private BufferedImage fundo;
	
	public GameScreen(String imagem, GameStateInputPort gameState) 
	{
		try {
			this.fundo = ImageIO.read(new File(imagem));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.setSize(fundo.getWidth(), fundo.getHeight());
		planetarySystemController = new PlanetarySystemController(gameState);
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(fundo, 0, 0, null);
		for(Territory planet : planetarySystemController.getAllPlanets()){
			try {
				g.drawImage(ImageIO.read(new File(planet.getImagePath())), planet.getxAxisCoordinate(), planet.getyAxisCoordinate(), null);
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
