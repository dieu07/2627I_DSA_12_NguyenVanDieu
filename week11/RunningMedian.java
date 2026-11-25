import java.io.*;
import java.util.*;

public class RunningMedian {

    static class Node implements Comparable<Node> {
        int val;
        int idx;

        Node(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(Node other) {
            if (this.val != other.val) {
                return Integer.compare(this.val, other.val);
            }
            return Integer.compare(this.idx, other.idx);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        TreeSet<Node> set = new TreeSet<>();
        Node mid = null;
        StringBuilder out = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int val = Integer.parseInt(br.readLine().trim());
            Node node = new Node(val, i);
            set.add(node);

            if (set.size() == 1) {
                mid = node;
            } else if (set.size() % 2 == 0) {
                if (node.compareTo(mid) < 0) {
                    mid = set.lower(mid);
                }
            } else {
                if (node.compareTo(mid) > 0) {
                    mid = set.higher(mid);
                }
            }

            double median;
            if (set.size() % 2 == 1) {
                median = mid.val;
            } else {
                median = (mid.val + set.higher(mid).val) / 2.0;
            }

            out.append(String.format(Locale.US, "%.1f\n", median));
        }

        System.out.print(out.toString());
    }
}