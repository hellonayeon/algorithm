import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

import java.io.FileInputStream;

// Q2056. 연월일 달력
class Calendar {
    public static void main(String args[]) throws IOException {
        System.setIn(new FileInputStream("res/Calendar_input.txt"));

        int[] days = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int test_case = 1; test_case <= T; test_case++) {

            String Input = br.readLine();

            int month = Integer.parseInt(Input.substring(4, 6));
            int date = Integer.parseInt(Input.substring(6, 8));

        
            if( (month >= 1 && month <= 12) && (date != 0 && days[month-1] - date >= 0) ) {
                sb.append("#").append(test_case).append(" ");
                sb.append(Input.substring(0, 4)).append("/").append(Input.substring(4, 6)).append("/").append(Input.substring(6, 8)).append("\n");
            }
            else {
                sb.append("#").append(test_case).append(" ").append(-1).append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}