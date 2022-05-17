import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;


class Q17142 {

    final static int[] dx = {-1, 0, 1, 0};
    final static int[] dy = {0, 1, 0, -1};
    
    static int N;
    static int M;
    static int[][] map;
    static List<Position> viruses;
    static List<Position> activeViruses;
    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        viruses = new ArrayList<>();
        activeViruses = new ArrayList<>();
        for (int x=0; x<N; x++) {
            st = new StringTokenizer(br.readLine());
            for (int y=0; y<N; y++) {
                map[x][y] = Integer.parseInt(st.nextToken())*(-1);

                if (map[x][y] == -2) {
                    viruses.add(new Position(x, y));
                }
            }
        }

        res = N*N;
        activate(0, new boolean[viruses.size()]);

        res = (res == N*N) ? -1 : res - 1;
        System.out.println(res);
    }

    private static int[][] copyMap() {
        int[][] vmap = new int[N][N];
        for (int x=0; x<N; x++) {
            for (int y=0; y<N; y++) {
                vmap[x][y] = map[x][y];
            }
        }
        return vmap;
    }

    private static void activate(int cnt, boolean[] active) {
        if (cnt == M) {
            int[][] vmap = copyMap();
            Queue<Position> q = new LinkedList<>();
            for (Position pos : activeViruses) {
                q.add(pos);
                vmap[pos.x][pos.y] = 1; // 빈 영역과 구분하기 위해 활성화된 바이러스는 1로 표시
            }
            
            spread(q, vmap);
            return;
        }

        for (int i=0; i<viruses.size(); i++) {
            if (!active[i]) {
                active[i] = true;
                activeViruses.add(viruses.get(i));
                activate(cnt + 1, active);
                active[i] = false;
                activeViruses.remove(viruses.get(i));
            }
            
        }
    }

    private static void spread(Queue<Position> q, int[][] vmap) {
        int time = 1;
        while (!q.isEmpty()) {
            Position pos = q.poll();

            for (int k=0; k<4; k++) {
                int nx = pos.x + dx[k];
                int ny = pos.y + dy[k];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if (vmap[nx][ny] == 0) {
                        vmap[nx][ny] = time = vmap[pos.x][pos.y] + 1;
                        q.add(new Position(nx, ny));
                    }
                }
            }
        }

        if (isAllSpread(vmap)) {
            res = Math.min(time, res);
        }
    }

    private static boolean isAllSpread(int[][] vmap) {
        for (int x=0; x<N; x++) {
            for (int y=0; y<N; y++) {
                if (vmap[x][y] == 0) {
                    return false;
                }
            }
        }
        return true;
    }


    static class Position {
        int x;
        int y;

        public Position (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}