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
            Stack<Character> stack = new Stack<>();
            String input = br.readLine();
            
            int i;
            for(i = 0; i < input.length(); i++) {
                char ps = input.charAt(i);

                if(ps == '(') {
                    stack.push(ps);
                }
                else {
                    if(stack.empty()) break;
                    else stack.pop();
                }
            }

            if(i == input.length() && stack.empty()) 
                sb.append("YES").append("\n");
            else 
                sb.append("NO").append("\n");
        }

        System.out.print(sb);
    }
}