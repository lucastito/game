
public class Program 
{
	public static void main(String[] args)
	{
		GameScreenPresenter presenter = new GameScreenPresenter(new GameState(new PlanetRepository()));
		
		presenter.show();
	}
}
