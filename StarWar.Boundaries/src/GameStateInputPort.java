import java.awt.image.BufferedImage;
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
	BufferedImage getCurrentPlayerObjectiveCardImage();
	BufferedImage getCardVerseImage();
	int getCurrentRound();
	void finishTurn();
	String getCurrentPlayerName();
	String getCurrentPlayerRace();
	BufferedImage[] getCurrentPlayerTerritoryCardsImages();
	BufferedImage getTerritoryCardVerseImage();
	int getUnitsToDistribute();
	void removeUnitsToDistribute(int numberOfPieces);
	boolean isDistributionPhase();
}
