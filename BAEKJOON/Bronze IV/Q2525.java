import java.io.*;
import java.util.StringTokenizer;

class Q2525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " "); // first input line
        
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        
        int C = Integer.parseInt(br.readLine()); // second input line
        
        int min = (B+C) % 60;
        int hour = (A + ( (B+C) / 60) ) % 24;

        System.out.println( hour+ " " + min );
    }
}