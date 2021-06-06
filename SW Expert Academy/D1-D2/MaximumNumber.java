import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

import java.util.StringTokenizer;

import java.io.FileInputStream;

// Q2068. 최대수 구하기
class MaximumNumber {
    public static void main(String args[]) throws IOException {
        System.setIn(new FileInputStream("res/MaximumNumber_input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int max = 0;
            while(st.hasMoreTokens()) {
                int num = Integer.parseInt(st.nextToken());
                if( num > max ) max = num;
            }

            bw.write("#" + test_case + " " + max + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}