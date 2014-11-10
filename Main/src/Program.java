
public class Program 
{
	public static void main(String[] args)
	{
		PlanetRepository planetRepository = new PlanetRepository();
		
		PlayerRepository playerRepository = new PlayerRepository();
		playerRepository.setPlanetRepository(planetRepository);
		
		
		Attack attack = new Attack(planetRepository, playerRepository);		
		
		
		
		GameState gameState = new GameState();		
		gameState.setPlanetRepository(planetRepository);

		gameState.setPlayerRepository(playerRepository);		

		GameScreenPresenter presenter = new GameScreenPresenter();
		GameCreation gameCreation = new GameCreation(playerRepository, new ObjectiveCardRepository(planetRepository), planetRepository, new TerritoryCardRepository(), presenter);
		TroopsRedeploy troopsRedeploy = new TroopsRedeploy(presenter, planetRepository, playerRepository);
		presenter.setAttackInputPort(attack);
		presenter.setGameStateInputPort(gameState);
		presenter.setTroopsRedeployInputPort(troopsRedeploy);
		presenter.setGameCreation(gameCreation);
		
		InitialScreen is = new InitialScreen(presenter, gameState);
		is.getfrmStarwar().setVisible(true);
	}
}
