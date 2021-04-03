import java.io.*;

class Q3046 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] str = br.readLine().split(" ");
        int R1 = Integer.parseInt(str[0]);
        int S = Integer.parseInt(str[1]); // S = (R1+R2)/2
        
        int R2 = S*2 - R1;
        
        System.out.println(R2);
    }
}
