import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import model.Territory;

public class PlanetarySystemController 
{
	private GameStateInputPort gameState;
	private TroopsRedeployInputPort troopsRedeployInputPort;
	
	public PlanetarySystemController(GameStateInputPort gameState, TroopsRedeployInputPort troopsRedeployInputPort, AttackInputPort attackInputPort)
	{
		this.troopsRedeployInputPort = troopsRedeployInputPort;
		this.gameState = gameState;
	}
	
	public List<Territory> getAllTerritories()
	{
		List<Territory> territories = new ArrayList<Territory>();
		for(TerritoryDTO territoryDTO : gameState.getAllPlanets())
		{
			Territory territory = new Territory(new ImageIcon(getClass().getResource(territoryDTO.getImagePath()).getPath().toString()));
			territory.setId(territoryDTO.getId());
			territory.setName(territoryDTO.getName());
			territory.setxAxisCoordinate(territoryDTO.getxAxisCoordinate());
			territory.setyAxisCoordinate(territoryDTO.getyAxisCoordinate());
			territory.setImagePath(territoryDTO.getImagePath());
			territory.setOwnerName(territoryDTO.getOwnerName());
			territories.add(territory);
		}
		return territories;
	}

	public List<Territory> getTerritoriesToRedeploy(String territoryName, int playerId) 
	{
		troopsRedeployInputPort.possibleTerritoriesToRedeploy(territoryName);
		
		PlayerDTO player = new PlayerDTO();
		player.setId(playerId);
		
		List<TerritoryDTO> territoriesDTO = troopsRedeployInputPort.possibleTerritoriesToRedeploy(territoryName);
		
		List<Territory> territories = new ArrayList<Territory>();
		for(TerritoryDTO territoryDTO : territoriesDTO)
		{
			Territory territory = new Territory(new ImageIcon(getClass().getResource(territoryDTO.getImagePath()).getPath().toString()));
			territory.setId(territoryDTO.getId());
			territory.setName(territoryDTO.getName());
			territory.setxAxisCoordinate(territoryDTO.getxAxisCoordinate());
			territory.setyAxisCoordinate(territoryDTO.getyAxisCoordinate());
			territory.setImagePath(territoryDTO.getImagePath());
			territory.setOwnerName(territoryDTO.getOwnerName());
			territories.add(territory);
		}
		return territories;
	}
}
