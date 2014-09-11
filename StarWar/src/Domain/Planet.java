package Domain;

import javax.swing.JLabel;

public class Planet 
{
	private short id;
	private String name;
	private JLabel boundingBox;
	
	public Planet(short id, String name, JLabel boundingBox)
	{
		this.id = id;
		this.name = name;
		this.boundingBox = boundingBox;
	}
	
	public short getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public JLabel getBoundingBox() {
		return boundingBox;
	}
}
