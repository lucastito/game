import java.util.List;

public interface TroopsRedeployInputPort 
{
	List<TerritoryDTO> possibleTerritoriesToRedeploy(String sourceTerritoryName);
	void numberOfUnitsAllowedToRedeploy(String sourceTerritoryName, String targetTerritoryName);
	void redeployUnits(String sourceTerritoryName, String targetTerritoryName, String pieceType);
}
