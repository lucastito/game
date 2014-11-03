package model;

import javax.swing.Icon;
import javax.swing.JLabel;

public class Territory extends JLabel
{
	private static final long serialVersionUID = 1L;

	public Territory(Icon icon)
	{
		super(icon);
	}
	private short id;
	private String name;
	private short xAxisCoordinate;
	private short yAxisCoordinate;
	private String ownerName;
	private String imagePath;
	
	public short getId() {
		return id;
	}
	
	public void setId(short id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public short getxAxisCoordinate() {
		return xAxisCoordinate;
	}
	
	public void setxAxisCoordinate(short xAxisCoordinate) {
		this.xAxisCoordinate = xAxisCoordinate;
	}
	
	public short getyAxisCoordinate() {
		return yAxisCoordinate;
	}
	
	public void setyAxisCoordinate(short yAxisCoordinate) {
		this.yAxisCoordinate = yAxisCoordinate;
	}
	
	public String getImagePath() {
		return imagePath;
	}
	
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
}
