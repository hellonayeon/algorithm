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

        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            String cmd = input[0];

            switch(cmd) {
            case "push":
                stack.push(Integer.parseInt(input[1]));
                break;
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
            }
        }

        System.out.print(sb);
    }


    static class MyStack {
        int[] arr = new int[MAX_SIZE];
        int idx = -1;

        public void push(int num) {
            arr[++idx] = num;
        }

        public int pop() {
            if(empty() == 1) return -1;

            int num = arr[idx];
            arr[idx--] = 0;
            
            return num;
        }

        public int size() {
            return idx+1;
        }

        public int empty() {
            return (idx == -1) ? 1 : 0;
        }

        public int top() {
            return (empty() == 0) ? arr[idx] : -1;
        }
    }
}