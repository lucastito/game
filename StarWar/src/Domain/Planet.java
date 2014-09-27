package Domain;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;

public class Planet 
{
	private short id;
	private String name;
	private JLabel boundingBox;
	private Player owner;
	private List pieces;
	
	public Planet(){
		
	}
	
	public Planet(short id, String name, JLabel boundingBox)
	{
		this.id = id;
		this.name = name;
		this.boundingBox = boundingBox;
		this.owner = null;
		this.pieces = new ArrayList<Piece>();
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

	public Player getOwner() {
		return owner;
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
