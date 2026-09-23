import java.util.Arrays;

/*
 * Bài 1.4.16 - Closest Pair
 * Đề bài:
 * Nhập một mảng a[] gồm N số thực.
 * Tìm một cặp số gần nhau nhất, tức là hai giá trị
 * có hiệu tuyệt đối nhỏ nhất trong tất cả các cặp.
 * Thuật toán phải có thời gian chạy O(N log N)
 * trong trường hợp xấu nhất.
 *
 * Ý tưởng:
 * Bước 1: Sắp xếp mảng theo thứ tự tăng dần.
 * Bước 2: Sau khi sắp xếp, hai phần tử gần nhau nhất
 * chắc chắn phải nằm cạnh nhau.
 * Vì vậy chỉ cần so sánh:
 * a[1] - a[0]
 * a[2] - a[1]
 * ...
 * a[n-1] - a[n-2]
 * Sau đó chọn hiệu nhỏ nhất.
 *
 * Độ phức tạp:
 * Arrays.sort(): O(N log N)
 * Duyệt tìm cặp gần nhất: O(N)
 * Tổng: O(N log N)
 */

public class ClosestPair {
    public static void closestPair(double[] a) {
        int n = a.length;
        if (n < 2) {
            System.out.println("Can it nhat 2 phan tu.");
            return;
        }

        Arrays.sort(a);
        double first = a[0];
        double second = a[1];
        double minDistance = a[1] - a[0];

        for (int i = 1; i < n - 1; i++) {
            double distance = a[i + 1] - a[i];
            if (distance < minDistance) {
                minDistance = distance;
                first = a[i];
                second = a[i + 1];
            }
        }

        System.out.println("Closest pair: " + first + " " + second);
        System.out.println("Distance: " + minDistance);
    }

    public static void main(String[] args) {
        double[] a = {10.0, 1.0, 7.3, 20.0, 7.2};
        System.out.println("Array: " + Arrays.toString(a));
        closestPair(a);
    }
}