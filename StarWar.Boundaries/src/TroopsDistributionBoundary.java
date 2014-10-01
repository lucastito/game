public interface TroopsDistributionBoundary 
{
	int calculateNumberOfPiecesPlayerIsAllowedToDistribute(PlayerDTO player);
	int maxNumberOfUnitsAPlayerCanPutInATerritory(TerritoryDTO territory);
	BoardDTO distributeTroops(int numberOfPieces, PlayerDTO player, TerritoryDTO territory);
}
