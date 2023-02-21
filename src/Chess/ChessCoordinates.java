package Chess;

import java.util.HashMap;
import java.util.Map;

public class ChessCoordinates {
    private int x;
    private int y;

    public static final int SIZE = 8;
    private static final Map<Character, Integer> xIndex = new HashMap<Character, Integer>() {{
        put('a', 0);
        put('b', 1);
        put('c', 2);
        put('d', 3);
        put('e', 4);
        put('f', 5);
        put('g', 6);
        put('h', 7);

    }};
    private static final Map<Character, Integer> yIndex = new HashMap<Character, Integer>() {{
        put('8', 0);
        put('7', 1);
        put('6', 2);
        put('5', 3);
        put('4', 4);
        put('3', 5);
        put('2', 6);
        put('1', 7);
    }};

    public ChessCoordinates(int x, int y) throws Exception {
        check(x, y);
        this.x = x;
        this.y = y;
    }

    public ChessCoordinates(int coordinate) throws Exception {
        this(coordinate, coordinate);
    }

    public ChessCoordinates(String coordinate) throws Exception {
        this(xIndex.get(coordinate.charAt(0)), yIndex.get(coordinate.charAt(1)));
    }

    private void check(int x, int y) throws Exception {
        if (x >= SIZE || y >= SIZE || x < 0 || y < 0)
            throw new Exception("Oversize chess coordinates");
    }

    public void set(int x, int y) throws Exception {
        check(x, y);
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return xIndex.entrySet()
                .stream()
                .filter(entry -> entry.getValue().equals(x))
                .map(Map.Entry::getKey)
                .findFirst().get().toString() + yIndex.entrySet()
                .stream()
                .filter(entry -> entry.getValue().equals(y))
                .map(Map.Entry::getKey)
                .findFirst().get().toString();
    }
}
