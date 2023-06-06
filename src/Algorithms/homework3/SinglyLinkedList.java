package Algorithms.homework3;

public class SinglyLinkedList {
    Node head;

    public void revert() {
        if (head != null && head.next != null) {
            revert(head.next, head);
        }
    }

    private void revert(Node currentNode, Node previousNode){
        if (currentNode.next == null) {
            head = currentNode;
        } else {
            revert(currentNode.next, currentNode);
        }
        currentNode.next = previousNode;
        previousNode.next = null;
    }
    public void add(int value) {
        Node node = new Node();
        node.value = value;
        node.next = head;
        head = node;
    }

    public class Node {
        int value;
        Node next;
    }
    @Override
    public String toString() {
        Node currentNode = head;
        StringBuilder sb = new StringBuilder();
        while (currentNode != null) {
            sb.append(currentNode.value).append(' ');
            currentNode = currentNode.next;
        }
        return sb.toString();
    }
}
