import java.io.*;

class Q2884 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        br.close();

        int H = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);

        if(M - 45 < 0) {
            M = M - 45 + 60;
            H -= 1;
            if(H < 0) H += 24;
        }
        else M -= 45;

        System.out.print(H + " " + M);
    }
}