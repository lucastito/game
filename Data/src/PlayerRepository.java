import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class PlayerRepository implements IPlayerRepository
{
	private HashMap<String, Player> players;
	private IPlanetRepository planetRepository;
	
	public PlayerRepository(IPlanetRepository planetRepository)
	{
		setPlanetRepository(planetRepository);
		players = new HashMap<String, Player>();
	}
	
	public ArrayList<Player> getAllPlayers()
	{
		ArrayList<Player> playersList = new ArrayList<Player>();
		for(String playerName : players.keySet())
		{
			Player player = getPlayerByName(playerName);
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
		piece.setId(RandomNumberGenerator.generateRandomNumber());
		piece.setTerritoryName(planetName);
		Player player = getPlayerByName(playerName);
		player.addPiece(piece);
		planetRepository.getPlanetByName(planetName).addPiece(piece);
	}
	
	public void removePlayerPiece(String playerName, PieceType type)
	{
		Player player = getPlayerByName(playerName);
		
		for (Piece piece : player.getPieces())
		{
			if (piece.getPieceType().equals(type))
			{
				player.getPieces().remove(piece);
				break;
			}
		}
	}
	
	public void setPlanetRepository(IPlanetRepository planetRepository)
	{
		this.planetRepository = planetRepository;
	}
}
