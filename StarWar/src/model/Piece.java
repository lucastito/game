package model;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Piece extends JLabel
{
	private static final long serialVersionUID = 1L;
	private short id;
	private short xAxisCoordinate;
	private short yAxisCoordinate;
	private String imagePath;
	private String territoryName;
	private String pieceType;
	private String ownerName;
	
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

	public String getPieceType() {
		return pieceType;
	}

	public void setPieceType(String pieceType) {
		this.pieceType = pieceType;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
}
