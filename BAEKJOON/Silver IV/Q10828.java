import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Q10828 {

    public static final int MAX_SIZE = 100000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        MyStack stack = new MyStack();
        StringBuilder sb = new StringBuilder();

        while(N-- > 0) {
            String cmd = br.readLine();

            switch(cmd) {
            case "pop":
                sb.append(stack.pop()).append("\n");
                break;
            case "size":
                sb.append(stack.size()).append("\n");
                break;
            case "empty":
                sb.append(stack.empty()).append("\n");
                break;
            case "top":
                sb.append(stack.top()).append("\n");
                break;
            default:
                stack.push(Integer.parseInt(cmd.substring(5)));
                break;
            }
        }

        System.out.print(sb);
    }


    static class MyStack {
        int[] arr = new int[MAX_SIZE];
        int size = 0;

        public void push(int num) {
            arr[size++] = num;
        }

        public int pop() {
            return (empty() == 1) ? -1 : arr[(size--) - 1];
        }

        public int size() {
            return size;
        }

        public int empty() {
            return (size == 0) ? 1 : 0;
        }

        public int top() {
            return (empty() == 1) ? -1 : arr[size - 1];
        }
    }
}