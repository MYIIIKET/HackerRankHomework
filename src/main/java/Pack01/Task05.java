package Pack01;

import java.util.*;

public class Task05 {

    public static boolean isBalanced(String expression) {
        Deque<Character> queue = new ArrayDeque<>();
        char character;
        char ret;
        for (int i = 0; i < expression.length(); i++) {
            character = expression.charAt(i);
            if (character == '(' || character == '{' || character == '[') {
                queue.addFirst(character);
            } else {
                if (queue.isEmpty()) {
                    return false;
                }
                ret = queue.pollFirst();
                if (!(character == ')' && ret == '('
                        || character == '}' && ret == '{'
                        || character == ']' && ret == '[')) {
                    return false;
                }
            }
        }
        return queue.isEmpty() ? true : false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println((isBalanced(expression)) ? "YES" : "NO");
        }
    }
}
