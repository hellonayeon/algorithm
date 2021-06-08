import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.IOException;

import java.io.FileInputStream;

class Sum {
    public static void main(String args[]) throws IOException {
        System.setIn(new FileInputStream("res/Sum_input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = 0;
        while (tc != 10) {
            tc = Integer.parseInt(br.readLine());

            int[] res = new int[202];
            for (int i = 0; i < 100; i++) {
                String[] str = br.readLine().split(" ");

                for (int j = 0; j < 100; j++) {
                    res[i] += Integer.parseInt(str[j]);
                    res[j + 100] += Integer.parseInt(str[j]);
                }

                res[200] += Integer.parseInt(str[i]);
                res[201] += Integer.parseInt(str[99 - i]);
            }

            Arrays.sort(res);
            System.out.println("#" + tc + " " + res[201]);
        }
    }
}