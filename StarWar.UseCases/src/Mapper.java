public class Mapper 
{
	public static Planet mapPlanet(TerritoryDTO territory) 
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	public static TerritoryDTO mapTerritoryDTO(Planet planet) 
	{
		TerritoryDTO territory = new TerritoryDTO();
		territory.setId(planet.getId());
		territory.setImagePath(planet.getImagePath());
		territory.setName(planet.getName());
		territory.setxAxisCoordinate(planet.getXAxisCoordinate());
		territory.setyAxisCoordinate(planet.getYAxisCoordinate());
		
		return territory;
	}

	public static Player mapPlayer(PlayerDTO playerDTO) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	public static PieceDTO mapPieceDTO(Piece piece) 
	{
		PieceDTO pieceDTO = new PieceDTO();
		pieceDTO.setId(piece.getId());
		pieceDTO.setImagePath(piece.getImagePath());
		pieceDTO.setxAxisCoordinate(piece.getXAxisCoordinate());
		pieceDTO.setyAxisCoordinate(piece.getYAxisCoordinate());
		pieceDTO.setTerritoryName(piece.getTerritoryName());
		if (piece.getPieceType() != null)
			pieceDTO.setPieceType(piece.getPieceType().toString());
		pieceDTO.setOwnerName(piece.getOwnerName());
		return pieceDTO;
	}
}
