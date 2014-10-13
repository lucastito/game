import java.util.ArrayList;
import java.util.List;

public class TroopsRedeploy implements TroopsRedeployInputPort
{
	private TroopsRedeployOutputPort troopsRedeployOutputPort;
	private IPlanetRepository planetRepository;
	
	public TroopsRedeploy(TroopsRedeployOutputPort troopsRedeployOutputPort, IPlanetRepository planetRepository)
	{
		this.troopsRedeployOutputPort = troopsRedeployOutputPort;
		this.planetRepository = planetRepository;
	}
	public List<TerritoryDTO> possibleTerritoriesToRedeploy(String sourceTerritory) 
	{
		if (!isRedeployTurn())
			return null;
		List<Planet> neighborPlanets = 	planetRepository.getNeighborPlanets(sourceTerritory);
		
		List<TerritoryDTO> territories = new ArrayList<TerritoryDTO>();
		for(Planet neighborPlanet : neighborPlanets)
		{
			territories.add(Mapper.mapTerritoryDTO(neighborPlanet));
		}
				
		return territories;		
	}

	private boolean isRedeployTurn() {
		// TODO Auto-generated method stub
		return true;
	}
	public void numberOfUnitsAllowedToRedeploy(String sourceTerritory, String targetTerritory) 
	{
		troopsRedeployOutputPort.showNumberOfUnitsToRedeploy(1);
	}

	public void redeployUnits(String sourceTerritory, String targetTerritory, String pieceType) 
	{
		if (!isRedeployTurn())
			return;
		Planet targetPlanet = planetRepository.getPlanetByName(targetTerritory);
		if (!isValidTerritoryToRedeploy(sourceTerritory, targetPlanet.getName(), targetPlanet.getOwnerName()))
		{
			troopsRedeployOutputPort.showReason("Invalid territory to redeploy");
			return;
		}
		
		Piece p = planetRepository.getPlanetByName(sourceTerritory).getPieces().get(0);
		p.setXAxisCoordinate(targetPlanet.getXAxisCoordinate());
		p.setYAxisCoordinate(targetPlanet.getYAxisCoordinate());
		planetRepository.getPlanetByName(targetTerritory).addPiece(p);
		planetRepository.getPlanetByName(sourceTerritory).getPieces().remove(0);
		p.setTerritoryName(targetTerritory);
		troopsRedeployOutputPort.showRedeployedUnits();
	}
	
	public boolean isValidTerritoryToRedeploy(String sourcePlanetName, String targetPlanetName, String targetOwnerName)
	{
		List<Planet> neighborPlanets = 	planetRepository.getNeighborPlanets(sourcePlanetName);
		for(Planet neighborPlanet : neighborPlanets)
		{			
			if(neighborPlanet.getName().equals(targetPlanetName) && !sourcePlanetName.equals(targetOwnerName))
				return true;
		}
		return false;
	}
}
