package Pack01;

public class Task04 {
    private static class Node {
        int data;
        Node next;

        boolean hasCycle(Node head) {
            Node current = head;
            Node prev = head;
            while (current != null && current.next != null) {
                prev = prev.next;
                current = current.next.next;
                if (prev == current) {
                    return true;
                }
            }
            return false;
        }
    }

}
