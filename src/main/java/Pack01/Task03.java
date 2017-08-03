package Pack01;

import java.util.*;

public class Task03 {
    public static void main(String[] args) {
        Map<String, Integer> words = new HashMap();
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        String word = "";
        int counts = 0;
        for (int magazine_i = 0; magazine_i < m; magazine_i++) {
            word = in.next();
            if (words.containsKey(word)) {
                counts = words.get(word);
                words.put(word, ++counts);
            } else {
                words.put(word, 1);
            }
        }
        boolean flag = true;
        for (int ransom_i = 0; ransom_i < n; ransom_i++) {
            word = in.next();
            if (words.containsKey(word)) {
                counts = words.get(word);
                if (--counts == 0) {
                    words.remove(word);
                } else {
                    words.put(word, counts);
                }
            } else {
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
