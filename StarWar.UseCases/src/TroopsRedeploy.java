import java.util.ArrayList;
import java.util.List;

public class TroopsRedeploy implements TroopsRedeployInputPort
{
	private TroopsRedeployOutputPort troopsRedeployOutputPort;
	private IPlanetRepository planetRepository;
	private IPlayerRepository playerRepository;
	
	public TroopsRedeploy(TroopsRedeployOutputPort troopsRedeployOutputPort, IPlanetRepository planetRepository, IPlayerRepository playerRepository)
	{
		this.troopsRedeployOutputPort = troopsRedeployOutputPort;
		this.planetRepository = planetRepository;
		this.playerRepository = playerRepository;
	}
	public List<TerritoryDTO> possibleTerritoriesToRedeploy(String sourceTerritory) 
	{
		List<Planet> neighborPlanets = 	planetRepository.getNeighborPlanets(sourceTerritory);
		List<TerritoryDTO> territories = new ArrayList<TerritoryDTO>();
		for(Planet neighborPlanet : neighborPlanets)
		{
			if (!neighborPlanet.getOwnerName().equals(sourceTerritory))
				territories.add(Mapper.mapTerritoryDTO(neighborPlanet));
		}
				
		return territories;		
	}

	public void redeployUnits(String sourceTerritory, String targetTerritory, List<PieceDTO> pieces) 
	{
		Planet targetPlanet = planetRepository.getPlanetByName(targetTerritory);
		if (!isValidTerritoryToRedeploy(sourceTerritory, targetPlanet.getName(), targetPlanet.getOwnerName()))
		{
			troopsRedeployOutputPort.showReason("Invalid territory to redeploy");
			return;
		}
		
		for (PieceDTO pieceDTO : pieces)
		{
			Piece piece = playerRepository.getPiece(pieceDTO.getId());
			playerRepository.removePlayerPiece(targetPlanet.getOwnerName(), pieceDTO.getId());
			piece.setTerritoryName(targetTerritory);
			playerRepository.addPlayerPiece(targetPlanet.getOwnerName(), targetTerritory, piece);
		}

		troopsRedeployOutputPort.show();
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
