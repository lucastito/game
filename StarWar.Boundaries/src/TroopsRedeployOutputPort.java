import java.util.List;

public interface TroopsRedeployOutputPort 
{
	void showPossibleTerritoriesToRedeploy(List<TerritoryDTO> territories);
	void showReason(String reason);
	void showRedeployedUnits();
	void showNumberOfUnitsToRedeploy(int numberOfUnits);
}