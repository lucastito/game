import java.util.Collections;
import java.util.List;

public class Attack implements AttackInputPort
{
	IPlanetRepository planetRepository;
	IPlayerRepository playerRepository;
	
	public Attack(IPlanetRepository planetRepository, IPlayerRepository playerRepository)
	{
		this.planetRepository = planetRepository;
		this.playerRepository = playerRepository;
	}
	public void possibilitiesOfTerritoriesToAttack(PlayerDTO player)
	{
		if (!isAttackTurn())
			return;
		return;
	}
	
	private boolean isAttackTurn() {
		// TODO Auto-generated method stub
		return false;
	}

	//4 sistema verifica quantas unidades de ataque existem
	//5 se houver somente uma unidade de ataque, 
	//sistema exibe aviso de ataque inválido por insuficiência de unidades de batalha
	public boolean isPlayerAllowedToAttackTerritory(PlayerDTO player, TerritoryDTO territory)
	{
		return true;
	} 
	
	//se (quantidade de unidades - 1) > 3, sistema gera 3 números aleatórios, 
	//caso contrário sistema gera (quantidade de unidades - 1) números de ataque
	public List<Integer> generateAttackingUnits(PlayerDTO player, TerritoryDTO territory)
	{
		throw new UnsupportedOperationException();
	}
	
	//sistema verifica quantas unidades de batalha existem no território que será atacado
	//8 se (quantidade de unidades que serão atacadas) > 3, 
	//sistema gera 3 números de defesa, caso contrário, 
	//sistema gera (quantidade de unidades que serão atacadas) números de defesa
	public List<Integer> generateDefendingUnits(PlayerDTO player, TerritoryDTO territory)
	{
		throw new UnsupportedOperationException();
	}
	
	public int compareUnits(List<Integer> firstUnits, List<Integer> secondUnits)
	{
		int firstScore = 0;
		int secondScore = 0;
		int minorListSize = firstUnits.size() <= secondUnits.size() ? firstUnits.size() : secondUnits.size();
		
		Collections.sort(firstUnits);
		Collections.sort(secondUnits);
		Collections.reverse(firstUnits);
		Collections.reverse(secondUnits);
		
		for (int i = 0; i < minorListSize; i++)
		{
			int result = firstUnits.get(i).compareTo(secondUnits.get(i));
			if (result > 0)
				firstScore++;
			else
				secondScore++;
		}
			
		if (firstScore == secondScore)
			return 0;
		if (firstScore > secondScore)
			return 1;
		return -1;
	}
	
	/*Attack: Planeta atacante, Planeta defensor, e lista de peças que vao atacar no max 3 peças podem atacar */
	public void attack(String attackerPlanetName, String defenderPlanetName, List<PieceDTO> piecesDTO) 
	{
		List<Piece> pieces = Mapper.mapPiece(piecesDTO);
		Planet attackerPlanet = planetRepository.getPlanetByName(attackerPlanetName);
		if (attackerPlanet == null)
		{
			return;
		}
		
		Planet defenderPlanet = planetRepository.getPlanetByName(defenderPlanetName);
		if (defenderPlanet == null)
		{
			return;
		}
		
		Player attacker = playerRepository.getPlayerByName(attackerPlanet.getOwnerName());
		if (attacker == null)
		{
			return;
		}
		
		Player defender = playerRepository.getPlayerByName(defenderPlanet.getOwnerName());
		if (defender == null)
		{
			return;
		}
		
		int remainingAttackerPieces = attacker.getPieces().size() - pieces.size();
		
		if (attacker.getName() == defender.getName())
		{
			return;
		}
		
		if (pieces.size() < 1 || pieces.size() > 3)
		{
			return;
		}		
		
		if (remainingAttackerPieces < 1)
		{
			return;
		}
		
		if (!planetRepository.areNeighbors(attackerPlanetName, defenderPlanetName))
		{
			return;
		}
		
		if (defender.getPieces().size() < 1)
		{
			return;
		} 
		
		int[] attackerDice = War.getInstance().rollDice(pieces.size());
		int[] defenderDice;
		/* Rolagem de dados:
		 * 1. Nao importa a quantidade de pecas do atacante ele só pode atacar usando 3 por vez
		 * 2. Nao importa a quantidade de peças do defensor ele só pode defender usando 3 por vez
		 */
		if(defender.getPieces().size() >= 3)
			defenderDice = War.getInstance().rollDice(3);
		else
			defenderDice = War.getInstance().rollDice(defender.getPieces().size());
				
		int counter = 0;
		while ((counter <= attackerDice.length || counter <= defenderDice.length) || 
				attacker.getPieces().size() > 0 || defender.getPieces().size() > 0) {

			int maiorAttacker = attackerDice[0];
			int maiorIndiceA = 0;
			for (int i = 0; i < attackerDice.length; i++) 
			{
				if (attackerDice[i] >= maiorAttacker) 
				{
					maiorAttacker = attackerDice[i];
					maiorIndiceA = i;
				}
			}

			int maiorDefender = defenderDice[0];
			int maiorIndiceD = 0;
			for (int i = 0; i < defenderDice.length; i++) 
			{
				if (defenderDice[i] >= maiorDefender) 
				{
					maiorDefender = defenderDice[i];
					maiorIndiceD = i;
				}
			}
			if (maiorAttacker > maiorDefender) 
			{
				playerRepository.removePlayerPiece(defender.getName(), defender.getPieces().get(0).getPieceType());
			} 
			else 
				if(maiorAttacker <= maiorDefender && maiorAttacker != 0 && maiorDefender != 0) 
				{
					playerRepository.removePlayerPiece(attacker.getName(), pieces.get(pieces.size() - 1).getPieceType());
					pieces.remove(pieces.size() - 1);
				}
				else
					break;

			counter++;
			attackerDice[maiorIndiceA] = 0;
			defenderDice[maiorIndiceD] = 0;
		}
	}
}
