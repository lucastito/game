import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class GameState implements GameStateInputPort {
	IPlanetRepository planetRepository;
	IPlayerRepository playerRepository;
	private List<Player> players;
	private PlayerStep playerStep;
	private int currentRound = 0;
	private Player currentPlayer;
	private int currentPlayerPositionInList = 0;
	int numberOfDistributionUnits;
	private TroopsDistribution troopsDistribution;
	private Attack attack;

	public GameState() {
		playerStep = new PlayerStep();
		currentRound++;
	}

	public void initializePlayers() {
		players = playerRepository.getAllPlayers();
		Collections.reverse(players);
		currentPlayer = players.get(currentPlayerPositionInList);
		numberOfDistributionUnits = currentPlayer.getTerritories().size() / 2;
	}

	public List<TerritoryDTO> getAllPlanets() {
		List<TerritoryDTO> territories = new ArrayList<TerritoryDTO>();
		for (Planet planet : planetRepository.getPlanets().values()) {
			TerritoryDTO territory = Mapper.mapTerritoryDTO(planet);
			territories.add(territory);
		}
		return territories;
	}

	public List<PieceDTO> getAllPieces() {
		List<PieceDTO> pieces = new ArrayList<PieceDTO>();
		for (Piece piece : playerRepository.getAllPieces()) {
			PieceDTO pieceDTO = Mapper.mapPieceDTO(piece);
			pieces.add(pieceDTO);
		}
		return pieces;
	}

	public boolean nextPlayerStep() {
		int allPiecesCount = playerRepository.getAllPieces().size();
		if (allPiecesCount <= 0)
			return false;
		if (playerStep.getCurrentPhase() == PlayerStep.END_OF_TURN) {
			// troca o jogador
			if (currentPlayerPositionInList + 1 < players.size())
				currentPlayerPositionInList++;
			else {
				currentPlayerPositionInList = 0;
				currentRound++;
			}
			int pieceCount = playerRepository
					.getPlayerByName(
							players.get(currentPlayerPositionInList).getName())
					.getPieces().size();
			if (pieceCount >= allPiecesCount)
				return false;
			if (pieceCount > 0) {
				currentPlayer = players.get(currentPlayerPositionInList);
				playerStep = new PlayerStep();
				numberOfDistributionUnits = currentPlayer.getTerritories().size() / 2;
				Set<TerritoryCard> territoryCards = currentPlayer.getTerritoryCards();
				if (territoryCards != null)
				{
					for (TerritoryCard card : currentPlayer.getTerritoryCards())
					{
						for (Planet planet : currentPlayer.getTerritories())
							if (card.getName().toLowerCase().equals(planet.getName().toLowerCase()))
							{
								numberOfDistributionUnits += 2;
							}
					}
				}

				if (currentPlayer.getIsAI() == true) {
					AI.setPlayer(currentPlayer);
					AI.deploy(planetRepository, troopsDistribution,
							numberOfDistributionUnits);
					playerStep.nextStep();
					AI.attack(planetRepository, attack, playerRepository);
					playerStep.nextStep();
					AI.redeploy();
					AI.pickUpCard();
					playerStep.nextStep();
					playerStep.nextStep();
				} else if (currentPlayerPositionInList + 1 < players.size())
					currentPlayerPositionInList++;
				else {
					currentPlayerPositionInList = 0;
				}
			} else if (currentPlayerPositionInList + 1 < players.size())
				currentPlayerPositionInList++;
			else {
				currentPlayerPositionInList = 0;
			}
			nextPlayerStep();
		} else {
			// troca de fase
			playerStep.nextStep();
		}
		return true;
	}

	private boolean isFirstRound() {
		return currentRound == 0;
	}

	public String currentPlayerName() {
		return currentPlayer.getName();
	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public int currentPlayerStep() {
		return playerStep.getCurrentPhase();
	}

	@Override
	public boolean isPieceFromCurrentPlayer(int pieceId) {
		for (Piece piece : currentPlayer.getPieces()) {
			if (pieceId == piece.getId())
				return true;
		}

		return false;
	}

	@Override
	public boolean isRedeployPhase() {
		if (playerStep.getCurrentPhase() == PlayerStep.REDEPLOY_ARMY_PHASE)
			return true;
		return false;
	}

	@Override
	public boolean isAttackPhase() {
		if (playerStep.getCurrentPhase() == PlayerStep.ATTACK_ENEMIES_PHASE)
			return true;
		return false;
	}

	public void setPlanetRepository(IPlanetRepository planetRepository) {
		this.planetRepository = planetRepository;
	}

	public void setPlayerRepository(IPlayerRepository playerRepository) {
		this.playerRepository = playerRepository;
	}

	public int getCurrentRound() {
		return currentRound;
	}

	public BufferedImage getCurrentPlayerObjectiveCardImage() {
		return currentPlayer.getObjectiveCard().getFrontImage();
	}

	public BufferedImage getCardVerseImage() {
		return currentPlayer.getObjectiveCard().getBackImage();
	}

	public BufferedImage[] getCurrentPlayerTerritoryCardsImages(){
		BufferedImage[] images = null;
		try{
		Object[] territoryCards = currentPlayer.getTerritoryCards().toArray();
		images = new BufferedImage[territoryCards.length];
		for (int i = 0; i < territoryCards.length; i++) {
			TerritoryCard tc = (TerritoryCard) territoryCards[i];
			if (tc == null) {

			} else
				images[i] = tc.getFrontImage();
		}

		return images;
		}catch(Exception e){
			return null;
		}
	}
	
	public BufferedImage getTerritoryCardVerseImage(){
		TerritoryCard tc = null;
		try{tc = (TerritoryCard)currentPlayer.getTerritoryCards().toArray()[0];}
		catch(Exception e){tc=null;}
		if(tc==null){
			return null;
		}else
			return tc.getBackImage();
	}

	public void finishTurn() {
		playerStep = new PlayerStep();
		currentRound++;
		if (currentPlayerPositionInList >= players.size() - 1)
			currentPlayerPositionInList = 0;
		else
			currentPlayerPositionInList++;
		currentPlayer = players.get(currentPlayerPositionInList);
	}

	public String getCurrentPlayerName() {
		return currentPlayer.getName();
	}

	public String getCurrentPlayerRace() {
		return currentPlayer.getRace().toString();
	}

	@Override
	public int getUnitsToDistribute() {
		return numberOfDistributionUnits;
	}

	@Override
	public void removeUnitsToDistribute(int numberOfPieces) {
		numberOfDistributionUnits = numberOfDistributionUnits - numberOfPieces;
	}

	@Override
	public boolean isDistributionPhase() {
		if (playerStep.getCurrentPhase() == PlayerStep.RECEIVE_ARMY_PHASE)
			return true;
		return false;
	}

	public void setTroopsDistribution(TroopsDistribution troopsDistribution) {
		this.troopsDistribution = troopsDistribution;
	}

	public int currentPlayerNumberOfOwnedPlanets() {
		return currentPlayer.getTerritories().size();
	}

	public void setAttack(Attack attack) {
		this.attack = attack;
	}
}
