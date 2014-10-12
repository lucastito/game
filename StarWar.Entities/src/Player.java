import java.util.ArrayList;
import java.util.List;

public class Player {
	
	private int id;
	private String name;
	private List<Planet> territories;
	private List<Piece> pieces;
	
	public Player(int id)
	{
		pieces = new ArrayList<Piece>();
		territories = new ArrayList<Planet>();
	}	
	
	public List<Planet> getTerritories(){
		return territories;
	}
	
	public void setTerritories(List<Planet> territories){
		this.territories = territories;
	}	
	
	public void addTerritory(Planet planet){
		this.territories.add(planet);
	}	
	
	public int getId()
	{
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Piece> getPieces() {
		return pieces;
	}

	public void addPiece(Piece piece) {
		this.pieces.add(piece);
	}	

}
