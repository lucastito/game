
public interface GameCreationInputPort 
{
	int addPlayerToCurrentGame(PlayerDTO player);
	void setUpPlayersObjective();
	void setUpPlayersTerritoriesAndTerritoriesCards();
}