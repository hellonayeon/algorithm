import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

class Position {
    int x;
    int y;
    int dis;
    
    public Position(int x, int y, int dis) {
        this.x = x;
        this.y = y;
        this.dis = dis;
    }
}

class Q2178 {

    private static int N; // 미로의 세로 길이
    private static int M; // 미로의 가로 길이
    private static int[][] miro;
    private static boolean[][] visit; // 방문한 곳 체크 변수
    private static int shortest_dis; // 지나야하는 최소 칸 수

    private static int[][] mv = { {0, -1}, {0, 1}, {-1, 0}, {1, 0} }; // 상하좌우 이동 좌표

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] size = br.readLine().split(" ");
        N = Integer.parseInt(size[0]);
        M = Integer.parseInt(size[1]);

        miro = new int[N][M];
        visit = new boolean[N][M];
        shortest_dis = N * M;

        // 미로 설정
        for(int r = 0; r < N; r++) {
            String m = br.readLine();
            for(int c = 0; c < M; c++) {
                miro[r][c] = m.charAt(c) - '0';
            }
        }

        //dfs(0, 0, 0);
        bfs(new Position(0, 0, 1));

        System.out.println(shortest_dis);
    }

    public static void bfs(Position pos) {
        visit[pos.y][pos.x] = true;

        Queue<Position> queue = new LinkedList<>();
        queue.offer(pos);

        while(!queue.isEmpty()) {
            Position cur = queue.poll();

            for(int i = 0; i < mv.length; i++) {
                int nx = cur.x + mv[i][0];
                int ny = cur.y + mv[i][1];

                // 목적지 도착까지 걸린 거리 중 최단 거리 찾기
                if(nx == M - 1 && ny == N - 1) {
                    shortest_dis = (cur.dis + 1 <= shortest_dis) ? cur.dis + 1 : shortest_dis;
                    return;
                }
    
                if(nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
    
                if(!visit[ny][nx] && miro[ny][nx] == 1) {
                    visit[ny][nx] = true;
                    queue.add(new Position(nx, ny, cur.dis + 1));
                }
            }
        }
    }
}