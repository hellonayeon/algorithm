import java.io.*;

class Q20499 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] str = br.readLine().split("/");
        br.close();

        int K = Integer.parseInt(str[0]);
        int D = Integer.parseInt(str[1]);
        int A = Integer.parseInt(str[2]);

        if(K + A < D || D == 0)
            bw.write("hasu");
        else
            bw.write("gosu");

        bw.flush();
        bw.close();
    }
}
