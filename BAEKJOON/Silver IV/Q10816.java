import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Q10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] nums = new int[20000001];

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            nums[Integer.parseInt(st.nextToken()) + 10000000]++;
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<M; i++) {
            sb.append(nums[Integer.parseInt(st.nextToken())  + 10000000]).append(" ");
        }

        System.out.println(sb);
    }
}