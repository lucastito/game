import java.util.ArrayList;
import java.util.List;


public class GameCreation implements GameCreationInputPort 
{
	private IPlayerRepository playerRepository;
	private IObjectiveCardRepository objectiveCardRepository;
	private ITerritoryCardRepository territoryCardRepository;
	private IPlanetRepository planetRepository;
	private GamePresenterOutputPort outputPort;
	
	public GameCreation(IPlayerRepository playerRepository, IObjectiveCardRepository objectiveCardRepository, IPlanetRepository planetRepository, ITerritoryCardRepository territoryCardRepository, GamePresenterOutputPort outputPort){
		this.playerRepository = playerRepository;
		this.planetRepository = planetRepository;
		this.objectiveCardRepository = objectiveCardRepository;
		this.territoryCardRepository = territoryCardRepository;
		//this.playerRepository.restartRepository();
		this.outputPort = outputPort;
	}
	
	public int addPlayerToCurrentGame(PlayerDTO playerDto)
	{
//		PADAWAN,
//		SITH,
//		CLONE,
//		DROIDE,
//		WOOKIEE,
//		TRANDOSHAN
		String race = playerDto.getRace();
		PlayerRace convertedRace;
		if(race.equals("PADAWAN"))
			convertedRace = PlayerRace.PADAWAN;
		else if(race.equals("SITH"))
			convertedRace = PlayerRace.SITH;
		else if(race.equals("CLONE"))
			convertedRace = PlayerRace.CLONE;
		else if(race.equals("DROIDE"))
			convertedRace = PlayerRace.DROIDE;
		else if(race.equals("WOOKIEE"))
			convertedRace = PlayerRace.WOOKIEE;
		else if(race.equals("TRANDOSHAN"))
			convertedRace = PlayerRace.TRANDOSHAN;
		else
			return -1;
			
		Player player = new Player(convertedRace, playerDto.getName(), playerDto.isAI());
		playerRepository.addPlayer(player);
		this.playerRepository.addPlayer(player);		
		return 0;
	}
	
	public void setUpPlayersObjective(){
		for (Player player : playerRepository.getAllPlayers()) 
			playerRepository.getPlayerByName(player.getName()).setObjectiveCard(objectiveCardRepository.getObjectiveCard(player));
	}
	
	public void setUpPlayersTerritoriesAndTerritoriesCards(){
		DistributeTerritoryCard.distributeTerritories(playerRepository, planetRepository);
		
//		for (Player player : playerRepository.getAllPlayers()) 
//			DistributeTerritoryCard.distributTerritoryCards(player, territoryCardRepository);
		
		outputPort.show();
	}	
}
