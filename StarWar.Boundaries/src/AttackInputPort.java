public interface AttackInputPort 
{
	void possibilitiesOfTerritoriesToAttack(PlayerDTO player);
	boolean isPlayerAllowedToAttackTerritory(PlayerDTO player, TerritoryDTO territory);
	boolean attack(String attackerPlanetName, String defenderPlanetName);
}
