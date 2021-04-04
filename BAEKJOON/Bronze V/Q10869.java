import java.io.*;
import java.util.StringTokenizer;

class Q10869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        
        StringBuilder sb = new StringBuilder();
        sb.append(A+B).append("\n")
          .append(A-B).append("\n")
          .append(A*B).append("\n")
          .append(A/B).append("\n")
          .append(A%B);
        
        System.out.print(sb);
    }
}