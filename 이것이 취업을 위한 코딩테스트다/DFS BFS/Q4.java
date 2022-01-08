import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import java.util.Queue;
import java.util.LinkedList;


class Q4 {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N;
    static int M;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i=0; i<N; i++) {
            String row = br.readLine();
            for(int j=0; j<M; j++) {
                map[i][j] = row.charAt(j) - '0';
            }
        }

        bfs(0, 0);

        System.out.println(map[N-1][M-1]);
    }

    public static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        while(!queue.isEmpty()) {
            int[] xy = queue.poll();
            int cx = xy[0];
            int cy = xy[1];

            for(int i=0; i<4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if(map[nx][ny] == 0) continue;

                if(map[nx][ny] == 1) {
                    map[nx][ny] = map[cx][cy] + 1;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }
}