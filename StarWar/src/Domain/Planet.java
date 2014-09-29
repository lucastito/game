package Domain;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;

public class Planet 
{
	private short id;
	private String name;
	private Player owner;
	private List pieces;
	private short x;
	private short y;
	private Image image;

	public Planet(short id, String name, short x, short y, Image image)
	{
		this.id = id;
		this.name = name;
		this.x = x;
		this.y = y;
		this.image = image;
		this.owner = null;
		this.pieces = new ArrayList<Piece>();
	}
	
	public short getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	public Player getOwner() {
		return owner;
	}

	public short getX() {
	return x;
}

public short getY() {
	return y;
}

public Image getImage() {
	return image;
}

	public void setOwner(Player owner) {
		owner.addTerritory(this);
		this.owner = owner;
		
	}
	
	public List getPieces(){
		return this.pieces;
	}
	
	public void setPieces(List pieces){
		this.pieces = pieces;
	}
	
	public void addPiece(Piece piece){
		this.pieces.add(piece);
	}
	
}
