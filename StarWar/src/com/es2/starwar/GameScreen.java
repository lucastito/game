package com.es2.starwar;

import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GameScreen extends JPanel{

	@Override
    public void paint(Graphics g)
    {
    	g.drawRect(10, 10, 100, 100);
    }
}
