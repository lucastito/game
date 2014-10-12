public interface TroopsRedeployInputPort 
{
	void possibleTerritoriesToRedeploy(String sourceTerritoryName);
	void numberOfUnitsAllowedToRedeploy(String sourceTerritoryName, String targetTerritoryName);
	void redeployUnits(String sourceTerritoryName, String targetTerritoryName, int numberOfUnits);
}
