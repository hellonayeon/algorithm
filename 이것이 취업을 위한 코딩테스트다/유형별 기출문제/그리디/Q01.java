import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import java.util.Arrays;

class Q01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] people = new int[N];
        for (int i=0; i<N; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(people);

        int group = 0;
        for (int i=N-1; i>=0; i--) {
            group++;

            int cnt = people[i];
            while (cnt-- > 1) {
                i--;
            }
        }

        System.out.println(group);
    }
}