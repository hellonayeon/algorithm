import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Q2798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int idx = 0; idx < N; idx++) {
            arr[idx] = Integer.parseInt(st.nextToken());
        }

        System.out.println(search(N, M, arr));
    }

    public static int search(int N, int M, int[] arr) {
        int max = 0;

        for(int i = 0; i < N-2; i++) {
            for(int j = i+1; j < N-1; j++) {
                for(int k = j+1; k < N; k++) {
                    int sum = arr[i] + arr[j] + arr[k];

                    if(sum == M) return M;
                    if(sum < M) {
                        max = (sum > max) ? sum : max;
                    }
                }
            }
        }

        return max;
    }
}