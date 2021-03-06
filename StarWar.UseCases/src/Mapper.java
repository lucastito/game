public class Mapper 
{
	public static TerritoryDTO mapTerritoryDTO(Planet planet) 
	{
		TerritoryDTO territory = new TerritoryDTO();
		territory.setId(planet.getId());
		territory.setImagePath(planet.getImagePath());
		territory.setName(planet.getName());
		territory.setxAxisCoordinate(planet.getXAxisCoordinate());
		territory.setyAxisCoordinate(planet.getYAxisCoordinate());
		territory.setOwnerName(planet.getOwnerName());
		return territory;
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
