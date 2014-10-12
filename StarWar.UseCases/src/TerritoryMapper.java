public class TerritoryMapper 
{
	public static Planet mapPlanet(TerritoryDTO territory) 
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	public static TerritoryDTO mapTerritoryDTO(Planet planet) 
	{
		TerritoryDTO territory = new TerritoryDTO();
		territory.setId(planet.getId());
		territory.setImagePath(planet.getImagePath());
		territory.setName(planet.getName());
		territory.setxAxisCoordinate(planet.getXAxisCoordinate());
		territory.setyAxisCoordinate(planet.getYAxisCoordinate());
		
		return territory;
	}
}
