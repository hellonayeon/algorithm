import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Q4344 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringBuilder sb = new StringBuilder();
        int C = Integer.parseInt(br.readLine());
        
        for(int tc = 0; tc < C; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());

            int[] scores = new int[N];
            int idx = 0;
            int sum = 0;
            while(st.hasMoreTokens()) {
                int num = Integer.parseInt(st.nextToken());
                scores[idx++] = num;
                sum += num;
            }

            double avg = (double)sum / N;
            double cnt = 0;
            for(int score : scores) {
                if(score > avg) cnt++;
            }

            sb.append(String.format("%.3f%%", cnt/N*100)).append("\n");
        }
        
        System.out.print(sb);
    }
}
