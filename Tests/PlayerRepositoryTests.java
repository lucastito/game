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
		playerRepository = new PlayerRepository(planetRepository);

		Player player = new Player((short) 2, "Lucas");
		playerRepository.addPlayer(player);
	}

	@Test
	public void AddPlayer_AddsPlayer() {
		Piece piece = new Clone();
		Planet planet = planetRepository.getPlanetByName("Trandosha");
		Player player = new Player((short) 3, "Leonardo");
		player.addTerritory(planet);
		player.addPiece(piece);
		player.setRace(PlayerRace.CLONE);

		playerRepository.addPlayer(player);

		assertEquals("Leonardo", player.getName());
		assertTrue(player.getPieces() != null);
		assertEquals(PlayerRace.CLONE, player.getRace());
		assertTrue(player.getTerritories() != null);
	}

	@Test
	public void GetPlayerByName_WhenPlayerExists_GetsPlayer() {
		Player player = playerRepository.getPlayerByName("Lucas");

		assertEquals("Lucas", player.getName());
	}

	@Test
	public void GetPlayerByName_WhenDoesNotExist_GetsPlayer() {
		Player player = playerRepository.getPlayerByName("Dilma");

		assertNull(player);
	}

	@Test
	public void GetAllPieces_WhenPlayerHasNoPieces_ReturnsEmptyList() {

	}

	@Test
	public void GetAllPieces_WhenPlayerHasPieces_ReturnsPiecesList() {

	}
}
