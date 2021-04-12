import java.io.*;
import java.util.StringTokenizer;

class Q15964 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        Long A = Long.parseLong(st.nextToken());
        Long B = Long.parseLong(st.nextToken());
        
        System.out.print((A+B)*(A-B));
    }
}