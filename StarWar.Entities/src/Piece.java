public abstract class Piece 
{
	private short id;
	private String name;
	private short xAxisCoordinate;
	private short yAxisCoordinate;
	private String imagePath;
	private String territoryName;
	private PieceType pieceType;
	
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
}
