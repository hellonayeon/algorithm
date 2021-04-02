import java.io.*;

class Q2914 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] str = br.readLine().split(" ");
        int A = Integer.parseInt(str[0]);
        int I = Integer.parseInt(str[1]);
        
        System.out.println(A * (I-1) + 1);
    }
}
