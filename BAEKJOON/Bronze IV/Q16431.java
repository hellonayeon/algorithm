import java.io.*;
import java.util.StringTokenizer;

class Q16431 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        StringTokenizer st3 = new StringTokenizer(br.readLine(), " ");
        br.close();
        
        int Br = Integer.parseInt(st1.nextToken());
        int Bc = Integer.parseInt(st1.nextToken());
        
        int Dr = Integer.parseInt(st2.nextToken());
        int Dc = Integer.parseInt(st2.nextToken());
        
        int Jr = Integer.parseInt(st3.nextToken());
        int Jc = Integer.parseInt(st3.nextToken());
        
        int bessie = Math.max(Math.abs(Jr - Br), Math.abs(Jc - Bc));
        int daisy = Math.abs(Jr - Dr) + Math.abs(Jc - Dc);
        
        if (bessie < daisy)
            bw.write("bessie");
        else if (bessie > daisy)
            bw.write("daisy");
        else
            bw.write("tie");
        
        bw.flush();
        bw.close();
    }
}
