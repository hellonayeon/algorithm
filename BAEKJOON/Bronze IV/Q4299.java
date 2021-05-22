import java.io.*;
import java.util.StringTokenizer;

class Q4299 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int sum = Integer.parseInt(st.nextToken());
        int diff = Integer.parseInt(st.nextToken());
        
        if( (sum-diff)%2 != 0 || (sum-diff) < 0)
            System.out.println(-1);
        else {
            int score1 = (sum-diff)/2;
            int score2 = sum - score1;
            
            System.out.println(Math.max(score1,score2) + " " + Math.min(score1,score2));
        }
        
    }
}