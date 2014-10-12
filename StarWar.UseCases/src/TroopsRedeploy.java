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
	public void possibleTerritoriesToRedeploy(String sourceTerritory) 
	{
		if (!isRedeployTurn())
			return;
		List<Planet> neighborPlanets = 	planetRepository.getNeighborPlanets(sourceTerritory);
		
		List<TerritoryDTO> territories = new ArrayList<TerritoryDTO>();
		for(Planet neighborPlanet : neighborPlanets)
		{
			territories.add(Mapper.mapTerritoryDTO(neighborPlanet));
		}
				
		troopsRedeployOutputPort.showPossibleTerritoriesToRedeploy(territories);		
	}

	private boolean isRedeployTurn() {
		// TODO Auto-generated method stub
		return true;
	}
	public void numberOfUnitsAllowedToRedeploy(String sourceTerritory, String targetTerritory) 
	{
		troopsRedeployOutputPort.showNumberOfUnitsToRedeploy(1);
	}

	public void redeployUnits(String sourceTerritory, String targetTerritory, int numberOfUnits) 
	{
		Planet sourcePlanet = planetRepository.getPlanetByName(sourceTerritory);
		Planet targetPlanet = planetRepository.getPlanetByName(targetTerritory);
		if (!isValidTerritoryToRedeploy(sourcePlanet.getName(), targetPlanet.getName(), targetPlanet.getOwnerName()))
		{
			troopsRedeployOutputPort.showReason("Invalid territory to redeploy");
		}
		targetPlanet.setPieces(sourcePlanet.getPieces());		
		troopsRedeployOutputPort.showRedeployedUnits();
	}
	
	public boolean isValidTerritoryToRedeploy(String sourcePlanetName, String targetPlanetName, String targetOwnerName)
	{
		List<Planet> neighborPlanets = 	planetRepository.getNeighborPlanets(sourcePlanetName);
		for(Planet neighborPlanet : neighborPlanets)
		{			
			if(neighborPlanet.getName().equals(targetPlanetName) && !sourcePlanetName.equals(targetOwnerName))
				return true;
		}
		return false;
	}
}
