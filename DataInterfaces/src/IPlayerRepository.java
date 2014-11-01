import java.util.List;

public interface IPlayerRepository 
{
	List<Piece> getAllPieces();
	void addPlayer(Player player);
	Player getPlayerByName(String name);
	void addPlayerPiece(String playerName, String planetName, Piece piece);
	void removePlayerPiece(String playerName, int pieceId);
	List<Player> getAllPlayers();
	Piece getPiece(int pieceId);
	void restartRepository();
}
