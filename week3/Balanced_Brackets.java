import java.util.Scanner;
public class Balanced_Brackets {

    public static class MyStack {
        private Character[] arr;
        private int top;
        private int capacity;

        public MyStack ( int size) {
            capacity = size;
            arr = new Character[capacity];
            top = -1;
        }

        public void push( Character c) {
            if (isFull()) {return;}
            top ++;
            arr[top] = c;
        }

        public char pop() {
            if (isEmpty()) {throw new IllegalArgumentException("Stack is empty");}
            Character out = arr[top];
            top--;
            return out;
        }
        public boolean isEmpty() {
            return top == -1;
        }
        public boolean isFull() {
            return top == capacity - 1;
        }
    }

    public static char balance(char c) {
        if (c == ')') {
            return '(';
        } else if (c == '}') {
            return '{';
        } else if (c == ']') {
            return '[';
        } else {
            throw new IllegalArgumentException("Loi sai ngoac");
        }
    }

    public static String check(String s) {
        MyStack stack = new MyStack(s.length());
        for (char x : s.toCharArray()) {
            if (x == '(' || x == '[' || x == '{') {
                stack.push(x);
            }
            else if (x == ')' || x == '}' || x == ']') {
                if (stack.isEmpty()) {
                    return "NO";
                }
                char pop = stack.pop();
                if (pop != balance(x)) {
                    return "NO";
                }
            }
        }

        if (stack.isEmpty()) {
            return "YES";
        }
        return "NO";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            System.out.println(check(line));
        }

        scanner.close();
    }
}