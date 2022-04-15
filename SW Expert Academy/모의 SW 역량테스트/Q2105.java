import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

import java.io.FileInputStream;

class Q2105 {

    static int N;
    static int[][] map;
    static boolean[] ate;
    static int res;

    // 좌하, 우하, 우상, 좌상
    static int[] dx = {1, 1, -1, -1};
    static int[] dy = {-1, 1, 1, -1};

    public static void main(String args[]) throws IOException {
        System.setIn(new FileInputStream("res/Q2105_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];

            // NxN 디저트 종류
            StringTokenizer st;
            for (int x=0; x<N; x++) {
                st = new StringTokenizer(br.readLine());
                for (int y=0; y<N; y++) {
                    map[x][y] = Integer.parseInt(st.nextToken());
                }
            }

            res = -1;
            for (int x=0; x<N-2; x++) {
                for (int y=1; y<N-1; y++) {
                    ate = new boolean[101];
                    ate[map[x][y]] = true;
                    tour(x, y, x, y, 0, 0);
                    ate[map[x][y]] = false;
                }
            }

            sb.append("#").append(tc).append(" ").append(res).append("\n");
        }

        System.out.println(sb);
    }

    /**
     * @param cx  현재 행 좌표
     * @param cy  헌재 열 좌표
     * @param sx  시작 행 좌표
     * @param sy  시작 열 좌표
     * @param d   방향 (한 방향으로 탐색, 이전에 거쳤던 방향으로 돌아가지 않기 위함)
     * @param cnt 디저트 종류 개수
     */
    private static void tour(int cx, int cy, int sx, int sy, int d, int cnt) {
        for (int k=d; k<4; k++) {
            int nx = cx + dx[k];
            int ny = cy + dy[k];

            // 시작점으로 돌아온 경우
            if (cnt >= 3 && nx == sx && ny == sy) {
                res = Math.max(res, cnt + 1);
                return;
            }

            // 범위를 벗어난 경우
            if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
            // 이미 먹은 디저트 종류인 경우
            if (ate[map[nx][ny]]) continue;

            ate[map[nx][ny]] = true;
            tour(nx, ny, sx, sy, k, cnt + 1);
            ate[map[nx][ny]] = false;
        }
    }
}
