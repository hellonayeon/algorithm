import java.io.*;

class Q20492 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        double res1 = N - (N*0.22);
        double res2 = N - (N*0.2*0.22);
        System.out.printf("%.0f %.0f", res1, res2); 
    }
}
