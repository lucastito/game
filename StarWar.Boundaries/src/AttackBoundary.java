import java.util.List;

public interface AttackBoundary 
{
	List<TerritoryDTO> possibilitiesOfTerritoriesToAttack(PlayerDTO player);
	boolean isPlayerAllowedToAttackTerritory(PlayerDTO player, TerritoryDTO territory);
	List<Integer> generateAttackingUnits(PlayerDTO player, TerritoryDTO territory);
	List<Integer> generateDefendingUnits(PlayerDTO player, TerritoryDTO territory);
	int compareUnits(List<Integer> firstUnits, List<Integer> secondUnits);
}
