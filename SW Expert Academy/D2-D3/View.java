import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

import java.io.FileInputStream;

// [S/W 문제해결 기본] 1일차 - View
class View {
    public static void main(String args[]) throws IOException {
        System.setIn(new FileInputStream("res/View_input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        for (int test_case = 1; test_case <= 10; test_case++) {

            int bCount = Integer.parseInt(br.readLine());

            String[] str = br.readLine().split(" ");
            
            int[] b = new int[bCount];
            for(int idx = 0; idx < bCount; idx++) {
                b[idx] = Integer.parseInt(str[idx]);
            }


            int sum = 0;
            for(int i = 2; i < bCount - 2; i++) {
                int view = 256;
                for(int j = i - 2; j <= i + 2; j++) {
                    if(j == i) continue;

                    int diff = b[i] - b[j];
                    if( diff <= 0 ) {
                        view = 0;
                        break;
                    }
                    if( diff > 0 && diff < view) {
                        view = diff;
                    }  
                
                }
                sum += view;
            }

            sb.append("#").append(test_case).append(" ").append(sum).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();

        br.close();
        bw.close();
    }
}