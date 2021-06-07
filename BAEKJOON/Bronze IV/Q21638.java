import java.io.*;
import java.util.StringTokenizer;

class Q21638 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        br.close();

        int t1 = Integer.parseInt(st1.nextToken());
        int v1 = Integer.parseInt(st1.nextToken());
        int t2 = Integer.parseInt(st2.nextToken());
        int v2 = Integer.parseInt(st2.nextToken());

        if(t2 < 0 && v2 >= 10) {
            System.out.println("A storm warning for tomorrow! Be careful and stay home if possible!");
            return;
        }
        if(t2 < t1) {
            System.out.println("MCHS warns! Low temperature is expected tomorrow.");
            return;
        }
        if(v2 > v1) {
            System.out.println("MCHS warns! Strong wind is expected tomorrow.");
            return;
        }
            
        System.out.println("No message");

    }
}