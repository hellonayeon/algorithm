import java.io.*;

class Q14645 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().split(" ")[0]);
        
        for(int i=0; i<N; i++)
            br.readLine();
        
        System.out.print("비와이");
    }
}
