import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class GameStateTests 
{
	PlanetRepository planetRepository = new PlanetRepository();
	@Test
	public void GetAllPlanets_MustReturnAllTerritoryDTOs() 
	{
		GameState gameState = new GameState();
		gameState.setPlanetRepository(planetRepository);
		List<TerritoryDTO> territories = gameState.getAllPlanets();
		assertEquals(34, territories.size());
	}
	
	@Test
	public void GetAllPlanets_MustReturnFilledTerritoryDTOs() 
	{
		GameState gameState = new GameState();
		gameState.setPlanetRepository(planetRepository);
		List<TerritoryDTO> territories = gameState.getAllPlanets();
		TerritoryDTO territory = territories.get(0);
		Planet planet = planetRepository.getPlanetByName(territory.getName());
		
		assertEquals(planet.getName(), territory.getName());
		assertEquals(planet.getId(), territory.getId());
		assertEquals(planet.getXAxisCoordinate(), territory.getxAxisCoordinate());
		assertEquals(planet.getYAxisCoordinate(), territory.getyAxisCoordinate());
		assertEquals(planet.getImagePath(), territory.getImagePath());
	}
	
	@Test
	public void GetAllPieces_MustReturnAllPieceDTOs() 
	{
		PlayerRepository playerRepository = new PlayerRepository();
		playerRepository.addPlayer(new Player(PlayerRace.CLONE, "Leo", false));
		playerRepository.addPlayerPiece("Leo", "Trandosha", 1);
		playerRepository.addPlayerPiece("Leo", "Coruscant", 1);
		GameState gameState = new GameState();
		gameState.setPlayerRepository(playerRepository);
		List<PieceDTO> pieces = gameState.getAllPieces();
		assertEquals(2, pieces.size());
	}
	
	@Test
	public void GetAllPieces_MustReturnFilledPieceDTOs() 
	{
		PlayerRepository playerRepository = new PlayerRepository();
		playerRepository.addPlayer(new Player(PlayerRace.CLONE, "Leo", false));
		Piece clone = new Piece();
		clone.setId((short) 1);
		clone.setImagePath("123");
		clone.setOwnerName("Leo");
		clone.setPieceType(PieceType.CLONE);
		clone.setTerritoryName("Trandosha");
		clone.setXAxisCoordinate((short) 10);
		clone.setYAxisCoordinate((short) 10);
		playerRepository.addPlayerPiece("Leo", "Coruscant", 1);
		
		GameState gameState = new GameState();
		gameState.setPlayerRepository(playerRepository);
		List<PieceDTO> pieces = gameState.getAllPieces();
		PieceDTO piece = pieces.get(0);
		assertEquals(clone.getYAxisCoordinate(), piece.getyAxisCoordinate());
		assertEquals(clone.getXAxisCoordinate(), piece.getxAxisCoordinate());
		assertEquals(clone.getTerritoryName(), piece.getTerritoryName());
		assertEquals(clone.getPieceType().toString(), piece.getPieceType());
		assertEquals(clone.getOwnerName(), piece.getOwnerName());
		assertEquals(clone.getImagePath(), piece.getImagePath());
		assertEquals(clone.getId(), piece.getId());
	}
	
	@Test
	public void NextStep_ModifiesCurrentStep() 
	{
		PlayerRepository playerRepository = new PlayerRepository();
		playerRepository.addPlayer(new Player(PlayerRace.CLONE, "Leo", false));
		playerRepository.addPlayer(new Player(PlayerRace.DROIDE, "Lucas", false));
		playerRepository.addPlayerPiece("Leo", "Trandosha", 1);
		playerRepository.addPlayerPiece("Lucas", "Trandosha", 1);
		GameState gameState = new GameState();
		gameState.setPlayerRepository(playerRepository);
		
		assertEquals(PlayerStep.RECEIVE_ARMY_PHASE, gameState.currentPlayerStep());
		gameState.nextPlayerStep();
		assertEquals(PlayerStep.ATTACK_ENEMIES_PHASE, gameState.currentPlayerStep());
	}
	
	@Test
	public void CurrentStep_ReturnsCurrentStep() 
	{
		GameState gameState = new GameState();
		assertEquals(PlayerStep.RECEIVE_ARMY_PHASE, gameState.currentPlayerStep());
	}
	
	@Test
	public void CurrentPlayerName_InFirstTurn_ReturnsCurrentPlayerName() 
	{
		PlayerRepository playerRepository = new PlayerRepository();
		playerRepository.addPlayer(new Player(PlayerRace.CLONE, "Leo", false));
		playerRepository.addPlayer(new Player(PlayerRace.DROIDE, "Lucas", false));
		GameState gameState = new GameState();
		gameState.setPlayerRepository(playerRepository);
		String name = gameState.currentPlayerName();
		assertEquals("Lucas", name);
	}
	
	@Test
	public void CurrentPlayerName_InSecondTurn_ReturnsCurrentPlayerName() 
	{
		PlayerRepository playerRepository = new PlayerRepository();
		playerRepository.addPlayer(new Player(PlayerRace.CLONE, "Leo", false));
		playerRepository.addPlayer(new Player(PlayerRace.DROIDE, "Lucas", false));
		playerRepository.addPlayerPiece("Leo", "Trandosha", 1);
		playerRepository.addPlayerPiece("Lucas", "Trandosha", 1);
		GameState gameState = new GameState();
		gameState.setPlayerRepository(playerRepository);
		gameState.nextPlayerStep();
		gameState.nextPlayerStep();
		gameState.nextPlayerStep();
		gameState.nextPlayerStep();
		gameState.nextPlayerStep();
		String name = gameState.currentPlayerName();
		assertEquals("Leo", name);
	}
	
	@Test
	public void CurrentROund_ReturnsCurrentRound() 
	{
		PlayerRepository playerRepository = new PlayerRepository();
		playerRepository.addPlayer(new Player(PlayerRace.CLONE, "Leo", false));
		playerRepository.addPlayer(new Player(PlayerRace.DROIDE, "Lucas", false));
		playerRepository.addPlayerPiece("Leo", "Trandosha", 1);
		playerRepository.addPlayerPiece("Lucas", "Trandosha", 1);
		
		GameState gameState = new GameState();
		gameState.setPlayerRepository(playerRepository);
		gameState.nextPlayerStep();
		gameState.nextPlayerStep();
		gameState.nextPlayerStep();
		gameState.nextPlayerStep();
		gameState.nextPlayerStep();
		gameState.nextPlayerStep();
		gameState.nextPlayerStep();
		gameState.nextPlayerStep();
		gameState.nextPlayerStep();
		
		int round = gameState.getCurrentRound();
		assertEquals(2, round);
	}
	
	@Test
	public void IsPieceFromCurrentPlayer_WhenCurrentPlayerIsTheOwner_ReturnTrue() 
	{
		PlayerRepository playerRepository = new PlayerRepository();
		playerRepository.addPlayer(new Player(PlayerRace.CLONE, "Leo", false));
		playerRepository.addPlayer(new Player(PlayerRace.DROIDE, "Lucas", false));
		playerRepository.addPlayerPiece("Lucas", "Trandosha", 1);
		
		GameState gameState = new GameState();
		gameState.setPlayerRepository(playerRepository);
				
		assertTrue(gameState.isPieceFromCurrentPlayer(playerRepository.getPlayerByName("Lucas").getPieces().iterator().next().getId()));

	}
	
	@Test
	public void IsPieceFromCurrentPlayer_WhenCurrentPlayerIsNotTheOwner_ReturnFalse() 
	{
		PlayerRepository playerRepository = new PlayerRepository();
		playerRepository.addPlayer(new Player(PlayerRace.CLONE, "Leo", false));
		playerRepository.addPlayer(new Player(PlayerRace.DROIDE, "Lucas", false));
		playerRepository.addPlayerPiece("Leo", "Trandosha", 1);
		GameState gameState = new GameState();
		gameState.setPlayerRepository(playerRepository);
		
		assertFalse(gameState.isPieceFromCurrentPlayer(playerRepository.getPlayerByName("Leo").getPieces().iterator().next().getId()));
	}
	
	@Test
	public void IsAttackPhase_WhenCurrentPhaseIsAttackPhase_ReturnsTrue() 
	{
		PlayerRepository playerRepository = new PlayerRepository();
		playerRepository.addPlayer(new Player(PlayerRace.CLONE, "Leo", false));
		playerRepository.addPlayer(new Player(PlayerRace.DROIDE, "Lucas", false));
		playerRepository.addPlayerPiece("Leo", "Trandosha", 1);
		playerRepository.addPlayerPiece("Lucas", "Trandosha", 1);
		GameState gameState = new GameState();
		gameState.setPlayerRepository(playerRepository);
		
		gameState.nextPlayerStep();
		assertTrue(gameState.isAttackPhase());
	}
	
	@Test
	public void IsAttackPhase_WhenCurrentPhaseIsNotAttackPhase_ReturnsFalse() 
	{
		GameState gameState = new GameState();
		assertFalse(gameState.isAttackPhase());
	}
	
	@Test
	public void IsRedeployPhase_WhenCurrentPhaseIsRedeployPhase_ReturnsTrue() 
	{
		PlayerRepository playerRepository = new PlayerRepository();
		playerRepository.addPlayer(new Player(PlayerRace.CLONE, "Leo", false));
		playerRepository.addPlayer(new Player(PlayerRace.DROIDE, "Lucas", false));
		playerRepository.addPlayerPiece("Leo", "Trandosha", 1);
		playerRepository.addPlayerPiece("Lucas", "Trandosha", 1);
		GameState gameState = new GameState();
		gameState.setPlayerRepository(playerRepository);
		
		gameState.nextPlayerStep();
		gameState.nextPlayerStep();
		assertTrue(gameState.isRedeployPhase());
	}
	
	@Test
	public void IsRedeployPhase_WhenCurrentPhaseIsNotRedeployPhase_ReturnsFalse() 
	{
		GameState gameState = new GameState();
		assertFalse(gameState.isRedeployPhase());
	}
}
