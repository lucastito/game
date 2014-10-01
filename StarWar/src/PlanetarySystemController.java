import java.util.ArrayList;
import java.util.List;

import model.Territory;

public class PlanetarySystemController 
{
	private GameStateInputPort gameState;
	public PlanetarySystemController(GameStateInputPort gameState)
	{
		this.gameState = gameState;
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
}
