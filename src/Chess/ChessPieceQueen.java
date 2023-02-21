package Chess;

import java.util.List;

/**
 * Ферзь
 */
public class ChessPieceQueen extends ChessPiece{
    public ChessPieceQueen(boolean suit) {
        super(suit);
    }

    @Override
    public List<ChessCoordinates> availableMoves(String cell) {
        return null;
    }

    @Override
    public String toString() {
        return suit ? "♕" : "♛";
    }
}
