import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class PlayerRepository implements IPlayerRepository
{
	private HashMap<String, Player> players;
	private IPlanetRepository planetRepository;
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
		
	public void addPlayerPiece(String playerName, String planetName, int numberOfPieces)
	{
		for (int i = 0 ; i < numberOfPieces; i++)
		{
			Player player = getPlayerByName(playerName);
			Piece piece = new Piece();
			if (piece.getId() == 0)
				piece.setId(RandomNumberGenerator.generateRandomNumber());
			piece.setTerritoryName(planetName);
			
			switch (player.getRace())
			{
				case PADAWAN:
					piece.setImagePath("image/padawan.png");
					piece.setPieceType(PieceType.JEDI);
					break;
				case TRANDOSHAN:
					piece.setImagePath("image/trandoshan.png");
					piece.setPieceType(PieceType.TRANDOSHAN);
					break;
				case SITH:
					piece.setImagePath("image/sithtrooper.png");
					piece.setPieceType(PieceType.SITH);
					break;
				case CLONE:
					piece.setImagePath("image/clone.png");
					piece.setPieceType(PieceType.CLONE);
					break;
				case DROIDE:
					piece.setImagePath("image/droide.png");
					piece.setPieceType(PieceType.DROIDE);
					break;
				case WOOKIEE:
					piece.setImagePath("image/wookiee.png");
					piece.setPieceType(PieceType.WOOKIEE);
					break;
			}
			planetRepository.getPlanetByName(planetName).setOwnerName(playerName);
			piece.setXAxisCoordinate(planetRepository.getPlanetByName(planetName).getXAxisCoordinate());
			piece.setYAxisCoordinate(planetRepository.getPlanetByName(planetName).getYAxisCoordinate());
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

	public IPlanetRepository getPlanetRepository() {
		return planetRepository;
	}

	public void setPlanetRepository(IPlanetRepository planetRepository) {
		this.planetRepository = planetRepository;
	}
	
}
