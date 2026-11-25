import java.io.*;
import java.util.*;

public class MissingNumbers {

    // CÁCH 1: Sử dụng Bảng băm (HashMap) để đếm, sau đó sắp xếp kết quả
    public static List<Integer> missingNumbersHashTable(int[] a, int[] b) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : b) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }
        for (int x : a) {
            freq.put(x, freq.getOrDefault(x, 0) - 1);
        }

        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() > 0) {
                res.add(entry.getKey());
            }
        }
        Collections.sort(res);
        return res;
    }

    // CÁCH 2: Chỉ sử dụng Sắp xếp (Sorting) + Hai con trỏ
    public static List<Integer> missingNumbersSorting(int[] a, int[] b) {
        int[] copyA = Arrays.copyOf(a, a.length);
        int[] copyB = Arrays.copyOf(b, b.length);
        Arrays.sort(copyA);
        Arrays.sort(copyB);

        List<Integer> res = new ArrayList<>();
        int i = 0, j = 0;
        while (j < copyB.length) {
            if (i < copyA.length && copyA[i] == copyB[j]) {
                i++;
                j++;
            } else {
                // Chỉ thêm nếu chưa có trong danh sách kết quả (tránh in trùng)
                if (res.isEmpty() || res.get(res.size() - 1) != copyB[j]) {
                    res.add(copyB[j]);
                }
                j++;
            }
        }
        return res;
    }

    // CÁCH 3: Sử dụng Sắp xếp đếm (Counting Sort) tận dụng max(B) - min(B) <= 100
    public static List<Integer> missingNumbersCountingSort(int[] a, int[] b) {
        int minB = Integer.MAX_VALUE;
        for (int x : b) {
            if (x < minB) minB = x;
        }

        int[] count = new int[101]; // Chênh lệch max - min <= 100
        for (int x : b) {
            count[x - minB]++;
        }
        for (int x : a) {
            if (x >= minB && x <= minB + 100) {
                count[x - minB]--;
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int d = 0; d <= 100; d++) {
            if (count[d] > 0) {
                res.add(minB + d); // Tự động tăng dần, không cần sort
            }
        }
        return res;
    }

    private static void printList(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if (i > 0) sb.append(' ');
            sb.append(list.get(i));
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine().trim());
        int[] b = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) b[i] = Integer.parseInt(st.nextToken());

        // Chạy thử cả 3 cách (hiện tại chỉ giữ lại 1 dòng in)
        printList(missingNumbersHashTable(a, b));
        // printList(missingNumbersSorting(a, b));
        // printList(missingNumbersCountingSort(a, b));
    }
}