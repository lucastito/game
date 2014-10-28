import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class PlayerRepository implements IPlayerRepository
{
	private HashMap<String, Player> players;
	
	public PlayerRepository()
	{
		players = new HashMap<String, Player>();
	}
	
	public List<Player> getAllPlayers()
	{
List<Player> playersList = new ArrayList<Player>();
Player player;
for(String playerName : players.keySet())
		{
			player = getPlayerByName(playerName);
			playersList.add(player);
		}
			
return playersList;
	}
	
	public List<Piece> getAllPieces() 
	{
		ArrayList<Piece> pieces = new ArrayList<Piece>();
		for (Player player : players.values())
			for (Piece piece : player.getPieces())
				pieces.add(piece);
		return pieces;
	}
	
	public Piece getPiece(int pieceId) 
	{
		for (Player player : players.values())
			for (Piece piece : player.getPieces())
				if (piece.getId() == pieceId)
					return piece;
		return null;
	}
	
	public void addPlayer(Player player)
	{
		players.put(player.getName(), player);
	}
	
	public Player getPlayerByName(String name) 
	{
		if (name == null || name.isEmpty())
			return null;
		return players.get(name);
	}
		
	public void addPlayerPiece(String playerName, String planetName, Piece piece)
	{
		if (piece.getId() == 0)
			piece.setId(RandomNumberGenerator.generateRandomNumber());
		piece.setTerritoryName(planetName);
		Player player = getPlayerByName(playerName);
		player.addPiece(piece);
	}
	
	public void removePlayerPiece(String playerName, int pieceId)
	{
		Player player = getPlayerByName(playerName);
		for (Piece piece : player.getPieces())
		{
			if (piece.getId() == pieceId)
			{
				player.getPieces().remove(piece);
				break;
			}
		}
	}
}
