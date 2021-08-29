import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.HashMap;

class Q1018 {

    static HashMap<Character, Character> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] size = br.readLine().split(" ");
        int N = Integer.parseInt(size[0]); // row
        int M = Integer.parseInt(size[1]); // col

        // 입력 체스판
        char[][] board = new char[N][M];
        for(int r = 0; r < N; r++)
            board[r] = br.readLine().toCharArray();

        map = new HashMap<>();
        map.put('B', 'W');
        map.put('W', 'B');


        int min = 64; // 8 x 8
        for(int r = 0; r <= N-8; r++) {
            for(int c = 0; c <= M-8; c++) {
                char[][] arr = copyArray(board, N, M);
                int cnt = check(arr, r, c);
                min = Math.min(min, cnt);
            }
        }

        System.out.print(min);
    }

    public static int check(char[][] arr, int sr, int sc) {
        int cnt = 0;

        for(int r = sr; r < sr + 8 - 1; r++) {
            for(int c = sc; c < sc + 8 - 1; c++) {
                char C = arr[r][c];
                char R = arr[r][c+1];
                char B = arr[r+1][c];
                char D = arr[r+1][c+1];

                // 바꿔야 하는 경우
                if(C != D) {
                    arr[r+1][c+1] = C;
                    cnt++;
                }
                if(C == R) {
                    arr[r][c+1] = map.get(C);
                    cnt++;
                }
                if(C == B) {
                    arr[r+1][c] = map.get(C);
                    cnt++;
                }
            }
        }

        // 첫 번째 칸의 색과 반대되는 색으로 칠할 경우
        // 비교하는 첫 번째 칸의 색이 'B'라고 해서 꼭 B 부터 칠해야 하는 것이 아니기 때문.
        return Math.min(cnt, 64-cnt);
    }

    public static char[][] copyArray(char[][] arr, int N, int M) {
        char[][] b = new char[N][M];
        for(int r = 0; r < arr.length; r++)
            b[r] = arr[r].clone();
        
        return b;
    }
}