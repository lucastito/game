import java.util.List;


public class TroopsRedeploy implements TroopsRedeployBoundary
{
	public List<TerritoryDTO> possibleTerritoriesToRedeploy(TerritoryDTO sourceTerritory) 
	{
		throw new UnsupportedOperationException();
	}

	public int numberOfUnitsAllowedToRedeploy(TerritoryDTO sourceTerritory, TerritoryDTO targetTerritory) 
	{
		throw new UnsupportedOperationException();
	}

	public BoardDTO redeployUnits(TerritoryDTO sourceTerritory,	TerritoryDTO targetTerritory, int numberOfUnits) 
	{
		Planet sourcePlanet = TerritoryMapper.mapPlanet(sourceTerritory);
		Planet targetPlanet = TerritoryMapper.mapPlanet(targetTerritory);
		if (!isValidTerritory(sourcePlanet, targetPlanet))
		{
			BoardDTO board = new BoardDTO();
			board.setReason("Invalid Territory");
			return board;
		}
		
		if (!isValidNumberOfTroopsToRedeploy(sourcePlanet, numberOfUnits))
		{
			BoardDTO board = new BoardDTO();
			board.setReason("Invalid Number Of Troops To Redeploy");
			return board;
		}
		
		throw new UnsupportedOperationException();
	}
	
	private boolean isValidTerritory(Planet sourcePlanet, Planet targetPlanet)
	{
		throw new UnsupportedOperationException();
	}
	
	private boolean isValidNumberOfTroopsToRedeploy(Planet sourcePlanet, int numberOfUnits)
	{
		throw new UnsupportedOperationException();
	}

}
