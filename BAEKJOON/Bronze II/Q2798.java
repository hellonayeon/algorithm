import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Q2798 {

    static int N;
    static int M;
    static int[] arr;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int idx = 0; idx < N; idx++) {
            arr[idx] = Integer.parseInt(st.nextToken());
        }

        dfs(new boolean[N], 0, 0);

        System.out.println(max);
    }

    public static void dfs(boolean[] chk, int sum, int depth) {
        if(depth == 3) {
            if(sum <= M) {
                max = (sum > max) ? sum : max;
            }
            return;
        }
        
        for(int i = 0; i < N; i++) {
            if(!chk[i]) {
                chk[i] = true;
                dfs(chk, sum + arr[i], depth+1);
                chk[i] = false;
            }
        }
    }
}