import java.io.*;
import java.util.StringTokenizer;

public class Queue_Using_Two_Stacks {

    public static class MyStack {
        private int[] arr;
        private int top;

        public MyStack(int size) {
            arr = new int[size];
            top = -1;
        }

        public void push(int x) {
            top++;
            arr[top] = x;
        }

        public int pop() {
            if (isEmpty()) {
                throw new IllegalStateException("Stack is empty");
            }

            int out = arr[top];
            top--;
            return out;
        }

        public int peek() {
            if (isEmpty()) {
                throw new IllegalStateException("Stack is empty");
            }

            return arr[top];
        }

        public boolean isEmpty() {
            return top == -1;
        }
    }

    public static class MyQueue {
        private MyStack stack1;
        private MyStack stack2;

        public MyQueue(int size) {
            stack1 = new MyStack(size);
            stack2 = new MyStack(size);
        }

        public void enqueue(int x) {
            stack1.push(x);
        }

        private void move() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
        }

        public void dequeue() {
            move();
            stack2.pop();
        }

        public int front() {
            move();
            return stack2.peek();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int q = Integer.parseInt(br.readLine());

        MyQueue queue = new MyQueue(q);

        StringBuilder output = new StringBuilder();

        for (int i = 0; i < q; i++) {
            StringTokenizer st =
                    new StringTokenizer(br.readLine());

            int type = Integer.parseInt(st.nextToken());

            if (type == 1) {
                int x = Integer.parseInt(st.nextToken());
                queue.enqueue(x);
            }

            else if (type == 2) {
                queue.dequeue();
            }

            else if (type == 3) {
                output.append(queue.front()).append('\n');
            }
        }

        System.out.print(output);
        br.close();
    }
}