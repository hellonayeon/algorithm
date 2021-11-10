import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Q2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int N = Integer.parseInt(input);
        int len = input.length();

        for(int i = N-len*9; i <= N; i++) {
            char[] chs = String.valueOf(i).toCharArray();
            int sum = i;
            for(int j = 0; j < chs.length; j++) {
                sum += chs[j] - '0';
            }

            if(sum == N) {
                System.out.println(i);
                return;
            }
        }

        System.out.println(0);
    }
}