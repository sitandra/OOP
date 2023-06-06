package Algorithms.homework4;


import java.util.ArrayList;
import java.util.List;

public class LeftSideRedBlackTree {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;

    private class Node {
        private int value;
        private Node left, right;
        private boolean color;
        private int size;

        public Node(int value, boolean color, int size) {
            this.value = value;
            this.color = color;
            this.size = size;
        }

        @Override
        public String toString() {
            return (color == RED ? "\u001B[31m" : "\u001B[0m") + value;
        }
    }

    private boolean isRed(Node x) {
        if (x == null) return false;
        return x.color == RED;
    }

    private int size(Node x) {
        if (x == null) return 0;
        return x.size;
    }

    public int size() {
        return size(root);
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void put(int key) {
        root = put(root, key);
        root.color = BLACK;
    }

    private Node put(Node h, Integer value) {
        if (h == null) return new Node(value, RED, 1);

        int cmp = value.compareTo(h.value);
        if (cmp < 0) {
            h.left = put(h.left, value);
        } else if (cmp > 0) {
            h.right = put(h.right, value);
        } else {
            h.value = value;
        }

        if (isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right)) flipColors(h);

        h.size = size(h.left) + size(h.right) + 1;
        return h;
    }

    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.size = h.size;
        h.size = size(h.left) + size(h.right) + 1;
        return x;
    }

    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.size = h.size;
        h.size = size(h.left) + size(h.right) + 1;
        return x;
    }

    private void flipColors(Node h) {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        List<List<Node>> levels = new ArrayList<>();
        dfs(root, 0, 0, levels);
        int levelFactor = getMaxDepth();
        for (List<Node> level : levels) {
            int countChars = (int)Math.pow(2, levelFactor) - 1;
            levelFactor--;
            for (Node node : level) {
                if (node == null) sb.append(getPadding(countChars*2+2));
                else {
                    sb.append(getLeftPadding(countChars));
                    sb.append(node);
                    sb.append(getRightPadding(countChars));
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private String getPadding(int count) {
        return new String(new char[count]).replace('\0', ' ');
    }
    private String getLeftPadding(int count) {
        count = count / 2;
        if (count > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("\u001B[0m")
                    .append(new String(new char[count]).replace('\0', ' '))
                    .append('┌')
                    .append(new String(new char[count]).replace('\0', '─'));
            return sb.toString();
        } else return "\u001B[0m ";
    }

    private String getRightPadding(int count) {
        count = count / 2;
        if (count > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("\u001B[0m")
                    .append(new String(new char[count]).replace('\0', '─'))
                    .append('┐')
                    .append(new String(new char[count]).replace('\0', ' '));
            return sb.toString();
        } else return "\u001B[0m ";
    }

    private void dfs(Node node, int level, int pos, List<List<Node>> levels) {
        if (node == null) return;

        if (levels.size() <= level) {
            levels.add(new ArrayList<>());
        }
        List<Node> currentLevel = levels.get(level);
        while (currentLevel.size() <= pos) {
            currentLevel.add(null);
        }
        currentLevel.set(pos, node);

        dfs(node.left, level + 1, pos * 2, levels);
        dfs(node.right, level + 1, pos * 2 + 1, levels);
    }

    public int getMaxDepth() {
        return getMaxDepth(root);
    }

    private int getMaxDepth(Node node) {
        if (node == null) {
            return 0;
        } else {
            int leftDepth = getMaxDepth(node.left);
            int rightDepth = getMaxDepth(node.right);
            return 1 + Math.max(leftDepth, rightDepth);
        }
    }
}
