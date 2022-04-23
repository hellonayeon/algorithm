import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

import java.io.FileInputStream;

class Q1949 {
    // 상우하좌 좌표
    static final int[] dx = { -1, 0, 1, 0 };
    static final int[] dy = { 0, 1, 0, -1 };

    static int N;
    static int K;
    static int[][] map;
    static int highest;
    static int res;

    public static void main(String args[]) throws IOException {
        System.setIn(new FileInputStream("res/Q1949_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[N][N];

            highest = 0;
            for (int x = 0; x < N; x++) {
                st = new StringTokenizer(br.readLine());
                for (int y = 0; y < N; y++) {
                    map[x][y] = Integer.parseInt(st.nextToken());
                    highest = Math.max(map[x][y], highest);
                }
            }

            res = 0;
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < N; y++) {
                    boolean[][] visit = new boolean[N][N];
                    visit[x][y] = true;
                    findPath(visit, false, -1, 1, x, y);
                }

            }

            sb.append("#").append(tc).append(" ").append(res).append("\n");
        }
        System.out.println(sb);
    }

    /**
     * @param visit     방문 체크 배열
     * @param hasCut    산을 깎았는지 여부
     * @param preHeight 이전 봉우리 높이
     * @param depth     경로 길이
     * @param cx        현재 x 좌표
     * @param cy        현재 y 좌표
     */
    private static void findPath(boolean[][] visit, boolean hasCut, int preHeight, int depth, int cx, int cy) {
        if (map[cx][cy] == highest) {
            res = Math.max(depth, res);

            if (hasCut) {
                return;
            }
        }

        for (int k = 0; k < 4; k++) {
            int nx = cx + dx[k];
            int ny = cy + dy[k];

            if (nx < 0 || ny < 0 || nx >= N || ny >= N || visit[nx][ny])
                continue;

            visit[nx][ny] = true;
            if (map[nx][ny] > map[cx][cy]) {
                findPath(visit, hasCut, map[cx][cy], depth + 1, nx, ny);
            } else {
                int minCutLength = map[cx][cy] - map[nx][ny] + 1;
                if (!hasCut && minCutLength <= K && map[cx][cy] - minCutLength > preHeight) {
                    findPath(visit, true, map[cx][cy] - minCutLength, depth + 1, nx, ny);
                }
            }
            visit[nx][ny] = false;

        }
    }
}