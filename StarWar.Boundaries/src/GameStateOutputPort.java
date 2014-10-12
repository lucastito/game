import java.util.List;


public interface GameStateOutputPort 
{
	void showAllTerritories(List<TerritoryDTO> planets);
	void showAllPieces(List<PieceDTO> pieces);

}
