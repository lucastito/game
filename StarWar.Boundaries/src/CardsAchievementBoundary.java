import java.util.List;

public interface CardsAchievementBoundary 
{
	List<CardDTO> addTerritoryToPlayerCards(PlayerDTO player, TerritoryDTO territory);
	List<CardDTO> removeTerritoryFromPlayerCards(PlayerDTO player, TerritoryDTO territory);
}
