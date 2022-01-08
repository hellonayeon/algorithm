import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Q3 {

    static int N;
    static int M;
    static int[][] matrix;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        matrix = new int[N][M];
        for(int i=0; i<N; i++) {
            String row = br.readLine();
            for(int j=0; j<M; j++) {
                matrix[i][j] = row.charAt(j) - '0';
            }
        }

        int cnt = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(matrix[i][j] == 0) {
                    dfs(i, j);
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }

    public static void dfs(int x, int y) {
        // 얼음 틀의 범위를 벗어난 경우
        if(x < 0 || x >= N || y < 0 || y >= M) return;
        // 이미 확인했거나, 칸막이인 경우
        if(matrix[x][y] == 1) return;

        matrix[x][y] = 1;

        // 상,하,좌,우 탐색
        dfs(x-1, y);
        dfs(x+1, y);
        dfs(x, y-1);
        dfs(x, y+1);
    }
}