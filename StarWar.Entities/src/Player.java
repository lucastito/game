import java.util.ArrayList;
import java.util.List;

public class Player {
	
	public static final int PADAWAN = 0;
	public static final int SITH = 1;
	public static final int CLONE = 2;
	public static final int DROIDE = 3;
	public static final int WOOKIEE = 4;
	public static final int TRANDOSHAN = 5;


	private int id;
	private String name;
	private List<Planet> territories;
	private List<Piece> pieces;
	private int character;
	
	public Player(int id)
	{
		pieces = new ArrayList<Piece>();
		territories = new ArrayList<Planet>();

	}

	public int moveArmy(Planet a, Planet b, List<Piece> pieces) { // Retorna 0
																	// em caso
																	// de
																	// sucesso,
																	// e -1 em
																	// caso de
																	// falha
		if (a.getPieces().containsAll(pieces) && a.getOwnerName().equals(this.name)
				&& b.getOwnerName().equals(this.name)) {
			List<Piece> newPiecesB = b.getPieces();
			newPiecesB.addAll(pieces);
			b.setPieces(newPiecesB);
			List<Piece> newPiecesA = a.getPieces();
			newPiecesA.removeAll(pieces);
			a.setPieces(newPiecesA);
			return 0;
		} else {
			return -1;
		}
	}

	
	/*Attack: Planeta atacante, Planeta defensor, e lista de peças que vao atacar no max 3 peças podem atacar */
	public void attack(Planet attacker, Planet defender, List<Piece> pieces) {
		List<Piece> remainingPieces = new ArrayList<Piece>(attacker.getPieces());
		remainingPieces.removeAll(pieces);
		
		/* Condicoes para ser possivel o ataque:
		 * 1. O atacante e o defensor tem que ser jogadores diferentes
		 * 2. O atacante tem que atacar com de 1 a 3 peças
		 * 3. O atacante tem que ficar com uma peça de defesa em seu territorio
		 * 4. O planeta atacante e defensor tem que ter fronteira em comum
		 * 5. O defensor tem que ter no minimo uma peça para defender
		 */
		if (!attacker.getOwnerName().equals(defender.getOwnerName()) && pieces.size() >= 1
				&& pieces.size() <= 3 && remainingPieces.size() >= 1
				&& attacker.hasBorderWith(defender)
				&& defender.getPieces().size() >= 1) {
			int[] attackerDice = War.getInstance().rollDice(pieces.size());
			int[] defenderDice;
			/* Rolagem de dados:
			 * 1. Nao importa a quantidade de pecas do atacante ele só pode atacar usando 3 por vez
			 * 2. Nao importa a quantidade de peças do defensor ele só pode defender usando 3 por vez
			 */
			if(defender.getPieces().size() >= 3)
				defenderDice = War.getInstance().rollDice(3);
			else
				defenderDice = War.getInstance().rollDice(
					defender.getPieces().size());
			/*--------- Inicio do Log de teste -------*/ 
			System.out.println("Atacante:");
			for(int i = 0; i < attackerDice.length; i++){
				System.out.print(attackerDice[i]+" ");
			}
			System.out.println("\nDefensor:");
			for(int i = 0; i < defenderDice.length; i++){
				System.out.print(defenderDice[i]+" ");
			}
			System.out.println("");
			/* ---------- Fim do Log de Teste --------------- */
			
			int counter = 0;
			while ((counter <= attackerDice.length
					|| counter <= defenderDice.length) || attacker.getPieces().size() > 0 || defender.getPieces().size() > 0) {

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
					defender.removePiece(defender.getPieces().get(
							defender.getPieces().size() - 1));//Esta tirando a ultima peça da lista
					
					System.out.println("Atacante tirou "+maiorAttacker+" Defensor tirou "+maiorDefender);//Log
					System.out.println("Defensor perdeu uma peça");//Log
				} else if(maiorAttacker <= maiorDefender && maiorAttacker != 0 && maiorDefender != 0) {
					attacker.removePiece(attacker.getPieces().get(
							attacker.getPieces().size() - 1));//Esta tirando a ultima peça da lista
					pieces.remove(pieces.size()-1);
					System.out.println("Atacante tirou "+maiorAttacker+" Defensor tirou "+maiorDefender);//Log
					System.out.println("Atacante perdeu uma peça");//Log
				}else
					break;

				counter++;
				attackerDice[maiorIndiceA] = 0;
				defenderDice[maiorIndiceD] = 0;
			}

		}
	}

	public List<Planet> getTerritories() {
		return territories;
	}

	public void setTerritories(List<Planet> territories) {
		this.territories = territories;
	}

	public void addTerritory(Planet planet) {
		this.territories.add(planet);
		planet.setOwnerName(this.name);
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public List<Piece> getPieces() {
		return pieces;
	}

	public void addPiece(Piece piece) {
		this.pieces.add(piece);
	}

	public int getCharacter() {
		return character;
	}

	public void setCharacter(int character) {
		this.character = character;
	}


}


