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
    static int blankCnt = 0;
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
                else if (map[x][y] == 0) {
                    blankCnt++;
                }
            }
        }

        res = N*N;
        activate(0, new boolean[viruses.size()], 0);

        res = (res == N*N) ? -1 : res;
        System.out.println(res);
    }

    private static void activate(int cnt, boolean[] active, int idx) {
        if (cnt == M) {
            if (activeViruses.size() < M) {
                return;
            }
            
            Queue<Position> q = new LinkedList<>();
            for (Position pos : activeViruses) {
                pos.setTime(0);
                q.add(pos);
            }
            
            spread(q, new boolean[N][N]);
            return;
        }

        for (int i = idx; i < viruses.size(); i++) {
            activeViruses.add(viruses.get(i));
            activate(cnt + 1, active, i + 1);
            activeViruses.remove(viruses.get(i));
        }
    }

    private static void spread(Queue<Position> q, boolean[][] visit) {
        int time = 0;
        int spreadCnt = 0;
        while (!q.isEmpty()) {
            Position pos = q.poll();

            for (int k=0; k<4; k++) {
                int nx = pos.x + dx[k];
                int ny = pos.y + dy[k];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if (map[nx][ny] == 0 && !visit[nx][ny]) {
                        visit[nx][ny] = true;
                        time = pos.time + 1;
                        q.add(new Position(nx, ny, time));
                        spreadCnt++;
                    }
                }
            }
            
        }

        if (blankCnt == spreadCnt) {
            res = Math.min(time, res);
        }
    }


    static class Position {
        int x;
        int y;
        int time;

        public Position (int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Position(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }

        public void setTime(int time) {
            this.time = time;
        }
    }
}