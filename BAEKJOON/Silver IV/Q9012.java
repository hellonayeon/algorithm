import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Stack;

class Q9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(T-- > 0) {
            String input = br.readLine();

            if(vps(input)) {
                sb.append("YES").append("\n");
            }   
            else {
                sb.append("NO").append("\n");
            }
        }

        System.out.print(sb);
    }

    public static boolean vps(String str) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < str.length(); i++) {
            char ps = str.charAt(i);

            if(ps == '(') {
                stack.push(ps);
            }
            else {
                if(stack.empty()) {
                    return false;
                }
                stack.pop();
            }
        }

        return (stack.empty()) ? true : false;
    }
}
