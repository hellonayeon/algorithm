import java.io.*;
import java.util.StringTokenizer;

class Q11549 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int T = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] n = new int[5];
        for(int i=0; i<n.length; i++)
            n[i] = Integer.parseInt(st.nextToken());
        
        int count = 0;
        for(int i=0; i<n.length; i++)
            if(n[i] == T) count++;
        
        bw.write(Integer.toString(count));
        bw.flush();
        bw.close();
    }
}