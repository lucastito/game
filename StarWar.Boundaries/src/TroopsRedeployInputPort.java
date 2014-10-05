public interface TroopsRedeployInputPort 
{
	void possibleTerritoriesToRedeploy(TerritoryDTO sourceTerritory);
	void numberOfUnitsAllowedToRedeploy(TerritoryDTO sourceTerritory, TerritoryDTO targetTerritory);
	BoardDTO redeployUnits(TerritoryDTO sourceTerritory, TerritoryDTO targetTerritory, int numberOfUnits);
}
