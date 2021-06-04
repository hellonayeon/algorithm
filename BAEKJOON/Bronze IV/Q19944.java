import java.io.*;
import java.util.StringTokenizer;

class Q19944 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        br.close();
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        if(M <= 2)
            bw.write("NEWBIE!");
        else if(M <= N)
            bw.write("OLDBIE!");
        else
            bw.write("TLE!");
        
        bw.flush();
        bw.close();
    }
}