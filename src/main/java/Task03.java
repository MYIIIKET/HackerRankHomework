import java.util.Arrays;
import java.util.Scanner;

public class Task03 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int d = sc.nextInt();
        for (int tc = 0; tc < d; tc++) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < a.length; i++) {
                a[i] = sc.nextInt();
            }

            System.out.println(countInversions(a, 0, a.length - 1));
        }

        sc.close();
    }

    static long countInversions(int[] a, int beginIndex, int endIndex) {
        if (beginIndex >= endIndex) {
            return 0;
        }

        long inversionNum = 0;
        int middleIndex = (beginIndex + endIndex) / 2;
        inversionNum += countInversions(a, beginIndex, middleIndex);
        inversionNum += countInversions(a, middleIndex + 1, endIndex);

        int leftIndex = beginIndex;
        int rightIndex = middleIndex + 1;
        int[] sorted = new int[endIndex - beginIndex + 1];
        for (int i = 0; i < sorted.length; i++) {
            if (rightIndex > endIndex || (leftIndex <= middleIndex && a[leftIndex] <= a[rightIndex])) {
                sorted[i] = a[leftIndex];
                leftIndex++;
            } else {
                inversionNum += middleIndex - leftIndex + 1;

                sorted[i] = a[rightIndex];
                rightIndex++;
            }
        }

        for (int i = beginIndex; i <= endIndex; i++) {
            a[i] = sorted[i - beginIndex];
        }

        return inversionNum;
    }

    private static int[] mergeSortA(int[] data) {
        int size = data.length;
        int mid = size / 2;
        int[] left = Arrays.copyOfRange(data, 0, mid);
        int[] right = Arrays.copyOfRange(data, mid, size);
        int leftSize = left.length;
        int rightSize = right.length;
        left = (leftSize == 1) ? left : mergeSortA(left);
        right = (rightSize == 1) ? right : mergeSortA(right);
        int[] result = new int[size];
        int leftIndex = 0;
        int rightIndex = 0;
        for (int i = 0; i < size; i++) {
            if (left[leftIndex] < right[rightIndex]) {
                result[i] = left[leftIndex++];
            } else if (left[leftIndex] > right[rightIndex]) {
                result[i] = right[rightIndex++];
            } else {
                result[i] = left[leftIndex++];
            }
            if (leftIndex == leftSize) {
                System.arraycopy(right, rightIndex, result, ++i, size - i);
                break;
            }
            if (rightIndex == rightSize) {
                System.arraycopy(left, leftIndex, result, ++i, size - i);
                break;
            }
        }
        return result;
    }
}
