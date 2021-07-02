import java.io.*;
import java.util.LinkedList;
import java.util.Queue;


class Position {
    int x;
    int y;
    int distance;

    public Position(int x, int y, int distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }
}

class Q2589 {

    private static int h; // 보물 지도의 세로 크기
    private static int w; // 보물 지도의 가로 크기
    private static char map[][]; // 보물지도
    private static boolean visit[][]; // 방문 여부 체크

    private static int[][] loc = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}}; // 지도의 상하좌우로 인접한 'L'을 확인하기 위한 좌표

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] size = br.readLine().split(" ");
        h = Integer.parseInt(size[0]);
        w = Integer.parseInt(size[1]);
        
        // 보물 지도 초기화
        map = new char[h][w];
        for(int i = 0; i < h; i++) {
            map[i] = br.readLine().toCharArray();
        }

        // 모든 'L'을 시작으로 탐색
        int ans = 0;
        visit = new boolean[h][w];
        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                if(map[i][j] == 'L') {
                    int dis = bfs(new Position(j, i, 0));
                    
                    visit = new boolean[h][w];
                    ans = (dis >= ans) ? dis : ans ;
                }
            }
        }

        System.out.println(ans);
    }

    public static int bfs(Position pos) {
        int dis = 0;

        Queue<Position> queue = new LinkedList<>();
        queue.offer(pos);

        visit[pos.y][pos.x] = true;

        while(!queue.isEmpty()) {
            Position cur = queue.poll();

            for(int k = 0; k < 4; k++) {
                int nx = cur.x + loc[k][0];
                int ny = cur.y + loc[k][1];

                // 지도 범위에서 벗어날 경우
                if (nx < 0 || nx >= w || ny < 0 || ny >= h) continue;
                
                if (!visit[ny][nx] && map[ny][nx] == 'L') {
                    visit[ny][nx] = true;
                    queue.add(new Position(nx, ny, cur.distance + 1));

                    dis = (cur.distance + 1 >= dis) ? cur.distance + 1 : dis ;
                }
            }
        }
        return dis;
    }
}