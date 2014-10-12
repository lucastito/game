import java.util.ArrayList;
import java.util.List;

import model.Territory;

public class PlanetarySystemController 
{
	private GameStateInputPort gameState;
	private TroopsRedeployInputPort troopsRedeployInputPort;
	private AttackInputPort attackInputPort;
	private GameScreenPresenter gameScreenPresenter;
	
	public PlanetarySystemController(GameStateInputPort gameState, TroopsRedeployInputPort troopsRedeployInputPort, AttackInputPort attackInputPort)
	{
		this.troopsRedeployInputPort = troopsRedeployInputPort;
		this.gameState = gameState;
		this.attackInputPort = attackInputPort;
		gameScreenPresenter = new GameScreenPresenter();
	}
	
	public List<Territory> getAllPlanets()
	{
		List<Territory> territories = new ArrayList<Territory>();
		for(TerritoryDTO territoryDTO : gameState.getAllPlanets())
		{
			Territory territory = new Territory();
			territory.setId(territoryDTO.getId());
			territory.setName(territoryDTO.getName());
			territory.setxAxisCoordinate(territoryDTO.getxAxisCoordinate());
			territory.setyAxisCoordinate(territoryDTO.getyAxisCoordinate());
			territory.setImagePath(territoryDTO.getImagePath());
			territories.add(territory);
		}
		return territories;
	}

	public void getActivities(String planetName, int playerId) 
	{
		TerritoryDTO territory = new TerritoryDTO();
		territory.setName(planetName);
		troopsRedeployInputPort.possibleTerritoriesToRedeploy(territory);
		
		PlayerDTO player = new PlayerDTO();
		player.setId(playerId);
		
		attackInputPort.possibilitiesOfTerritoriesToAttack(player);
	}

	public void clearHighlights() 
	{
		gameScreenPresenter.clearGameScreen();
	}
}
