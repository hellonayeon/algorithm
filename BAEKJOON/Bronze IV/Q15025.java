import java.io.*;
import java.util.StringTokenizer;

class Q15025 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        br.close();
        
        int tine1 = Integer.parseInt(st.nextToken());
        int tine2 = Integer.parseInt(st.nextToken());
        
        StringBuilder sb = new StringBuilder();
        if(tine1 != tine2)
            sb.append("Odd ").append(Math.max(tine1, tine2) * 2);
        else {
            if(tine1 != 0)
                sb.append("Even ").append(tine1 + tine2);
            else
                sb.append("Not a moose");
        }
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}