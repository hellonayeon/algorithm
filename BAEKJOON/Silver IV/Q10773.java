import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Stack;

class Q10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        while(K-- > 0) {
            int n = Integer.parseInt(br.readLine());
            if(n == 0) {
                stack.pop();
                continue;
            }

            stack.push(n);
        }

        int sum = 0;
        for(Integer n : stack) {
            sum += n;
        }

        System.out.println(sum);
    }
}