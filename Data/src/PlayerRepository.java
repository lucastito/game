import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class PlayerRepository implements IPlayerRepository
{
	private HashMap<String, Player> players;
	
	public PlayerRepository()
	{
		players = new HashMap<String, Player>();
		initializePlayers();
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
		
	public void addPlayerPiece(String playerName, String planetName, int numberOfPieces)
	{
		for (int i = 0 ; i < numberOfPieces; i++)
		{
			Piece piece = new Piece();
			if (piece.getId() == 0)
				piece.setId(RandomNumberGenerator.generateRandomNumber());
			piece.setTerritoryName(planetName);
			Player player = getPlayerByName(playerName);
			player.addPiece(piece);
		}		
	}
	
	public void removePlayerPiece(String playerName, String planetName, int numberOfPieces)
	{
		//Player player = getPlayerByName(playerName);
		//for (int i = 0 ; i < player.getPieces().size(); i++)
		//{
		////	if (player.getPieces().)
		//	player.getPieces().remove(player.get);
		//}	
	}
	
	public void restartRepository(){
		players = new HashMap<String, Player>();
	}
	
	private void initializePlayers() {
		Player player = new Player(PlayerRace.PADAWAN,"Player 1");
		this.addPlayer(player);
//		player = new Player(PlayerRace.CLONE,"Player 2");
//		this.addPlayer(player);
//		player = new Player(PlayerRace.DROIDE,"Player 3");
//		this.addPlayer(player);
//		player = new Player(PlayerRace.SITH,"Player 4");
//		this.addPlayer(player);
//		player = new Player(PlayerRace.TRANDOSHAN,"Player 5");
//		this.addPlayer(player);
//		player = new Player(PlayerRace.WOOKIEE,"Player 6");
//		this.addPlayer(player);
	}
}
