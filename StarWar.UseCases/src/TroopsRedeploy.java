import java.util.ArrayList;
import java.util.List;

public class TroopsRedeploy implements TroopsRedeployInputPort
{
	private GamePresenterOutputPort troopsRedeployOutputPort;
	private IPlanetRepository planetRepository;
	private IPlayerRepository playerRepository;
	
	public TroopsRedeploy(GamePresenterOutputPort troopsRedeployOutputPort, IPlanetRepository planetRepository, IPlayerRepository playerRepository)
	{
		this.troopsRedeployOutputPort = troopsRedeployOutputPort;
		this.planetRepository = planetRepository;
		this.playerRepository = playerRepository;
	}
	public List<TerritoryDTO> possibleTerritoriesToRedeploy(String sourceTerritory) 
	{
		List<Planet> neighborPlanets = 	planetRepository.getNeighborPlanets(sourceTerritory);
		List<TerritoryDTO> territories = new ArrayList<TerritoryDTO>();
		for(Planet neighborPlanet : neighborPlanets)
		{
			if (!neighborPlanet.getOwnerName().equals(sourceTerritory))
				territories.add(Mapper.mapTerritoryDTO(neighborPlanet));
		}
				
		return territories;		
	}

	public void redeployUnits(String sourceTerritory, String targetTerritory) 
	{
		Planet targetPlanet = planetRepository.getPlanetByName(targetTerritory);
		if (!isValidTerritoryToRedeploy(sourceTerritory, targetPlanet.getName(), targetPlanet.getOwnerName()))
		{
			troopsRedeployOutputPort.showReason("Invalid territory to redeploy");
			return;
		}
		
		
		playerRepository.addPlayerPiece(targetPlanet.getOwnerName(), targetTerritory, 1);
		playerRepository.removePlayerPiece(targetPlanet.getOwnerName(), sourceTerritory, 1);
		troopsRedeployOutputPort.show();
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