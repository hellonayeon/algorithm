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
    static List<Position> blanks;
    static List<Position> viruses;
    static int res = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        blanks = new ArrayList<>();
        viruses = new ArrayList<>();
        for (int x=0; x<N; x++) {
            st = new StringTokenizer(br.readLine());
            for (int y=0; y<M; y++) {
                map[x][y] = Integer.parseInt(st.nextToken());
                if (map[x][y] == 0) {
                    blanks.add(new Position(x, y));
                }
                else if (map[x][y] == 2) {
                    viruses.add(new Position(x, y));
                } 
            }
        }

        solution();
        System.out.println(res);
    }

    private static void solution() {
        for (int i=0; i<blanks.size()-2; i++) {
            for (int j=i+1; j<blanks.size()-1; j++) {
                for (int k=j+1; k<blanks.size(); k++) {
                    installWall(blanks.get(i), blanks.get(j), blanks.get(k), 1);
                    int[][] vmap = spreadVirus();
                    checkSafeArea(vmap);
                    installWall(blanks.get(i), blanks.get(j), blanks.get(k), 0);
                }
            }
        }
    }

    private static void installWall(Position p1, Position p2, Position p3, int wall) {
        map[p1.x][p1.y] = map[p2.x][p2.y] = map[p3.x][p3.y] = wall;
    }

    private static int[][] spreadVirus() {
        int[][] vmap = copyWallMap();
        
        for (int i=0; i<viruses.size(); i++) {
            Queue<Position> q = new LinkedList<>();
            q.add(viruses.get(i));

            while (!q.isEmpty()) {
                Position pos = q.poll();
                for (int k=0; k<4; k++) {
                    int nx = pos.x + dx[k];
                    int ny = pos.y + dy[k]; 

                    if (nx >= 0 && nx < N && ny >= 0 && ny < M && vmap[nx][ny] == 0) {
                        vmap[nx][ny] = 2;
                        q.add(new Position(nx, ny));
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
    
    static class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
