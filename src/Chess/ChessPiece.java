package Chess;

import java.util.List;

public abstract class ChessPiece {

    protected boolean suit;
    public abstract List<ChessCoordinates> availableMoves(String cell);
    public List<ChessCoordinates> availableChanges(String cell) {
        return availableMoves(cell);
    }

    public ChessPiece(boolean suit) {
        this.suit = suit;
    }

    public boolean isWhite() {
        return suit;
    }
}
