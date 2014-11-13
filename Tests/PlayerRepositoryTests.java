import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class PlayerRepositoryTests {
	private PlayerRepository playerRepository;
	private IPlanetRepository planetRepository;

	@Before
	public void setUp() throws Exception {
		planetRepository = new PlanetRepository();
		playerRepository = new PlayerRepository();

		Player player = new Player(PlayerRace.CLONE, "Lucas", false);
		playerRepository.addPlayer(player);
	}

	@Test
	public void AddPlayer_AddsPlayer() 
	{
		Piece piece = new Piece();
		Planet planet = planetRepository.getPlanetByName("Trandosha");
		Player player = new Player(PlayerRace.CLONE, "Leonardo", false);
		player.addTerritory(planet);
		player.addPiece(piece);

		playerRepository.addPlayer(player);

		assertEquals("Leonardo", player.getName());
		assertTrue(player.getPieces() != null);
		assertEquals(PlayerRace.CLONE, player.getRace());
		assertTrue(player.getTerritories() != null);
	}

	@Test
	public void GetPlayerByName_WhenPlayerExists_GetsPlayer() 
	{
		Player player = playerRepository.getPlayerByName("Lucas");

		assertEquals("Lucas", player.getName());
	}

	@Test
	public void GetPlayerByName_WhenPLayerDoesNotExist_GetsPlayer() 
	{
		Player player = playerRepository.getPlayerByName("Dilma");
		assertNull(player);
	}
	
	@Test
	public void GetPlayerByName_WhenPLayerNameIsNull_GetsPlayer() 
	{
		Player player = playerRepository.getPlayerByName(null);
		assertNull(player);
	}
	
	@Test
	public void GetPlayerByName_WhenPLayerNameIsEmpty_GetsPlayer() 
	{
		Player player = playerRepository.getPlayerByName("");
		assertNull(player);
	}
	
	@Test
	public void AddPlayerPiece_AddsPlayerPiece() 
	{
		Piece clone = new Piece();
		clone.setPieceType(PieceType.CLONE);
		playerRepository.addPlayerPiece("Lucas", "Trandosha", 1);
		Player player = playerRepository.getPlayerByName("Lucas");
		boolean result = false;
		for (Piece piece : player.getPieces())
			if (piece.getPieceType().equals(PieceType.CLONE))
				result = true;
		
		assertTrue(result);
	} 
	
	@Test
	public void RemovePlayerPiece_RemovesPlayerPiece() 
	{
		Piece clone = new Piece();
		clone.setPieceType(PieceType.CLONE);
		playerRepository.addPlayerPiece("Lucas", "Trandosha", 1);
		playerRepository.removePlayerPiece("Lucas", "Trandosha", 1);
		Player player = playerRepository.getPlayerByName("Lucas");
		
		for (Piece piece : player.getPieces())
			if (piece.getPieceType().equals(PieceType.CLONE))
				assertTrue(false);
	}

	@Test
	public void GetAllPieces_WhenPlayerHasPieces_ReturnsPiecesList() 
	{
		PlayerRepository newPlayerRepository = new PlayerRepository();
		Player playerOne = new Player(PlayerRace.CLONE, "PlayerOne", false);
		playerOne.addPiece(new Piece());
		Player playerTwo = new Player(PlayerRace.DROIDE, "PlayerTwo", false);
		playerTwo.addPiece(new Piece());
		playerTwo.addPiece(new Piece());
		newPlayerRepository.addPlayer(playerOne);
		newPlayerRepository.addPlayer(playerTwo);
		
		assertEquals(3, newPlayerRepository.getAllPieces().size());
	}
	
	@Test
	public void GetAllPLayers_ReturnsPlayersList() 
	{
		PlayerRepository newPlayerRepository = new PlayerRepository();
		Player playerOne = new Player(PlayerRace.CLONE, "PlayerOne", false);
		Player playerTwo = new Player(PlayerRace.DROIDE, "PlayerTwo", false);
		newPlayerRepository.addPlayer(playerOne);
		newPlayerRepository.addPlayer(playerTwo);
		
		assertEquals(2, newPlayerRepository.getAllPlayers().size());
	}
}
