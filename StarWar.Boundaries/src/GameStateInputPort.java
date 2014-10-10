import java.util.List;


public interface GameStateInputPort 
{
	BoardDTO getBoard();
	List<TerritoryDTO> getAllPlanets();
	void nextPlayerStep();
	int currentPlayerId();
	int currentPlayerStep();
}
