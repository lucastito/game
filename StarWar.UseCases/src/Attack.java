import java.util.Collections;
import java.util.List;


public class Attack implements AttackBoundary
{
	public List<TerritoryDTO> possibilitiesOfTerritoriesToAttack(PlayerDTO player)
	{
		throw new UnsupportedOperationException();
	}
	
	//4 sistema verifica quantas unidades de ataque existem
	//5 se houver somente uma unidade de ataque, 
	//sistema exibe aviso de ataque inv�lido por insufici�ncia de unidades de batalha
	public boolean isPlayerAllowToAttackTerritory(PlayerDTO player, TerritoryDTO territory)
	{
		throw new UnsupportedOperationException();
	} 
	
	//se (quantidade de unidades - 1) > 3, sistema gera 3 n�meros aleat�rios, 
	//caso contr�rio sistema gera (quantidade de unidades - 1) n�meros de ataque
	public List<Integer> generateAttackingUnits(PlayerDTO player, TerritoryDTO territory)
	{
		throw new UnsupportedOperationException();
	}
	
	//sistema verifica quantas unidades de batalha existem no territ�rio que ser� atacado
	//8 se (quantidade de unidades que ser�o atacadas) > 3, 
	//sistema gera 3 n�meros de defesa, caso contr�rio, 
	//sistema gera (quantidade de unidades que ser�o atacadas) n�meros de defesa
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

}
