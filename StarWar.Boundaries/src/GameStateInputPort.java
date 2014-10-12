import java.util.List;

public interface GameStateInputPort 
{
	List<PieceDTO> getAllPieces();
	List<TerritoryDTO> getAllPlanets();
	void nextPlayerStep();
	int currentPlayerId();
	int currentPlayerStep();
}
