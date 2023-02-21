package Chess;

import java.util.List;

/**
 * Король
 */
public class ChessPieceKing extends ChessPiece{
    public ChessPieceKing(boolean suit) {
        super(suit);
    }

    @Override
    public List<ChessCoordinates> availableMoves(String cell) {
        return null;
    }

    @Override
    public String toString() {
        return suit ? "♔" : "♚";
    }
}
