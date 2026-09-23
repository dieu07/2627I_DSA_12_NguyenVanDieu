import java.util.Arrays;

/*
 * Bài 1.4.17 - Farthest Pair
 *
 * Đề bài:
 * Nhập một mảng a[] gồm N số thực.
 * Tìm một cặp số xa nhau nhất, tức là hai giá trị có
 * hiệu tuyệt đối lớn nhất trong tất cả các cặp của mảng.
 * Thuật toán phải có thời gian chạy tuyến tính O(N)
 * trong trường hợp xấu nhất.
 */

public class FarthestPair {
    public static void farthestPair(double[] a) {
        int n = a.length;
        if (n < 2) {
            System.out.println("Can it nhat 2 phan tu.");
            return;
        }

        double first = a[0];
        double min = first;
        double max = first;

        for (int i = 1; i < n; i++) {
            double x = a[i];
            if (x < min) {
                min = x;
            }
            if (x > max) {
                max = x;
            }
        }

        double distance = max - min;
        System.out.println("Farthest pair: " + min + " " + max);
        System.out.println("Distance: " + distance);
    }

    public static void main(String[] args) {
        double[] a = {1.5, 7.2, -3.0, 4.8, 10.0};
        System.out.println("Array: " + Arrays.toString(a));
        farthestPair(a);
    }
}