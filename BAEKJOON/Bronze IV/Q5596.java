import java.io.*;
import java.util.StringTokenizer;

class Q5596 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        
        int S=0, T=0;
        while(st1.hasMoreTokens()) {
            S += Integer.parseInt(st1.nextToken());
            T += Integer.parseInt(st2.nextToken());
        }
        
        if(S >= T)
            System.out.println(S);
        else
            System.out.println(T);

    }
}