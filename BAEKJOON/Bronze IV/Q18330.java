import java.io.*;

class Q18830 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int quota = 60 + k ;
        int res;
        if(n <= quota)
            res = n * 1500;
        else
            res = quota * 1500 + (n - quota) * 3000;

        bw.write(String.valueOf(res));
        bw.flush();
        bw.close();
    }
}