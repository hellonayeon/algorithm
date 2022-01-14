import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Q11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        /* int N = */ Integer.parseInt(br.readLine());
        int[] cnt = new int[1001]; // 대기시간 빈도수
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = 0;
        while(st.hasMoreTokens()) {
            int idx = Integer.parseInt(st.nextToken());
            cnt[idx]++;
            max = Math.max(max, idx);
        }

        int acc = 0;
        int sum = 0;
        for(int i=1; i<=max; i++) {
            if(cnt[i] == 0) continue;
            while(cnt[i]-- > 0) {
                acc += i;
                sum += acc;
            }
        }

        System.out.println(sum);
    }
}