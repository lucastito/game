import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class GameCreation implements GameCreationInputPort {

	private List<Player> players;
	private IPlayerRepository playerRepository;
	private IObjectiveCardRepository objectiveCardRepository;
	private ITerritoryCardRepository territoryCardRepository;
	private IPlanetRepository planetRepository;
	
	public GameCreation(IPlayerRepository playerRepository, IObjectiveCardRepository objectiveCardRepository, IPlanetRepository planetRepository, ITerritoryCardRepository territoryCardRepository){
		this.playerRepository = playerRepository;
		this.planetRepository = planetRepository;
		this.objectiveCardRepository = objectiveCardRepository;
		this.territoryCardRepository = territoryCardRepository;
		this.players = new ArrayList<Player>();
		this.playerRepository.restartRepository();
	}
	
	public int addPlayerToCurrentGame(PlayerDTO playerDto){
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
			
		Player player = new Player(convertedRace, playerDto.getName());
		playerRepository.addPlayer(player);
		this.players.add(player);
		return 0;
	}
	
	public void setUpPlayersObjective(){
		for (int i = 0; i < players.size(); i++) {
			players.get(i).setObjectiveCard(objectiveCardRepository.getObjectiveCard(players.get(i)));
		}
	}
	
	public void setUpPlayersTerritoriesAndTerritoriesCards(){
		DistributeTerritoryCard.distributeTerritories(players.get(0), players.get(1), planetRepository);
		DistributeTerritoryCard.distributTerritoryCards(players.get(0), territoryCardRepository);
		DistributeTerritoryCard.distributTerritoryCards(players.get(1), territoryCardRepository);
	}
	
	public void printInfo(){
		System.out.println("Players:");
		System.out.println(players.size());
		System.out.println("Players Repo:");
		System.out.println(playerRepository.getAllPlayers().size());
		System.out.println("Cartas Objetivo:");
		System.out.println(objectiveCardRepository.getObjectiveCard(players.get(0)).getName());
		System.out.println(objectiveCardRepository.getObjectiveCard(players.get(1)).getName());
		System.out.println("Cartas Territorio:");
		System.out.println(territoryCardRepository.getTerritoryCardAmount());
		System.out.println("Planetas:");
		System.out.println(planetRepository.getPlanetRepositorySize());
	}
	
}
