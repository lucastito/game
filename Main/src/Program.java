
public class Program 
{
	public static void main(String[] args)
	{
		PlanetRepository planetRepository = new PlanetRepository();
		
		PlayerRepository playerRepository = new PlayerRepository();
		
		
		
		Attack attack = new Attack(planetRepository, playerRepository);
		
		
		
		
		
		GameState gameState = new GameState();		
		gameState.setPlanetRepository(planetRepository);

		gameState.setPlayerRepository(playerRepository);
		
		GameCreation gameCreation = new GameCreation(playerRepository, new ObjectiveCardRepository(planetRepository), planetRepository, new TerritoryCardRepository());

		GameScreenPresenter presenter = new GameScreenPresenter(gameCreation);
		TroopsRedeploy troopsRedeploy = new TroopsRedeploy(presenter, planetRepository, playerRepository);
		presenter.setAttackInputPort(attack);
		presenter.setGameStateInputPort(gameState);
		presenter.setTroopsRedeployInputPort(troopsRedeploy);
		
		InitialScreen is = new InitialScreen(presenter);
		is.getfrmStarwar().setVisible(true);
	}
}
