package com.es2.starwar;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Domain.Planet;
import Repositories.PlanetRepository;

@SuppressWarnings("serial")
public class GameScreen extends JPanel implements MouseListener{

	JLabel teste;
	PlanetRepository repository;
	
	private BufferedImage fundo;

	public GameScreen(String imagem) {
		try {
			this.fundo = ImageIO.read(new File(imagem));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setSize(fundo.getWidth(), fundo.getHeight());
		repository = new PlanetRepository();
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(fundo, 0, 0, null);
		for(Planet p : repository.getPlanets().values()){
			g.drawImage(p.getImage(), p.getX(), p.getY(), null);
		}
	}

	
	
	public static void main(String[] args) {
    	EventQueue.invokeLater(new Runnable(){
	    	public void run(){ 
		    	JFrame frame = new JFrame();
		        frame.setLayout(null);
		        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		        frame.setTitle("StarWar");
		        frame.setSize(1366, 768);
		        
		        GameScreen panel = new GameScreen("image/img.png");
		
		        frame.add(panel);
		        frame.repaint();
		        frame.validate();
		        frame.setLocationRelativeTo(null);
		        frame.setVisible(true);
		    }
    	});
	}
	
//	public void paintComponent(Graphics g)
//	{
//		g.drawRect(10, 10, 20, 20);
//	}

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
