import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Q3 {

    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        map[x][y] = 1;
        int turn = 0, cnt = 1;
        while(true) {
            d = (d-1 < 0) ? 3 : d-1; // 왼쪽 방향으로 회전
            
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(map[nx][ny] == 0) {
                map[nx][ny] = 1;
                x = nx;
                y = ny;
                cnt++;
                turn = 0;
            }
            else {
                turn++;
            }

            if(turn == 4) {
                nx = x - dx[d];
                ny = y - dy[d];

                if(map[nx][ny] == 0) {
                    x = nx;
                    y = ny;
                }
                else break;

                turn++;
            }
        }
        System.out.println(cnt);
    }
}