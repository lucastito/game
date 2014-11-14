import java.util.List;

public interface TroopsRedeployInputPort 
{
	List<TerritoryDTO> possibleTerritoriesToRedeploy(String sourceTerritoryName);
	void redeployUnits(String sourceTerritoryName, String targetTerritoryName);
}
