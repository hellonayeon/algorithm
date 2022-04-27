import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

import java.util.Queue;
import java.util.LinkedList;

import java.io.FileInputStream;

class Q2117 {

    final static int[] dx = {-1, 0, 1, 0};
    final static int[] dy = {0, 1, 0, -1};

    static int N;
    static int M;
    static int[][] map;
    static boolean[][] visit;
    static int res;
    
    static class Coordinate {
        int x;
        int y;

        protected Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        protected boolean isOutOfMap() {
            return (x<0 || y<0 || x>=N || y>=N);
        }
    }

    public static void main(String args[]) throws IOException {
        System.setIn(new FileInputStream("res/Q2117_input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            map = new int[N][N];
            for (int x=0; x<N; x++) {
                st = new StringTokenizer(br.readLine());
                for (int y=0; y<N; y++) {
                    map[x][y] = Integer.parseInt(st.nextToken());
                }
            }

            res = 0;
            for (int x=0; x<N; x++) {
                for (int y=0; y<N; y++) {
                    Queue<Coordinate> queue = new LinkedList<>();
                    visit = new boolean[N][N];

                    queue.add(new Coordinate(x, y));
                    visit[x][y] = true;

                    int house = (map[x][y] == 0 ? 0 : 1);
                    bfs(queue, 1, house);
                }
            }
            sb.append("#").append(tc).append(" ").append(res).append("\n");
        }
        System.out.println(sb);
    }

    private static void bfs(Queue<Coordinate> queue, int K, int house) {
        calcProfit(K, house);
        if (haveVisitedAll()) {
            return;
        }
              
        Queue<Coordinate> tmpQueue = new LinkedList<>();
        while (!queue.isEmpty()) {
            Coordinate c = queue.poll();
            
            for (int i=0; i<4; i++) {
                int nx = c.x + dx[i];
                int ny = c.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visit[nx][ny]) {
                    visit[nx][ny] = true;

                    if (map[nx][ny] == 1) {
                        house++;
                    }
                    tmpQueue.add(new Coordinate(nx, ny));
                }
            }
        }

        bfs(tmpQueue, K+1, house);
    }

    private static boolean haveVisitedAll() {
        for (int x=0; x<N; x++) {
            for (int y=0; y<N; y++) {
                if (!visit[x][y]) {
                    return false;
                } 
            }
        }
        return true;
    }

    private static void calcProfit(int K, int house) {
        int profit = (house*M) - ((K*K) + (K-1)*(K-1));
        if (profit >= 0) {
            res = Math.max(house, res);
        }  
    }
}