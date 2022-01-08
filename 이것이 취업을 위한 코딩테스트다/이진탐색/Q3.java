import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

class Q3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int max = 0;
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }

        int start = 0, end = max, ans = 0;
        while(start <= end) {
            int mid = (start + end) / 2;

            int sum = 0;
            for(int len : arr) {
                if(len > mid) {
                    sum += len - mid;
                }
            }

            if(sum < M) {
                end = mid - 1;
            }
            // 적어도 M을 가질 수 있는 절단기 높이의 '최댓값'
            // 계속해서 높이를 높여가며 M과 가장 근접하도록 찾기
            else {
                ans = mid;
                start = mid + 1;
            }
        }

        System.out.println(ans);
    }
}