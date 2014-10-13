
public class Program 
{
	public static void main(String[] args)
	{
		PlanetRepository planetRepository = new PlanetRepository();
		
		PlayerRepository playerRepository = new PlayerRepository(planetRepository);
		
		Attack attack = new Attack();
		
		GameScreenPresenter presenter = new GameScreenPresenter();
		
		TroopsRedeploy troopsRedeploy = new TroopsRedeploy(presenter, planetRepository);
		
		GameState gameState = new GameState();		
		gameState.setPlanetRepository(planetRepository);
		gameState.setPlayerRepository(playerRepository);
		
		presenter.setAttackInputPort(attack);
		presenter.setGameStateInputPort(gameState);
		presenter.setTroopsRedeployInputPort(troopsRedeploy);
		
		presenter.show();
	}
}
