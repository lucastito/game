import java.util.List;

public interface IPlayerRepository 
{
	List<Piece> getAllPieces();
	void addPlayer(Player player);
	Player getPlayerByName(String name);
	void addPlayerPiece(String playerName, String planetName, int numberOfPieces);
	void removePlayerPiece(String playerName, String planetName, int numberOfPieces);
	void addPlayerTerritory(String playerName, String planetName, int numberOfPiecesToRedeploy);
	void revomePlayerTerritory(String playerName, String planetName, int numberOfPiecesRemaining);
	List<Player> getAllPlayers();
	Piece getPiece(int pieceId);
	void restartRepository();
}
