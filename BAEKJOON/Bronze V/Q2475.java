import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));    
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int sum = 0;
        while(stk.hasMoreTokens())
            sum += Math.pow(Integer.parseInt(stk.nextToken()), 2);
        
        System.out.println(sum%10);
    }
}