import java.util.ArrayList;
import java.util.List;


public class Planet 
{
	private short id;
	private String name;
	private String ownerName;
	private short xAxisCoordinate;
	private short yAxisCoordinate;
	private String imagePath;
	private List<Border> internalBorders;	
	private List<Border> externalBorders;	
	private List<Border> allBorders;	

	public Planet(short id, String name, short xAxisCoordinate, short yAxisCoordinate, String imagePath)
	{
		this.id = id;
		this.name = name;
		this.xAxisCoordinate = xAxisCoordinate;
		this.yAxisCoordinate = yAxisCoordinate;
		this.imagePath = imagePath;
		
		ownerName = "";
		internalBorders = new ArrayList<Border>();
		externalBorders = new ArrayList<Border>();
		allBorders = new ArrayList<Border>();
	}
	
	public boolean hasBorderWith(Planet b){
		
		int bBordersCount = b.getBorders().size();
		for(int i = 0; i < bBordersCount; i++){
			if(this.getBorders().contains(b.getBorders().get(i))){
				return true;
			}
		}
		return false;
	}
	
	public short getId() {
		return id;
	}
	
	public String getName() {
		return name;
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

	public void addInternalBorder(Border border)
	{
		internalBorders.add(border);
		allBorders.add(border);
	}
	
	public void addExternalBorder(Border border)
	{
		externalBorders.add(border);
		allBorders.add(border);
	}
	
	public List<Border> getBorders()
	{
		return allBorders;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
}

