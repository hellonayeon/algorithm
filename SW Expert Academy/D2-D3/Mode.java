import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.io.IOException;

import java.util.StringTokenizer;

import java.io.FileInputStream;

class Mode {
    public static void main(String args[]) throws IOException {
        System.setIn(new FileInputStream("res/Mode_input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int test_case = 1; test_case <= T; test_case++) {
            test_case = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] scores = new int[101];
            while(st.hasMoreTokens()) {
                int idx = Integer.parseInt(st.nextToken());
                scores[idx]++;
            }

            int mode = -1, count = 0;
            for(int idx = 1; idx < scores.length; idx++) {
                if(scores[idx] >= count && idx >= mode) {
                    mode = idx;
                    count = scores[idx];
                }
                    
            }

            sb.append("#").append(test_case).append(" ").append(mode).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }


}