import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import java.util.Queue;
import java.util.LinkedList;

class Q7576 {

    static StringTokenizer st;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int[][] box;
    static int M;
    static int N;

    static int ripeTomatoes;
    static int unripeTomatoes;
    static int day;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        box = new int[N][M];
        Queue<int[]> queue = new LinkedList<>();

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());

                if (box[i][j] == 0) {
                    unripeTomatoes++;
                }
                else if (box[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        
        calc(queue);
        day = (ripeTomatoes == unripeTomatoes) ? day : -1;
        
        System.out.println(day);
    }

    private static void calc(Queue<int[]> queue) {
        Queue<int[]> tmpQueue = new LinkedList<>();

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int x = pos[0];
            int y = pos[1];

            for (int k=0; k<4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M || box[nx][ny] != 0) {
                    continue;
                }

                box[nx][ny] = 1;
                ripeTomatoes++;
                tmpQueue.add(new int[]{nx, ny});
            }
            
        }
        
        if (!tmpQueue.isEmpty()) {
            day++;
            calc(tmpQueue);
        }
    }
}