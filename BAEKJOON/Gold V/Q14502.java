import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;

class Q14502 {

    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, 1, 0, -1};
    static int N;
    static int M;
    static int[][] map;
    static List<int[]> viruses;
    static int res = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        viruses = new ArrayList<>();
        for (int x=0; x<N; x++) {
            st = new StringTokenizer(br.readLine());
            for (int y=0; y<M; y++) {
                map[x][y] = Integer.parseInt(st.nextToken());
                if (map[x][y] == 2) {
                    viruses.add(new int[]{x, y});
                }
            }
        }

        installWall(0);
        System.out.println(res);
    }

    private static void installWall(int cnt) {
        if (cnt == 3) {
            int[][] vmap = spreadVirus();
            checkSafeArea(vmap);
            return;
        }

        for (int x=0; x<N; x++) {
            for (int y=0; y<M; y++) {
                if (map[x][y] == 0) {
                    map[x][y] = 1;
                    installWall(cnt + 1);
                    map[x][y] = 0;
                }
            }
        }
    }

    private static int[][] spreadVirus() {
        int[][] vmap = copyWallMap();
        
        for (int i=0; i<viruses.size(); i++) {
            Queue<int[]> q = new LinkedList<>();
            q.add(viruses.get(i));

            while (!q.isEmpty()) {
                int v[] = q.poll();
                for (int k=0; k<4; k++) {
                    int nx = v[0] + dx[k];
                    int ny = v[1] + dy[k]; 

                    if (nx >= 0 && nx < N && ny >= 0 && ny < M && vmap[nx][ny] == 0) {
                        vmap[nx][ny] = 2;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }
        
        return vmap;
    }

    private static int[][] copyWallMap() {
        int[][] vmap = new int[N][M];
        for (int x=0; x<N; x++) {
            for (int y=0; y<M; y++) {
                vmap[x][y] = map[x][y];
            }
        }
        return vmap;
    }

    private static void checkSafeArea(int[][] vmap) {
        int cnt = 0;
        for (int x=0; x<N; x++) {
            for (int y=0; y<M; y++) {
                if (vmap[x][y] == 0) {
                    cnt++;
                }
            }
        }

        res = Math.max(cnt, res);
    }
}
