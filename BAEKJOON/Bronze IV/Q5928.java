import java.io.*;
import java.util.StringTokenizer;

class Q5928 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int D = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int finish = D * 1440 + H * 60 + M;
        int start = 11 * 1440 + 11 *60 + 11;

        int minutes = finish - start;

        if (minutes >= 0)
            System.out.println(minutes);
        else
            System.out.println(-1);
        
    }
}