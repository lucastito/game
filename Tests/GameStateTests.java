import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class GameStateTests 
{
	@Test
	public void GetAllPlanets_MustReturnAllTerritoryDTOs() 
	{
		GameState gameState = new GameState();
		gameState.setPlanetRepository(new PlanetRepository());
		List<TerritoryDTO> territories = gameState.getAllPlanets();
		assertEquals(34, territories.size());
	}
	
	@Test
	public void GetAllPlanets_MustReturnFilledTerritoryDTOs() 
	{
		PlanetRepository planetRepository =new PlanetRepository();
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
		PlayerRepository playerRepository = new PlayerRepository(new PlanetRepository());
		playerRepository.addPlayer(new Player(PlayerRace.CLONE, "Leo"));
		playerRepository.addPlayerPiece("Leo", "Trandosha", new Sith());
		playerRepository.addPlayerPiece("Leo", "Coruscant", new Clone());
		GameState gameState = new GameState();
		gameState.setPlayerRepository(playerRepository);
		List<PieceDTO> pieces = gameState.getAllPieces();
		assertEquals(2, pieces.size());
	}
	
	@Test
	public void GetAllPieces_MustReturnFilledPieceDTOs() 
	{
		PlayerRepository playerRepository = new PlayerRepository(new PlanetRepository());
		playerRepository.addPlayer(new Player(PlayerRace.CLONE, "Leo"));
		Clone clone = new Clone();
		clone.setId((short) 1);
		clone.setImagePath("123");
		clone.setOwnerName("Leo");
		clone.setPieceType(PieceType.CLONE);
		clone.setTerritoryName("Trandosha");
		clone.setXAxisCoordinate((short) 10);
		clone.setYAxisCoordinate((short) 10);
		playerRepository.addPlayerPiece("Leo", "Coruscant", clone);
		
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
		GameState gameState = new GameState();
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
	public void CurrentPlayerName_ReturnsCurrentPlayerName() 
	{
		fail("Not yet implemented");
	}
	
	@Test
	public void IsPieceFromCurrentPlayer_WhenCurrentPlayerIsTheOwner_ReturnTrue() 
	{
		fail("Not yet implemented");
	}
	
	@Test
	public void IsPieceFromCurrentPlayer_WhenCurrentPlayerIsNotTheOwner_ReturnFalse() 
	{
		fail("Not yet implemented");
	}
	
	@Test
	public void IsAttackPhase_WhenCurrentPhaseIsAttackPhase_ReturnsTrue() 
	{
		GameState gameState = new GameState();
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
		GameState gameState = new GameState();
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
