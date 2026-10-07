
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bai3 {

    public static void insertionSort(int n, List<Integer> arr) {
        if (n == 0) return;

        int e = arr.get(n - 1);
        int i = n - 2;

        while (i >= 0 && arr.get(i) > e) {
            arr.set(i + 1, arr.get(i));
            printArray(arr);
            i--;
        }

        arr.set(i + 1, e);
        printArray(arr);
    }

    public static void printArray(List<Integer> arr) {
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }

        insertionSort(n, arr);
        sc.close();
    }
}
