import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// 카운팅 정렬
class Q10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] cnt = new int[10001]; // (0)~10000
        for(int i = 0; i < N; i++)
            cnt[Integer.parseInt(br.readLine())]++;

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= 10000; i++) {
            while(cnt[i] > 0) {
                sb.append(i).append("\n");
                cnt[i]--;
            }
        }
            
        System.out.print(sb);
    }
}