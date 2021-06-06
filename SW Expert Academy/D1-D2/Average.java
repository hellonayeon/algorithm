import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.io.IOException;

import java.io.FileInputStream;

// Q2071. 평균값 구하기
class Average {
    public static void main(String args[]) throws IOException {
        System.setIn(new FileInputStream("res/Average_input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            double sum = 0;
            while(st.hasMoreTokens()) {
                sum += Double.parseDouble(st.nextToken());
            }
            
            double avg = sum / 10;
            bw.write("#" + test_case + " " + String.format("%.0f", avg) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}