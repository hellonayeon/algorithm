import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Stack;

class Q4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            String input = br.readLine();
            if(input.equals(".")) break;

            if(check(input)) {
                sb.append("yes").append("\n");
            }
            else {
                sb.append("no").append("\n");
            }
        }

        System.out.print(sb);
    }

    public static boolean check(String str) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if(ch == '(' || ch == '[') stack.push(ch);
            else if(ch == ')') {
                if(stack.empty() || stack.peek() != '(') return false;
                stack.pop(); 
            }
            else if(ch == ']') {
                if(stack.empty() || stack.peek() != '[') return false;
                stack.pop();
            }
        }

        return (stack.empty()) ? true : false;
    }
}
