import java.io.*;
import java.util.StringTokenizer;

class Q15059 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        br.close();
        
        int Ca = Integer.parseInt(st1.nextToken());
        int Ba = Integer.parseInt(st1.nextToken());
        int Pa = Integer.parseInt(st1.nextToken());
        int Cr = Integer.parseInt(st2.nextToken());
        int Br = Integer.parseInt(st2.nextToken());
        int Pr = Integer.parseInt(st2.nextToken());
        
        int sum = 0;
        sum += (Cr - Ca >= 0) ? Cr - Ca : 0;
        sum += (Br - Ba >= 0) ? Br - Ba : 0;
        sum += (Pr - Pa >= 0) ? Pr - Pa : 0;
        
        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
    }
}
