import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

import java.util.StringTokenizer;

import java.io.FileInputStream;

// Q2043. 서랍의 비밀번호
class PasswordOfDrawer {
    public static void main(String args[]) throws IOException {
        System.setIn(new FileInputStream("res/PasswordOfDrawer_input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        int P = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int res = P - K + 1;
        bw.write(String.valueOf(res));
        bw.flush();
        bw.close();
    }
}
