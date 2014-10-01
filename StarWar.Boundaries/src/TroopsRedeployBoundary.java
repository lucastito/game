import java.util.List;

public interface TroopsRedeployBoundary 
{
	List<TerritoryDTO> possibleTerritoriesToRedeploy(TerritoryDTO sourceTerritory);
	int numberOfUnitsAllowedToRedeploy(TerritoryDTO sourceTerritory, TerritoryDTO targetTerritory);
	BoardDTO redeployUnits(TerritoryDTO sourceTerritory, TerritoryDTO targetTerritory, int numberOfUnits);
}
