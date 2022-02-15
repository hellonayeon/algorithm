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

    static int numberOfDays;

    static Queue<Tomato> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        box = new int[N][M];
        queue = new LinkedList<>();

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());

                if (box[i][j] == 1) {
                    queue.add(new Tomato(i, j, 1));
                }
            }
        }

        spread();
        numberOfDays = areAllTomatoesRipe() ? numberOfDays - 1 : -1;

        System.out.println(numberOfDays);

    }

    private static void spread() {
        while (!queue.isEmpty()) {
            Tomato tomato = queue.poll();
            
            for (int k=0; k<4; k++) {
                int nx = tomato.x + dx[k];
                int ny = tomato.y + dy[k];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && box[nx][ny] == 0) {
                    box[nx][ny] = tomato.day;
                    queue.add(new Tomato(nx, ny, tomato.day + 1));
                }
            }

            numberOfDays = tomato.day;
        }
    }

    private static boolean areAllTomatoesRipe() {
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (box[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }  

    static class Tomato {
        int x;
        int y;
        int day;
    
        public Tomato(int x, int y, int day) {
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }
}