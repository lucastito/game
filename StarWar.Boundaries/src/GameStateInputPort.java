import java.util.List;


public interface GameStateInputPort 
{
	BoardDTO getBoard();
	List<TerritoryDTO> getAllPlanets();
	void nextPlayer();
	int currentPlayerId();
}
