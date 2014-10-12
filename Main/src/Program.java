
public class Program 
{
	public static void main(String[] args)
	{
		PlanetRepository planetRepository = new PlanetRepository();
		GameState gameState = new GameState(planetRepository);
		Attack attack = new Attack();
		GameScreenPresenter presenter = new GameScreenPresenter();
		TroopsRedeploy troopsRedeploy = new TroopsRedeploy(presenter, planetRepository);
		
		presenter.setAttackInputPort(attack);
		presenter.setGameStateInputPort(gameState);
		presenter.setTroopsRedeployInputPort(troopsRedeploy);
		
		presenter.show();
	}
}
