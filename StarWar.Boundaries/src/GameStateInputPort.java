import java.util.List;

public interface GameStateInputPort 
{
	List<PieceDTO> getAllPieces();
	List<TerritoryDTO> getAllPlanets();
	void nextPlayerStep();
	String currentPlayerName();
	int currentPlayerStep();
	boolean isPieceFromCurrentPlayer(String playerName);
	boolean isRedeployPhase();
	boolean isAttackPhase();
}
