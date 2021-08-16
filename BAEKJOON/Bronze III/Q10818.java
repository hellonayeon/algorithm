import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Q10818 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        int num = 0;
        int sign = 1;

        for (int c : br.readLine().getBytes()) {
            if(c == ' ') {
                num *= sign;
                min = Math.min(min, num);
                max = Math.max(max, num);
                num = 0;
                sign = 1;
            }else if(c == '-') {
                sign = -1;
            }else if('0' <= c && c <= '9') {
                num = num * 10 + (c - '0');
            }
        }

        num *= sign;
        min = Math.min(min, num);
        max = Math.max(max, num);

        System.out.println(min + " " + max);
        
        br.close();
    }
}