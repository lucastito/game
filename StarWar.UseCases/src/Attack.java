import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Attack implements AttackInputPort 
{
	IPlanetRepository planetRepository;
	IPlayerRepository playerRepository;

	public Attack(IPlanetRepository planetRepository,
			IPlayerRepository playerRepository) {
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
	public void attack(String attackerPlanetName, String defenderPlanetName,
			int numberOfPieces) {
		Planet attackerPlanet = planetRepository
				.getPlanetByName(attackerPlanetName);
		if (attackerPlanet == null) {
			return;
		}

		Planet defenderPlanet = planetRepository
				.getPlanetByName(defenderPlanetName);
		if (defenderPlanet == null) {
			return;
		}

		Player attacker = playerRepository.getPlayerByName(attackerPlanet
				.getOwnerName());
		if (attacker == null) {
			return;
		}

		Player defender = playerRepository.getPlayerByName(defenderPlanet
				.getOwnerName());
		if (defender == null) {
			return;
		}

		int attackerPieces = quantityBYPlanetName(attacker.getPieces(),
				attackerPlanet.getName());

		int defenderPieces = quantityBYPlanetName(defender.getPieces(),
				defenderPlanetName);

		int remainingAttackerPieces = attackerPieces - numberOfPieces;

		if (attacker.getName() == defender.getName()) {
			return;
		}

		if (numberOfPieces < 1 || numberOfPieces > 3) {
			return;
		}

		if (remainingAttackerPieces < 1) {
			return;
		}

		if (!planetRepository.areNeighbors(attackerPlanetName,
				defenderPlanetName)) {
			return;
		}

		if (defenderPieces < 1) {
			return;
		}

		int[] attackerDice = War.rollDice(numberOfPieces);
		int[] defenderDice;
		int attackerCount = 0;
		int defenderCount = 0;
		/*
		 * Rolagem de dados: 1. Nao importa a quantidade de pecas do atacante
		 * ele só pode atacar usando 3 por vez 2. Nao importa a quantidade de
		 * peças do defensor ele só pode defender usando 3 por vez
		 */
		if (defenderPieces >= 3)
			defenderDice = War.rollDice(3);
		else
			defenderDice = War.rollDice(defenderPieces);

		int counter = 0;
		while ((counter <= attackerDice.length || counter <= defenderDice.length)
				|| attackerPieces > 0
				|| defenderPieces > 0) {

			int maiorAttacker = attackerDice[0];
			int maiorIndiceA = 0;
			for (int i = 0; i < attackerDice.length; i++) {
				if (attackerDice[i] >= maiorAttacker) {
					maiorAttacker = attackerDice[i];
					maiorIndiceA = i;
				}
			}

			int maiorDefender = defenderDice[0];
			int maiorIndiceD = 0;
			for (int i = 0; i < defenderDice.length; i++) {
				if (defenderDice[i] >= maiorDefender) {
					maiorDefender = defenderDice[i];
					maiorIndiceD = i;
				}
			}
			if (maiorAttacker > maiorDefender) {
				attackerCount++;
				playerRepository.removePlayerPiece(defender.getName(), defenderPlanetName, 1);
			} else if (maiorAttacker <= maiorDefender && maiorAttacker != 0 && maiorDefender != 0) {
				defenderCount++;
				playerRepository.removePlayerPiece(attacker.getName(), attackerPlanetName, 1);
			} else
				break;

			counter++;
			attackerDice[maiorIndiceA] = 0;
			defenderDice[maiorIndiceD] = 0;
		}
		
		if (attackerCount > defenderCount)
			War.territoryWon = true;
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
