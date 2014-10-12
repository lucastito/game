import java.util.ArrayList;
import java.util.List;

public class TroopsRedeploy implements TroopsRedeployInputPort
{
	private TroopsRedeployOutputPort troopsRedeployOutputPort;
	private IPlanetRepository planetRepository;
	
	public TroopsRedeploy(TroopsRedeployOutputPort troopsRedeployOutputPort, IPlanetRepository planetRepository)
	{
		this.troopsRedeployOutputPort = troopsRedeployOutputPort;
		this.planetRepository = planetRepository;
	}
	public void possibleTerritoriesToRedeploy(TerritoryDTO sourceTerritory) 
	{
		if (!isRedeployTurn())
			return;
		List<Planet> neighborPlanets = 	planetRepository.getNeighborPlanets(sourceTerritory.getName());
		
		List<TerritoryDTO> territories = new ArrayList<TerritoryDTO>();
		for(Planet neighborPlanet : neighborPlanets)
		{
			territories.add(TerritoryMapper.mapTerritoryDTO(neighborPlanet));
		}
				
		troopsRedeployOutputPort.showPossibleTerritoriesToRedeploy(territories);		
	}

	private boolean isRedeployTurn() {
		// TODO Auto-generated method stub
		return true;
	}
	public void numberOfUnitsAllowedToRedeploy(TerritoryDTO sourceTerritory, TerritoryDTO targetTerritory) 
	{
		troopsRedeployOutputPort.showNumberOfUnitsToRedeploy(1);
	}

	public void redeployUnits(TerritoryDTO sourceTerritory,	TerritoryDTO targetTerritory, int numberOfUnits) 
	{
		Planet sourcePlanet = planetRepository.getPlanetByName(sourceTerritory.getName());
		Planet targetPlanet = planetRepository.getPlanetByName(targetTerritory.getName());
		if (!isValidTerritoryToRedeploy(sourcePlanet.getName(), targetPlanet.getName(), targetPlanet.getOwner().getName()))
		{
			troopsRedeployOutputPort.showReason("Invalid territory to redeploy");
		}
		
		if (!isValidNumberOfTroopsToRedeploy(sourcePlanet, numberOfUnits))
		{
			troopsRedeployOutputPort.showReason("Invalid number of troops to redeploy");
		}
		
		
		
		troopsRedeployOutputPort.showRedeployedUnits();
	}
	
	public boolean isValidTerritoryToRedeploy(String sourcePlanetName, String targetPlanetName, String targetOwnerName)
	{
		List<Planet> neighborPlanets = 	planetRepository.getNeighborPlanets(sourcePlanetName);
		for(Planet neighborPlanet : neighborPlanets)
		{			
			if(neighborPlanet.getName().equals(targetPlanetName) && !neighborPlanet.getOwner().getName().equals(targetOwnerName))
				return true;
		}
		return false;
	}
	
	private boolean isValidNumberOfTroopsToRedeploy(Planet sourcePlanet, int numberOfUnits)
	{
		return true;
	}

}
