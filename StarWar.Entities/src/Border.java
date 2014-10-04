public class Border 
{
	private String planetName;
	private String neighborPlanetName;
	
	public Border(String planetName, String neighborPlanetName)
	{
		this.planetName = planetName;
		this.neighborPlanetName = neighborPlanetName;
	}
	
	public String getPlanetName() 
	{
		return planetName;
	}
	
	public String getNeighborPlanetName() 
	{
		return neighborPlanetName;
	}

}
