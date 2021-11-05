import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Q2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        double sum = 0;
        int[] arr = new int[N];
        int[] cnt = new int[8001];
        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[i] = num;
            sum += num;
            cnt[num+4000]++;
        }

        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        // 산술평균
        sb.append(Math.round(sum/N)).append("\n");

        // 중앙값
        sb.append(arr[N/2]).append("\n");

        // 최빈값
        int freq = -1, mode = 0, tmp = 0;
        boolean dup = false;
        for(int i = 0; i < cnt.length; i++) {
            if(cnt[i] == 0) continue;

            int num = i-4000;

            if(cnt[i] > freq) {
                mode = num;
                dup = false;

                freq = cnt[i];
            }
            else if(!dup && cnt[i] == freq) {
                tmp = num;
                dup = true;
            }
        }
        sb.append(dup ? tmp : mode).append("\n");

        // 범위
        sb.append(arr[N-1]-arr[0]).append("\n");

        System.out.print(sb);
    }
}
