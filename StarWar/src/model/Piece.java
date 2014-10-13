package model;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Piece extends JLabel
{
	private short id;
	private String name;
	private short xAxisCoordinate;
	private short yAxisCoordinate;
	private String imagePath;
	private String territoryName;
	
	public Piece(ImageIcon pieceIcon) {
		super(pieceIcon);
	}

	public short getId() 
	{
		return id;
	}
	
	public void setId(short id) 
	{
		this.id = id;
	}
	
	public String getName() 
	{
		return name;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public short getxAxisCoordinate() 
	{
		return xAxisCoordinate;
	}
	
	public void setxAxisCoordinate(short xAxisCoordinate) 
	{
		this.xAxisCoordinate = xAxisCoordinate;
	}
	
	public short getyAxisCoordinate() 
	{
		return yAxisCoordinate;
	}
	
	public void setyAxisCoordinate(short yAxisCoordinate) 
	{
		this.yAxisCoordinate = yAxisCoordinate;
	}
	
	public String getImagePath() 
	{
		return imagePath;
	}
	
	public void setImagePath(String imagePath) 
	{
		this.imagePath = imagePath;
	}

	public String getTerritoryName() {
		return territoryName;
	}

	public void setTerritoryName(String territoryName) {
		this.territoryName = territoryName;
	}
}
