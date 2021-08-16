import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Q2562 {
    final static int COUNT = 9;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int max = 0, seq = 0;
        for(int i = 1; i <= COUNT; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num > max) {
                max = num;
                seq = i;
            }
        }

        System.out.println(max);
        System.out.println(seq);
    }
}