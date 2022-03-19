import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import java.util.Queue;
import java.util.LinkedList;

class Q7569 {

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int[] dz = {-1, 1};

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

            // 위아래로 인접한 익지 않은 토마토 확인
            for (int i=0; i<2; i++) {
                int nz = tomato.z + dz[i];
                if (nz < 0 || nz >= H || box[nz][tomato.y][tomato.x] != 0) continue;

                box[nz][tomato.y][tomato.x] = tomato.day;
                queue.add(new Tomato(tomato.x, tomato.y, nz, tomato.day + 1));
            }

            // 앞뒤좌우로 인접한 익지 않은 토마토 확인
            for (int j = 0; j < 4; j++) {
                int nx = tomato.x + dx[j];
                int ny = tomato.y + dy[j];
                if (nx < 0 || nx >= M || ny < 0 || ny >= N || box[tomato.z][ny][nx] != 0) continue;

                box[tomato.z][ny][nx] = tomato.day;
                queue.add(new Tomato(nx, ny, tomato.z, tomato.day + 1));
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