import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.io.FileInputStream;

class DateCalculator {

    static int[] days = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    
    static int month1;
    static int date1;
    static int month2;
    static int date2;

    public static void main(String args[]) throws IOException {
        System.setIn(new FileInputStream("res/DateCalculator_input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            month1 = Integer.parseInt(st.nextToken());
            date1 = Integer.parseInt(st.nextToken());
            month2 = Integer.parseInt(st.nextToken());
            date2 = Integer.parseInt(st.nextToken());

            int res = calcDate(month1, date1, month2, date2);
            System.out.println("#" + tc + " " + res);
        }
    }

    public static int calcDate(int month1, int date1, int month2, int date2) {

        int d = days[month1] - date1 + 1;

        if(month1 == month2) {
            return d;
        }
        
        for(int m = month1 + 1; m < month2; m++) {
            d += days[m];
        }

        return d += date2;
    }
}