import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

class Q1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int idx = 0; idx < N; idx++)
            A[idx] = Integer.parseInt(st.nextToken());

        Arrays.sort(A);

        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int idx = 0; idx < M; idx++) {
            if(search(A, Integer.parseInt(st.nextToken()), 0, A.length-1))
                sb.append(1).append("\n");
            else sb.append(0).append("\n");
        }

        System.out.print(sb);
    }

    public static boolean search(int[] A, int X, int low, int high) {
        int mid;

        if(low <= high) {
            mid = (low + high) / 2;

            if(X == A[mid]) return true;
            else if(X < A[mid]) return search(A, X ,low, mid-1);  
            else return search(A, X, mid+1, high); 
        }

        return false;
    }
}