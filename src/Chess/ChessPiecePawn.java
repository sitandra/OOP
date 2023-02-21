package Chess;

import java.util.ArrayList;
import java.util.List;

/**
 * Пешка
 */
public class ChessPiecePawn extends ChessPiece{

    public ChessPiecePawn(boolean suit) {
        super(suit);
    }

    @Override
    public List<ChessCoordinates> availableMoves(String cell) {
        List<ChessCoordinates> moves = new ArrayList<>();
        try {
            ChessCoordinates coordinates = new ChessCoordinates(cell);
            if (suit) {
                try {
                    moves.add(new ChessCoordinates(coordinates.getX(), coordinates.getY() - 1));
                } catch (Exception ignored) {}
                try {
                    moves.add(new ChessCoordinates(coordinates.getX(), coordinates.getY() - 2));
                } catch (Exception ignored) {}
            } else {
                try {
                    moves.add(new ChessCoordinates(coordinates.getX(), coordinates.getY() + 1));
                } catch (Exception ignored) {}
                try {
                    moves.add(new ChessCoordinates(coordinates.getX(), coordinates.getY() + 2));
                } catch (Exception ignored) {}
            }
        } catch (Exception ignored) {}
        return moves;
    }

    public List<ChessCoordinates> availableChanges(String cell) {
        List<ChessCoordinates> moves = new ArrayList<>();
        try {
            ChessCoordinates coordinates = new ChessCoordinates(cell);
            if (suit) {
                try {
                    moves.add(new ChessCoordinates(coordinates.getX() - 1, coordinates.getY() - 1));
                } catch (Exception ignored) {}
                try {
                    moves.add(new ChessCoordinates(coordinates.getX() + 1, coordinates.getY() - 1));
                } catch (Exception ignored) {}
            } else {
                try {
                    moves.add(new ChessCoordinates(coordinates.getX() - 1, coordinates.getY() + 1));
                } catch (Exception ignored) {}
                try {
                    moves.add(new ChessCoordinates(coordinates.getX() + 1, coordinates.getY() + 1));
                } catch (Exception ignored) {}
            }
        } catch (Exception ignored) {}
        return moves;
    }

    @Override
    public String toString() {
        return suit ? "♙" : "♟︎";
    }
}
