package Domain;

import java.awt.Image;

public class Board 
{
	private Image map;

	public Board(Image map)
	{
		this.map = map;
	}
	
	public Image getMap() {
		return map;
	}
}
