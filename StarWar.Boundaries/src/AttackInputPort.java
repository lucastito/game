import java.util.List;

public interface AttackInputPort 
{
	void possibilitiesOfTerritoriesToAttack(PlayerDTO player);
	boolean isPlayerAllowedToAttackTerritory(PlayerDTO player, TerritoryDTO territory);
	void attack(String attackerPlanetName, String defenderPlanetName, List<PieceDTO> piecesDTO);
}
