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

	private void initializePlayers() 
	{
		// Método meramente ilustrativo
		Piece piece = new Sith();
		piece.setImagePath("image/sithtrooper.png");
		piece.setXAxisCoordinate((short)20);
		piece.setYAxisCoordinate((short)20);
		Player player = new Player(1);
		player.setName("Leo");
		addPlayer(player);
		addPlayerPiece("Leo", "Trandosha", piece);		
	}	
	
	public void setPlanetRepository(IPlanetRepository planetRepository)
	{
		this.planetRepository = planetRepository;
	}
}
