
import java.util.Scanner;

public class Bai7 {

    public static int[] countingSort(int[] arr) {
        int[] count = new int[100];

        for (int x : arr) {
            count[x]++;
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] result = countingSort(arr);

        for (int i = 0; i < result.length; i++) {
            if (i > 0) System.out.print(" ");
            System.out.print(result[i]);
        }
        System.out.println();

        sc.close();
    }
}
