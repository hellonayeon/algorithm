import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

import java.io.FileInputStream;

// Q2019. 더블더블
class DoubleDouble {
    public static void main(String args[]) throws IOException {
        System.setIn(new FileInputStream("res/DoubleDouble_input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        int num = 1;
        for (int i = 0; i < n; i++) {
            sb.append(num).append(" ");
            num *= 2;
        }
        sb.append(num);

        bw.write(sb.toString());
        bw.flush();

        br.close();
        bw.close();
    }
}