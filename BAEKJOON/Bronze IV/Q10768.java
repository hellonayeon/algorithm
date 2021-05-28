import java.io.*;

class Q10768 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int m = Integer.parseInt(br.readLine());
        int d = Integer.parseInt(br.readLine());
        br.close();

        if (m < 2 || (m == 2 && d < 18))
            bw.write("Before");
        else if (m > 2 || (m == 2 && d >18))
            bw.write("After");
        else
            bw.write("Special");

        bw.flush();
        bw.close();

    }
}