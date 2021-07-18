import java.io.*;

class Q1110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int tmp = N;
        int cnt = 0;
        while(true) {
            cnt++;

            int l = tmp / 10;
            int r = tmp % 10;

            int n = r * 10 + (l + r) % 10;
            if(n == N) break;
            
            tmp = n;
        }
        System.out.print(cnt);
    }
}