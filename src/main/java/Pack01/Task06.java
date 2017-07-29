package Pack01;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Task06 {
    public static void main(String[] args) {
        Deque<Integer> queue = new ArrayDeque<>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.addLast(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.pollFirst();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.getFirst());
            }
        }
        scan.close();
    }
}
