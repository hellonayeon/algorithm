import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Q1780 {

    static int[][] matrix;
    static int[] cnt = new int[3]; // -1, 0, 1

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        matrix = new int[N][N];
        for(int r = 0; r < N; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int c = 0; c < N; c++) {
                matrix[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        cut(0, 0, N);

        System.out.println(cnt[0]);
        System.out.println(cnt[1]);
        System.out.println(cnt[2]);
    }

    public static void cut(int sr, int sc, int size) {
        if(check(sr, sc, size)) return;

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                cut(sr + i*(size/3), sc + j*(size/3), size/3);
            }
        }
    }

    public static boolean check(int sr, int sc, int size) {
        int val = matrix[sr][sc];
        for(int i = sr; i < sr+size; i++) {
            for(int j = sc; j < sc+size; j++) {
                if(matrix[i][j] != val) return false;
            }
        }

        cnt[val+1]++;
        return true;
    }
}