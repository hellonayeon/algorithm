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

        int group = 0; // 총 그룹 수
        int cnt = 0; // 현재 그룹에 포함된 모험가의 수
        for (int i=0; i<N; i++) {
            cnt++;

            if (cnt >= people[i]) { // 모험가의 수가 현재 모험가의 공포도보다 같거나 큰 경우 그룹 결성
                group++;
                cnt = 0;
            }

        }

        System.out.println(group);
    }
}