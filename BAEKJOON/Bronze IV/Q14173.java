import java.io.*;
import java.util.StringTokenizer;

class Q14173 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        br.close();
        
        int f1X1 = Integer.parseInt(st1.nextToken());
        int f1Y1 = Integer.parseInt(st1.nextToken());
        int f1X2 = Integer.parseInt(st1.nextToken());
        int f1Y2 = Integer.parseInt(st1.nextToken());
        
        int f2X1 = Integer.parseInt(st2.nextToken());
        int f2Y1 = Integer.parseInt(st2.nextToken());
        int f2X2 = Integer.parseInt(st2.nextToken());
        int f2Y2 = Integer.parseInt(st2.nextToken());
        
        int w = Math.max(f1X2, f2X2) - Math.min(f1X1, f2X1);
        int h = Math.max(f1Y2, f2Y2) - Math.min(f1Y1, f2Y1);
        
        int max = Math.max(w, h);
        bw.write(Integer.toString(max*max));
        bw.flush();
        bw.close();
    }
}