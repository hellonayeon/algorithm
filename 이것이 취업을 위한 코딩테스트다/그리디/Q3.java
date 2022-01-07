import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Q3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int ans = 0;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            
            // 한 행에서 가장 작은 수 찾기
            int min = 10000;
            for(int j=0; j<M; j++) {
                int num = Integer.parseInt(st.nextToken());
                min = Math.min(num, min);
            }

            // 전체 행에서 가장 큰 수 찾기 (선택된 작은 수들 중에서 가장 큰 수)
            ans = Math.max(min, ans);
        }

        System.out.println(ans);
    }
}
