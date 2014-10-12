import java.util.ArrayList;
import java.util.List;

import model.Piece;

public class PiecesController 
{
	GameStateInputPort gameState;
	TroopsRedeployInputPort troopsRedeployInputPort;
	public PiecesController(GameStateInputPort gameState, TroopsRedeployInputPort troopsRedeploy)
	{
		this.gameState = gameState;
		this.troopsRedeployInputPort = troopsRedeploy;
	}
	
	public List<Piece> getAllPieces()
	{
		List<Piece> pieces = new ArrayList<Piece>();
		for(PieceDTO pieceDTO : gameState.getAllPieces())
		{
			Piece piece = new Piece();
			piece.setId(pieceDTO.getId());
			piece.setName(pieceDTO.getName());
			piece.setxAxisCoordinate(pieceDTO.getxAxisCoordinate());
			piece.setyAxisCoordinate(pieceDTO.getyAxisCoordinate());
			piece.setImagePath(pieceDTO.getImagePath());
			pieces.add(piece);
		}
		return pieces;
	}

	public void redeployTroops(String sourceTerritoryName, String targetTerritoryName) 
	{
		troopsRedeployInputPort.redeployUnits(sourceTerritoryName, targetTerritoryName, 1);		
	}
}
