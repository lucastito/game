package Domain;

import java.awt.Image;
import java.util.List;

public class Board 
{
	
	private PlanetSystem[] planetSystems;
	private Image map;

	public Board(Image map)
	{
		this.map = map;
	}
	
	public Image getMap() {
		return map;
	}
	
	public PlanetSystem[] getPlanetSystems(){
		return this.planetSystems;
	}
}
