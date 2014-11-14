import java.util.Iterator;
import java.util.Set;

public class Attack implements AttackInputPort 
{
	GamePresenterOutputPort gamePresenter;
	IPlanetRepository planetRepository;
	IPlayerRepository playerRepository;

	public Attack(GamePresenterOutputPort gamePresenter, IPlanetRepository planetRepository,
			IPlayerRepository playerRepository) {
		this.gamePresenter = gamePresenter;
		this.planetRepository = planetRepository;
		this.playerRepository = playerRepository;
	}

	public void possibilitiesOfTerritoriesToAttack(PlayerDTO player) {
		// if (!isAttackTurn())
		// return;
		return;
	}

	// 4 sistema verifica quantas unidades de ataque existem
	// 5 se houver somente uma unidade de ataque,
	// sistema exibe aviso de ataque inválido por insuficiência de unidades de
	// batalha
	public boolean isPlayerAllowedToAttackTerritory(PlayerDTO player,
			TerritoryDTO territory) {
		return true;
	}

	/*
	 * Attack: Planeta atacante, Planeta defensor, e lista de peças que vao
	 * atacar no max 3 peças podem atacar
	 */
	public boolean attack(String attackerPlanetName, String defenderPlanetName) {
		Planet attackerPlanet = planetRepository
				.getPlanetByName(attackerPlanetName);
		
		if (attackerPlanet == null) {
			return false;
		}

		Planet defenderPlanet = planetRepository
				.getPlanetByName(defenderPlanetName);

		if (defenderPlanet == null) {
			return false;
		}

		Player attacker = playerRepository.getPlayerByName(attackerPlanet
				.getOwnerName());
		
		if (attacker == null) {
			return false;
		}

		Player defender = playerRepository.getPlayerByName(defenderPlanet
				.getOwnerName());
		
		if (defender == null) {
			return false;
		}

		int attackerPieces = quantityBYPlanetName(attacker.getPieces(),
				attackerPlanet.getName());

		int defenderPieces = quantityBYPlanetName(defender.getPieces(),
				defenderPlanetName);

		int numberOfPieces;
		
		
		
		if (attackerPieces > 3)
		{
			numberOfPieces = 3;
		}
		else
		{
			numberOfPieces = attackerPieces - 1;
		}
		
		int remainingAttackerPieces = attackerPieces - numberOfPieces;
		
		if (attacker.getName() == defender.getName()) {
			return false;
		}

		if (numberOfPieces < 1 || numberOfPieces > 3) {
			return false;
		}
		
		if (remainingAttackerPieces < 1) {
			return false;
		}

		if (!planetRepository.areNeighbors(attackerPlanetName,
				defenderPlanetName)) {
			return false;
		}
		
		if (defenderPieces < 1) {
			return false;
		}
		
		int[] attackerDice = War.rollDice(numberOfPieces);
		int[] defenderDice;
		/*
		 * Rolagem de dados: 1. Nao importa a quantidade de pecas do atacante
		 * ele só pode atacar usando 3 por vez 2. Nao importa a quantidade de
		 * peças do defensor ele só pode defender usando 3 por vez
		 */
		if (defenderPieces >= 3)
			defenderDice = War.rollDice(3);
		else
			defenderDice = War.rollDice(defenderPieces);

		
		gamePresenter.printDices(attackerDice, defenderDice);
		int counter = 0;
		while ((counter <= attackerDice.length || counter <= defenderDice.length)
				|| attackerPieces > 0
				|| defenderPieces > 0) {

			int bestAttacker = attackerDice[0];
			int gratesteAttackerIndex = 0;
			for (int i = 0; i < attackerDice.length; i++) {
				if (attackerDice[i] >= bestAttacker) {
					bestAttacker = attackerDice[i];
					gratesteAttackerIndex = i;
				}
			}

			int bestDefender = defenderDice[0];
			int greatestDefenseIndex = 0;
			for (int i = 0; i < defenderDice.length; i++) {
				if (defenderDice[i] >= bestDefender) {
					bestDefender = defenderDice[i];
					greatestDefenseIndex = i;
				}
			}
			if (defenderPieces != 0 || attackerPieces != 1)
			{
				if (bestAttacker > bestDefender) {
					playerRepository.removePlayerPiece(defender.getName(), defenderPlanetName, 1);
					defenderPieces--;
				} else if (bestAttacker <= bestDefender && bestAttacker != 0 && bestDefender != 0) {
					playerRepository.removePlayerPiece(attacker.getName(), attackerPlanetName, 1);
					attackerPieces--;
					numberOfPieces--;
				} else
					break;

			}
			
			counter++;
			attackerDice[gratesteAttackerIndex] = 0;
			defenderDice[greatestDefenseIndex] = 0;
		}
		
		War war = War.getInstance();
		
		if(defenderPieces <= 0)
		{
			defenderPieces = 0;
			war.setTerritoryWon(true);
			playerRepository.addPlayerTerritory(attacker.getName(), defenderPlanetName, numberOfPieces);
			playerRepository.removePlayerPiece(attacker.getName(), attackerPlanetName, numberOfPieces);
			playerRepository.revomePlayerTerritory(defender.getName(), defenderPlanetName, defenderPieces);
			gamePresenter.show();
			return true;
		}
		
		gamePresenter.show();
		return false;
	}

	public int quantityBYPlanetName(Set<Piece> pieces, String planetName) {
		int quantityByPlanet = 0;

		Iterator<Piece> piecesIterator = pieces.iterator();

		while (piecesIterator.hasNext()) {
			if (piecesIterator.next().getTerritoryName()
					.equalsIgnoreCase(planetName)) {
				quantityByPlanet++;
			}
		}
		return quantityByPlanet;
	}
}
