import java.io.*;

class Q15921 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        br.readLine();
        br.close();
        
        if(N != 0)
            bw.write("1.00");
        else
            bw.write("divide by zero");
        
        bw.flush();
        bw.close();
    }
}