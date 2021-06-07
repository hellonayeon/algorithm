import java.io.*;

class Q20673 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int p = Integer.parseInt(br.readLine());
        int q = Integer.parseInt(br.readLine());
        br.close();

        if (q >= 30)
            bw.write("Red");
        else if (p <= 50 && q <= 10)
            bw.write("White");
        else
            bw.write("Yellow");

        bw.flush();
        bw.close();
    }
}
