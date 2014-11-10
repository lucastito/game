import java.util.List;

public interface GameStateInputPort 
{
	List<PieceDTO> getAllPieces();
	List<TerritoryDTO> getAllPlanets();
	boolean nextPlayerStep();
	String currentPlayerName();
	int currentPlayerStep();
	boolean isPieceFromCurrentPlayer(int pieceId);
	boolean isRedeployPhase();
	boolean isAttackPhase();
	void initializePlayers();
}
