import java.io.*;
import java.util.StringTokenizer;

public class Q11004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine() , " ");
        int board[] = new int[N];
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;

        // left : 입력된 수들 중 가장 작은 값
        // right: 입력된 수들 중 가장 큰 값
        for(int i = 0; i < N; i++){
            board[i] = Integer.parseInt(st.nextToken());
            if(board[i] < left)
                left = board[i];
            if(board[i] > right)
                right = board[i];
        }

        // 탐색할 범위를 반씩 줄여나가며
        // K번째로 큰 수 찾기 (mid)
        int ans = 0;
        while(left <= right){
            int mid = (left+right)/2;
            int count = 0;
            for(int i = 0; i < N; i++){
                if(board[i] <= mid)
                    count++;
            }

            // count가 K보다 크거나 같은 경우는
            // K번째 수가 mid보다 작다는 의미이다.
            if(count >= K){
                right = mid-1;
                ans = mid;
            }else{
                left = mid+1;
            }
        }
        
        System.out.println(ans);
    }
}