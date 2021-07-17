import java.io.*;

class Q2742 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int n = N; n >= 1; n--)
            sb.append(n).append("\n");

        System.out.print(sb);
    }
}