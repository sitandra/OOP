package Chess;

import java.util.ArrayList;
import java.util.List;

/**
 * Слон
 */
public class ChessPieceBishop extends ChessPiece{
    public ChessPieceBishop(boolean suit) {
        super(suit);
    }

    @Override
    public List<ChessCoordinates> availableMoves(String cell) {
        List<ChessCoordinates> moves = new ArrayList<>();
        return moves;
    }

    @Override
    public String toString() {
        return suit ? "♗" : "♝";
    }
}
