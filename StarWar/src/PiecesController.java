import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

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
			Piece piece = new Piece(new ImageIcon(getClass().getResource(pieceDTO.getImagePath()).getPath().toString()));
			piece.setId(pieceDTO.getId());
			piece.setName(pieceDTO.getName());
			piece.setxAxisCoordinate(pieceDTO.getxAxisCoordinate());
			piece.setyAxisCoordinate(pieceDTO.getyAxisCoordinate());
			piece.setImagePath(pieceDTO.getImagePath());
			piece.setTerritoryName(pieceDTO.getTerritoryName());
			piece.setPieceType(pieceDTO.getPieceType());;
			pieces.add(piece);
		}
		return pieces;
	}
}
