import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Q4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            String input = br.readLine();
            if(input.equals(".")) break;
            
            sb.append(check(input)).append("\n");
        }

        System.out.print(sb);
    }

    public static String check(String str) {
        char[] stack = new char[str.length()];
        int size = 0;

        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if(ch == '(' || ch == '[') {
                stack[size++] = ch;
            }
            else if(ch == ')') {
                if(size == 0 || stack[size-1] != '(') {
                    return "no";
                }
                size--;
            }
            else if(ch == ']') {
                if(size == 0 || stack[size-1] != '[') {
                    return "no";
                }
                size--;
            }
        }

        return (size == 0) ? "yes" : "no";
    }
}
