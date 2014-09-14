package Domain;

import java.util.ArrayList;
import java.util.List;

public class Player {
	
	
	Player(){
		
	}
	
	
	public List getTerritories(){
		List territories = new ArrayList();
		int planetSystemAmount = War.getInstance().getBoard().getPlanetSystems().length;
		int planetAmount;
		Planet territory;
		for(int i=0;i<planetSystemAmount;i++){
			planetAmount = War.getInstance().getBoard().getPlanetSystems()[i].Planets.length;
			for(int j=0;j<planetAmount;j++){
				territory = War.getInstance().getBoard().getPlanetSystems()[i].Planets[j];
				if(territory.getOwner() == this){
					territories.add(territory);
				}
			}
		}
		return territories;
	}

}
