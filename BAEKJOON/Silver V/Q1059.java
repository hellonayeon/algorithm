import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine()); // L
        StringTokenizer S = new StringTokenizer(br.readLine()); // S
        int n = Integer.parseInt(br.readLine()); // n
        int ans = 0;

        int[] arr = new int[L+2];
        arr[0] = 0;
        int idx = 1;
        while(S.hasMoreTokens()) {
            arr[idx++] = Integer.parseInt(S.nextToken());
            // 집합에 n과 동일한 원소가 있는 경우
            // 좋은 구간이 나올 수 없다.
            if(arr[idx-1] == n) {
                System.out.println(ans);
                return;
            }
        }
        arr[idx] = n;
        Arrays.sort(arr);

        for(int i = 0; i < arr.length; i++) {
            if(n == arr[i]) {
                int l = arr[i-1]+1;
                int r = arr[i+1]-1;
                ans = (n - l) * (r - n + 1) + (r - n);

                break;
            }
        }

        System.out.println(ans);
    }
}