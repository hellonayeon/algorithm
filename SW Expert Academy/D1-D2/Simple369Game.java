import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

import java.io.FileInputStream;

// Q1926. 간단한 369게임
class Simple369Game {
    public static void main(String args[]) throws IOException {
        System.setIn(new FileInputStream("res/Simple369Game_input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int num = 1; num <= N; num++) {
            // clap count loop
            int clap = 0;
            int tmp = num;
            while (tmp > 0) {
                if (tmp % 10 != 0 && tmp % 10 % 3 == 0) {
                    sb.append("-");
                    clap++;
                }
                tmp /= 10;
            }
            if (clap == 0)
                sb.append(num);

            sb.append(" ");
        }

        bw.write(sb.toString());
        bw.flush();

        br.close();
        bw.close();
    }
}