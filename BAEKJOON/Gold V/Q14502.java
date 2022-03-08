// [출처] https://minhamina.tistory.com/69

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

class Q14502 {
    final static int[] dx = { 0, 0, -1, 1 };
    final static int[] dy = { -1, 1, 0, 0 };

    static int N, M; // 세로, 가로
    static int[][] map;
    static List<Position> virusPosList = new ArrayList<>();
    static int ans = 0;

    public static class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 2) {
                    virusPosList.add(new Position(i, j));
                }
            }
        }

        buildWall(0);

        System.out.println(ans);
    }

    private static void buildWall(int depth) {
        if (depth == 3) {
            int[][] copyMap = copyMap();
            spreadVirus(copyMap);
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    buildWall(depth + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    private static int[][] copyMap() {
        int[][] copyMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copyMap[i][j] = map[i][j];
            }
        }

        return copyMap;
    }

    private static void spreadVirus(int[][] copyMap) {
        Queue<Position> q = new LinkedList<>();

        for (int i = 0; i < virusPosList.size(); i++) {
            q.add(virusPosList.get(i));
        }

        while (!q.isEmpty()) {
            Position pos = q.poll();

            for (int k = 0; k < 4; k++) {
                int nx = pos.x + dx[k];
                int ny = pos.y + dy[k];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M || copyMap[nx][ny] != 0)
                    continue;

                copyMap[nx][ny] = 2;
                q.add(new Position(nx, ny));
            }
        }

        getSafetyArea(copyMap);
    }

    private static void getSafetyArea(int[][] copyMap) {
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyMap[i][j] == 0)
                    cnt++;
            }
        }

        ans = Math.max(cnt, ans);
    }
}