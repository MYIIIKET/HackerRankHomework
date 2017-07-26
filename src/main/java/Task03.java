import java.util.*;

public class Task03 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        String magazine[] = new String[m];
        for (int magazine_i = 0; magazine_i < m; magazine_i++) {
            magazine[magazine_i] = in.next();
        }
        String ransom[] = new String[n];
        for (int ransom_i = 0; ransom_i < n; ransom_i++) {
            ransom[ransom_i] = in.next();
        }

        List<String> magazineList = new ArrayList<>();
        List<String> ransomList = new ArrayList<>();

        Arrays.stream(magazine).forEach(s -> magazineList.add(s));
        Arrays.stream(ransom).forEach(s -> ransomList.add(s));

        if (!ransomList.stream().filter(value -> !magazineList.remove(value)).findFirst().isPresent()) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
