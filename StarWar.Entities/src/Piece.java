public class Piece 
{
	private int id = 0;
	private short xAxisCoordinate;
	private short yAxisCoordinate;
	private String imagePath;
	private String territoryName;
	private PieceType pieceType;
	private String ownerName;
	
	public int getId() 
	{
		return id;
	}
	
	public void setId(int id) 
	{
		this.id = id;
	}
	
	public short getXAxisCoordinate() 
	{
		return xAxisCoordinate;
	}
	
	public void setXAxisCoordinate(short xAxisCoordinate) 
	{
		this.xAxisCoordinate = xAxisCoordinate;
	}
	
	public short getYAxisCoordinate() 
	{
		return yAxisCoordinate;
	}
	
	public void setYAxisCoordinate(short yAxisCoordinate) 
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

	public PieceType getPieceType() {
		return pieceType;
	}

	public void setPieceType(PieceType pieceType) {
		this.pieceType = pieceType;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
}
