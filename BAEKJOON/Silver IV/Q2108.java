import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Q2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        int median = 0, mode = 0;

        int[] arr = new int[8001];
        for(int i = 0; i < N; i++) {
            int val = Integer.parseInt(br.readLine());
            sum += val;
            arr[val+4000]++;

            if(val > max) max = val;
            if(val < min) min = val;
        }

        // 중간값, 최빈값
        int cnt = 0, freq = 0;
        boolean flag = false;
        for(int i = min+4000; i <= max+4000; i++) {
            // 중간값
            if(cnt < (N + 1) / 2) {
                cnt += arr[i];
                median = i - 4000;
            }

            // 최빈값
            if(arr[i] > freq) {
                freq = arr[i];
                mode = i-4000;
                flag = true;
            }
            else if(flag && arr[i] == freq) {
                mode = i-4000;
                flag = false;
            }
        }
        

        System.out.println(Math.round((double)sum/N));
        System.out.println(median);
        System.out.println(mode);
        System.out.println(max-min);
    }
}
