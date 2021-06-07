import java.io.*;

class Q21598 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        br.close();
        
        for(int i = 0; i < N; i++)
            bw.write("SciComLove\n");
        
        bw.flush();
        bw.close();
    }
}