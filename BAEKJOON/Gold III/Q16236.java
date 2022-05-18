import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Q16236 {

    // 주변에 물고기가 많다면 우 -> 상 순으로
    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, -1, 0, 1};

    static int N;
    static int[][] map;
    static int[] fishes = new int[10];
    static Position baby;
    static int res = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        StringTokenizer st = new StringTokenizer(br.readLine());
    
        N = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for (int x=0; x<N; x++) {
            st = new StringTokenizer(br.readLine());
            for (int y=0; y<N; y++) {
                map[x][y] = Integer.parseInt(st.nextToken());
            
                if (map[x][y] == 9) {
                    baby = new Position(x, y);
                }
                else if (map[x][y] > 0) {
                    fishes[map[x][y]]++;
                    map[x][y] = 0;
                }
            }
        }

        eat(baby, 2, 0, 0);
        System.out.println(res);
    }

    public static void eat(Position cur, int size, int acc, int time) {
        if (size == acc) {
            size++;
            acc = 0;
        }

        if (!doesRemained(size, acc)) {
            res = Math.min(time, res);
            return;
        }

        for (int i=0; i<4; i++) {
            Position next = new Position(cur.x + dx[i], cur.y + dy[i]);

            if (next.x >=0 && next.x < N && next.y >= 0 && next.y < N) {
                int fish = map[next.x][next.y];

                // 작은 크기의 물고기인 경우: 먹기
                if (fish != 0 && fish < size) {
                    map[next.x][next.y] = 0;
                    fishes[fish]--;

                    eat(next, size + 1, acc + 1, time + 1);
                    
                    map[next.x][next.y] = fish;
                    fishes[fish]++;
                }
                
                // 같은 크기의 물고기 또는 벽인 경우: 지나치기
                else if (fish == 0 || fish == size) {
                    eat(next, size, acc, time + 1);
                }
            }
        }
    } 

    public static boolean doesRemained(int size, int acc) {
        int remain = 0;
        for (int i=1; i<size; i++) {
            remain += fishes[i];
        }

        if (remain != 0) {
            return true;
        }
        else {
            return false;
        }
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
