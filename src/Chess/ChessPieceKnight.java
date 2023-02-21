package Chess;

import java.util.List;

/**
 * Конь
 */
public class ChessPieceKnight extends ChessPiece{
    public ChessPieceKnight(boolean suit) {
        super(suit);
    }

    @Override
    public List<ChessCoordinates> availableMoves(String cell) {
        return null;
    }

    @Override
    public String toString() {
        return suit ? "♘" : "♞";
    }
}
