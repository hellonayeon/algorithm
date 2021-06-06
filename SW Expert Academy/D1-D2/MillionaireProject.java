import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

import java.io.FileInputStream;

import java.util.StringTokenizer;

// Q1859. 백만 장자 프로젝트
class MillionaireProject {
    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("res/MillionaireProject_input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T;
        T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine()); // N개의 자연수

            int[] n = new int[N];
            for (int idx = 0; idx < N; idx++) {
                n[idx] = Integer.parseInt(st.nextToken());
            }

            long profit = 0;
            int max = n[N - 1];

            for (int i = N - 2; i >= 0; i--) {
                if (n[i] > max)
                    max = n[i];
                else
                    profit += max - n[i];
            }

            sb.append("#").append(test_case).append(" ").append(profit).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }
}