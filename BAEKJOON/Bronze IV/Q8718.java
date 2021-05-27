import java.io.*;
import java.util.StringTokenizer;

class Q8718 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        br.close();
        
        int x = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        int ml;
        if(k*7 <= x)
            ml = k * 7000;
        else if (k*3.5 <= x)
            ml = k * 3500;
        else if (k*1.75 <= x)
            ml = k * 1750;
        else
            ml = 0;

        bw.write(ml);
        bw.flush();
        bw.close();
        
    }
}