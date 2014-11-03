public interface AttackInputPort 
{
	void possibilitiesOfTerritoriesToAttack(PlayerDTO player);
	boolean isPlayerAllowedToAttackTerritory(PlayerDTO player, TerritoryDTO territory);
	void attack(String attackerPlanetName, String defenderPlanetName, int numberOfPieces);
}
