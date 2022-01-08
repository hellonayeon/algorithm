import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Q2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder builder = new StringBuilder();
        for(int i=0; i<M; i++) {
            int req = Integer.parseInt(st.nextToken());
            builder.append(binarySearch(arr, req, 0, N-1)).append(" ");
        }

        System.out.println(builder);
    }

    public static String binarySearch(int[] arr, int target, int start, int end) {
        if(start > end) return "no";

        int mid = (start + end) / 2;

        if(target == arr[mid]) return "yes";

        if(target < arr[mid]) {
            return binarySearch(arr, target, start, mid-1);
        }
        else {
            return binarySearch(arr, target, mid+1, end);
        }
    }
}