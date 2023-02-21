package Chess;

import java.util.List;

/**
 * Ладья
 */
public class ChessPieceRook extends ChessPiece{
    public ChessPieceRook(boolean suit) {
        super(suit);
    }

    @Override
    public List<ChessCoordinates> availableMoves(String cell) {
        return null;
    }

    @Override
    public String toString() {
        return suit ? "♖" : "♜";
    }
}
