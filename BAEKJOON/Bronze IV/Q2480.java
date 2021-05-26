import java.io.*;
import java.util.StringTokenizer;

class Q2480 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());
        int n3 = Integer.parseInt(st.nextToken());

        int prize;
        if (n1 == n2 && n1 == n3 && n2 == n3)
            prize = 10000 + 1000 * n1;
        else if (n1 == n2)
            prize = 1000 + 100 * n1;
        else if (n1 == n3)
            prize = 1000 + 100 * n1;
        else if (n2 == n3)
            prize = 1000 + 100 * n2;
        else
            prize = 100 * Math.max(Math.max(n1, n2), n3);

        System.out.println(prize);
    }
}