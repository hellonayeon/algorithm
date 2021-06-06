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

        int[] days = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {

            String Input = br.readLine();

            String year = Input.substring(0, 4);
            String month = Input.substring(4, 6);
            String date = Input.substring(6);
        
            if( Integer.parseInt(date) <= days[Integer.parseInt(month)] ) {
                bw.write("#" + test_case + " " + year + "/" + month + "/" + date + "\n");
            }
            else {
                bw.write("#" + test_case + " -1" + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}