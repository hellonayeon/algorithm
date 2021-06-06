import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

import java.util.StringTokenizer;

import java.io.FileInputStream;

// Q2070. 큰 놈, 작은 놈, 같은 놈
class InequalitySign {
    public static void main(String args[]) throws IOException {
        System.setIn(new FileInputStream("res/InequalitySign_input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            char sign = (n1 == n2) ? '=' : (n1 > n2) ? '>' : '<' ;

            bw.write("#" + test_case + " " + sign + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
