import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import java.util.Queue;
import java.util.LinkedList;

class Q7569 {

    // 위 아래 앞 뒤 좌 우
    static int[] dx = {0, 0, 0, 0, -1, 1};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {-1, 1, 0, 0, 0, 0};

    static int M;
    static int N;
    static int H;

    static int[][][] box;
    static int numberOfDays;

    static Queue<Tomato> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        box = new int[H][N][M];
        queue = new LinkedList<>();

        for (int i=0; i<H; i++) {
            for (int j=0; j<N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k=0; k<M; k++) {
                    box[i][j][k] = Integer.parseInt(st.nextToken());

                    if (box[i][j][k] == 1) {
                        queue.add(new Tomato(k, j, i, 1));
                    }
                }
            }
        }

        spread();
        numberOfDays = areAllTomatoesRipe() ? numberOfDays - 1 : -1;

        System.out.println(numberOfDays);
    }

    public static void spread() {
        while (!queue.isEmpty()) {
            Tomato tomato = queue.poll();

            for (int k = 0; k < 6; k++) {
                int nx = tomato.x + dx[k];
                int ny = tomato.y + dy[k];
                int nz = tomato.z + dz[k];
                if (nx < 0 || nx >= M || ny < 0 || ny >= N || nz < 0 || nz >= H || box[nz][ny][nx] != 0) continue;

                box[nz][ny][nx] = tomato.day;
                queue.add(new Tomato(nx, ny, nz, tomato.day + 1));
            }
            
            numberOfDays = tomato.day;
        }
    }

    public static boolean areAllTomatoesRipe() {
        for (int i=0; i<H; i++) {
            for (int j=0; j<N; j++) {
                for (int k=0; k<M; k++) {
                    if (box[i][j][k] == 0) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    static class Tomato {
        int x;
        int y;
        int z;
        int day;

        public Tomato(int x, int y, int z, int day) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.day = day;
        }
    }
}