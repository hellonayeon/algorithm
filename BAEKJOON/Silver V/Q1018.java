import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// 배열 복사해서 일일이 바꿔가며 체크 X
// 시작 색이 'B'인 경우 & 'W'인 경우 (cnt, 64-cnt)

class Q1018 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] size = br.readLine().split(" ");
        int N = Integer.parseInt(size[0]); // row
        int M = Integer.parseInt(size[1]); // col

        // 입력 체스판
        char[][] board = new char[N][M];
        for(int r = 0; r < N; r++)
            board[r] = br.readLine().toCharArray();


        int min = 64; // 8 x 8
        for(int r = 0; r <= N-8; r++) {
            for(int c = 0; c <= M-8; c++) {
                min = Math.min(min, check(board, r, c));
            }
        }

        System.out.print(min);
    }

    public static int check(char[][] board, int sr, int sc) {
        int cnt = 0;

        for(int r = sr; r < sr + 8; r++) {
            for(int c = sc; c < sc + 8; c++) {
                // 짝,홀칸의 체스 색깔 검사
                if(board[r][c] != ((r + c) % 2 == 0 ? 'B' : 'W')) cnt++;
            }
        }

        // 첫 번째 칸의 색과 반대되는 색으로 칠할 경우
        // 비교하는 첫 번째 칸의 색이 'B'라고 해서 꼭 B 부터 칠해야 하는 것이 아니기 때문.
        return Math.min(cnt, 64-cnt);
    }
}