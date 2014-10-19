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
		initializePlayers();
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
			}
		}
	}

	private void initializePlayers() 
	{
		// Método meramente ilustrativo
		Player player = new Player((short)1, "Leo");
		addPlayer(player);
		
		Piece piece = new Padawan();
		piece.setImagePath("image/padawan.png");
		piece.setXAxisCoordinate((short)40);
		piece.setYAxisCoordinate((short)40);
		addPlayerPiece("Leo", "Trandosha", piece);
		
		piece = new Sith();
		piece.setImagePath("image/sithtrooper.png");
		piece.setXAxisCoordinate((short)20);
		piece.setYAxisCoordinate((short)20);
		
		addPlayerPiece("Leo", "Trandosha", piece);		
	}	
	
	public void setPlanetRepository(IPlanetRepository planetRepository)
	{
		this.planetRepository = planetRepository;
	}
}
