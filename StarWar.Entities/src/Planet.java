import java.util.ArrayList;
import java.util.List;

public class Planet 
{
	private short id;
	private String name;
	private Player owner;
	private List<Piece> pieces;
	private short xAxisCoordinate;
	private short yAxisCoordinate;
	private String imagePath;

	public Planet(short id, String name, short xAxisCoordinate, short yAxisCoordinate, String imagePath)
	{
		this.id = id;
		this.name = name;
		this.xAxisCoordinate = xAxisCoordinate;
		this.yAxisCoordinate = yAxisCoordinate;
		this.imagePath = imagePath;
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

	public short getXAxisCoordinate() {
		return xAxisCoordinate;
	}

	public short getYAxisCoordinate() {
		return yAxisCoordinate;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setOwner(Player owner) {
		owner.addTerritory(this);
		this.owner = owner;
		
	}
	
	public List<Piece> getPieces(){
		return this.pieces;
	}
	
	public void setPieces(List<Piece> pieces){
		this.pieces = pieces;
	}
	
	public void addPiece(Piece piece){
		this.pieces.add(piece);
	}
	
}