import java.io.*;
import java.util.StringTokenizer;

class Q11943 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        br.close();
        
        int A = Integer.parseInt(st1.nextToken());
        int B = Integer.parseInt(st1.nextToken());
        int C = Integer.parseInt(st2.nextToken());
        int D = Integer.parseInt(st2.nextToken());
        
        int comb1 = A+C;
        int comb2 = B+D;
        
        bw.write(Integer.toString( Math.min(comb1, comb2) ));
        bw.flush();
        bw.close();
    }
}