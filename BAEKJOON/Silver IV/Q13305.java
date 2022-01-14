import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Q13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] dis = new int[N-1];
        int[] oil = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N-1; i++) {
            dis[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            oil[i] = Integer.parseInt(st.nextToken());
        }

        long fee = oil[0];
        long totalFee = fee * dis[0];

        for(int i=1; i<N-1; i++) {
            if(oil[i] < fee) {
                fee = oil[i];
            }
            
            totalFee += fee * dis[i];
        }

        System.out.println(totalFee);
    }
}