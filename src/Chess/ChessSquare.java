package Chess;

import java.util.ArrayList;
import java.util.List;

public class ChessSquare {
    List<ChessPiece> white = new ArrayList<>();
    List<ChessPiece> black = new ArrayList<>();

    ChessPiece[][] square = new ChessPiece[ChessCoordinates.SIZE][ChessCoordinates.SIZE];

    public ChessSquare() {
        white.add(square[0][0] = new ChessPieceRook(false));
        white.add(square[7][0] = new ChessPieceRook(false));
        white.add(square[1][0] = new ChessPieceKnight(false));
        white.add(square[6][0] = new ChessPieceKnight(false));
        white.add(square[2][0] = new ChessPieceBishop(false));
        white.add(square[5][0] = new ChessPieceBishop(false));
        white.add(square[3][0] = new ChessPieceKing(false));
        white.add(square[4][0] = new ChessPieceQueen(false));
        for (int x = 0; x < ChessCoordinates.SIZE; x++) {
            white.add(square[x][1] = new ChessPiecePawn(false));
        }

        black.add(square[0][7] = new ChessPieceRook(true));
        black.add(square[7][7] = new ChessPieceRook(true));
        black.add(square[1][7] = new ChessPieceKnight(true));
        black.add(square[6][7] = new ChessPieceKnight(true));
        black.add(square[2][7] = new ChessPieceBishop(true));
        black.add(square[5][7] = new ChessPieceBishop(true));
        black.add(square[3][7] = new ChessPieceKing(true));
        black.add(square[4][7] = new ChessPieceQueen(true));
        for (int x = 0; x < ChessCoordinates.SIZE; x++) {
            black.add(square[x][6] = new ChessPiecePawn(true));
        }
    }

    private ChessPiece getPiece(String cell) {
        try {
            ChessCoordinates coordinates = new ChessCoordinates(cell);
            return square[coordinates.getX()][coordinates.getY()];
        } catch (Exception ignored) {}
        return null;
    }
    public List<ChessCoordinates> availableMoves(String cell) {
        ChessPiece piece = getPiece(cell);
        if (piece == null) return new ArrayList<>();
        else return piece.availableMoves(cell);
    }

    public List<ChessCoordinates> availableChanges(String cell) {
        ChessPiece piece = getPiece(cell);
        if (piece == null) return new ArrayList<>();
        else return piece.availableChanges(cell);
    }

    /*
    private void addPiece(String cell, ChessPiece piece) {
        try {
            ChessCoordinates coordinates = new ChessCoordinates(cell);
            square[coordinates.getX()][coordinates.getY()] = piece;
            if (piece.isWhite()) {
                white.add(square[coordinates.getX()][coordinates.getY()]);
            } else {
                black.add(square[coordinates.getX()][coordinates.getY()]);
            }
        } catch (Exception ignored){}
    }*/

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("\ta\tb\ts\td\te\tf\tg\th\n");
        for (int y = 0; y < ChessCoordinates.SIZE; y++) {
            result.append(ChessCoordinates.SIZE-y);
            for (int x = 0; x < ChessCoordinates.SIZE; x++) {
                if (square[x][y] == null) result.append((x+y)%2==0?"\t□":"\t■");
                else result.append("\t").append(square[x][y].toString());
            }
            result.append("\n");
        }
        return result.toString();
    }
}
