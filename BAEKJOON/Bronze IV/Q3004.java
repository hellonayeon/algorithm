import java.io.*;

class Q3004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int row = N/2 + 1;
        int col = N - row + 2;
        
        System.out.println(row * col);
    }
}