import java.io.*;
import java.util.StringTokenizer;

class Q16785 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        br.close();
        
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        
        int day = 0;
        while(C > 0) {            
            C -= A;
            day++;
            
            if(day % 7 == 0) 
                C -= B;

        }

        bw.write(String.valueOf(day));
        bw.flush();
        bw.close();
    }
}
