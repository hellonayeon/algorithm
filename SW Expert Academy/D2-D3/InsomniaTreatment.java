import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.IOException;

import java.io.FileInputStream;

class InsomniaTreatment {

    static int[] count = new int[10];
    public static void main(String args[]) throws IOException {
        System.setIn(new FileInputStream("res/InsomniaTreatment_input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());

            int res = checkNumbers(N);
            Arrays.fill(count, 0);

            System.out.println("#" + tc + " " + res);
        }
    }

    public static int checkNumbers(int N) {
        int i = 0;
        int num = 0;
        while(!seeAllNumbers()) {
            num = N * ++i ;
            int tmp = num;
            while(tmp > 0) {
                count[tmp % 10] += 1;
                tmp /= 10;
            }
        }

        return num;
    }

    public static boolean seeAllNumbers() {
        for(int i = 0; i < 10; i++) {
            if(count[i] == 0) return false;
        }
        return true;
    }
}