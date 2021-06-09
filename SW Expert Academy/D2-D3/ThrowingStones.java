import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

import java.io.FileInputStream;

class ThrowingStones {
    public static void main(String args[]) throws IOException {
        System.setIn(new FileInputStream("res/ThrowingStones_input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
 
        for (int tc = 1; tc <= T; tc++) {

            int N = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());

            System.out.println("#" + tc + " " + findShortDistance(N, st));
        }

        br.close();
    }

    public static String findShortDistance(int N, StringTokenizer st) {
        int distance = 100000;
        int count = 0;
        for (int i = 0; i < N; i++) {
            int tmp = Math.abs(Integer.parseInt(st.nextToken()));

            if (tmp < distance) {
                distance = tmp;
                count = 1;
            }
            else if (tmp == distance) {
                count += 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        return sb.append(distance).append(" ").append(count).toString();

    }
}