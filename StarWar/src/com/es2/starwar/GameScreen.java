package com.es2.starwar;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class GameScreen extends JPanel implements MouseListener{

	JLabel teste;
	
	public GameScreen()
	{		
		teste = new JLabel("Teste");
		teste.addMouseListener(this);
		add(teste);
		teste.setLocation(100, 100);
	
	}
	
//	public void paintComponent(Graphics g)
//	{
//		g.drawRect(10, 10, 20, 20);
//	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == teste)
		{
			System.out.println("Teste");
		}		
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
