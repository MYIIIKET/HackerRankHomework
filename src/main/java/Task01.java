import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Task01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for (int a_i = 0; a_i < n; a_i++) {
            a[a_i] = in.nextInt();
        }
        List<Integer> list = IntStream.of(a).boxed().collect(Collectors.toList());
        Collections.rotate(list, -k);
        list.forEach(integer -> System.out.print(integer + " "));
    }
}
