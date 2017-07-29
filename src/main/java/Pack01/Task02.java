package Pack01;

import java.util.*;

public class Task02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }

    public static int numberNeeded(String first, String second) {
        List<Character> h1 = new ArrayList<>();
        List<Character> h2 = new ArrayList<>();
        first.chars().forEach(value -> h1.add((char) value));
        second.chars().forEach(value -> h2.add((char) value));
        Collections.sort(h1);
        Collections.sort(h2);

        int size = getNumberOfCommonElements(h1, h2);

        return first.length() - size + second.length() - size;
    }

    private static int getSubSequence(List list, int index, Character character) {
        int size = 0;
        for (int i = index; i < list.size(); i++) {
            if (list.get(i).equals(character)) {
                size++;
            } else {
                break;
            }
        }
        return size;
    }

    private static int getNumberOfCommonElements(List<Character> first, List<Character> second) {
        int size = 0;
        for (int i = 0; i < first.size(); i++) {
            for (int j = 0; j < second.size(); j++) {
                if (first.get(i).equals(second.get(j))) {
                    int a = getSubSequence(first, i, first.get(i));
                    int b = getSubSequence(second, j, second.get(j));
                    if (a < b) {
                        size += a;
                    } else {
                        size += b;
                    }
                    i += a - 1;
                    j += b - 1;
                }
            }
        }
        return size;
    }
}
