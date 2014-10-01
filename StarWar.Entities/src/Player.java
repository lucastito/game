import java.util.ArrayList;
import java.util.List;

public class Player {
	
	private List<Planet> territories;
	
	
	public Player(){
		territories = new ArrayList<Planet>();
	}
	
	
	public List<Planet> getTerritories(){
		return territories;
	}
	
	public void setTerritories(List<Planet> territories){
		this.territories = territories;
	}
	
	
	public void addTerritory(Planet planet){
		this.territories.add(planet);
	}
	
	public int moveArmy(Planet a, Planet b, List<Piece> pieces){ //Retorna 0 em caso de sucesso, e -1 em caso de falha
		if(a.getPieces().containsAll(pieces) && a.getOwner() == this && b.getOwner() == this){
			List<Piece> newPiecesB = b.getPieces();
			newPiecesB.addAll(pieces);
			b.setPieces(newPiecesB);
			List<Piece> newPiecesA = a.getPieces();
			newPiecesA.removeAll(pieces);
			a.setPieces(newPiecesA);
			return 0;
		}else{
			return -1;
		}
	}

	
	

}