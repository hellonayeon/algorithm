import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

class Main {

    private static int[][] mv = { {0, -1}, {0, 1}, {-1, 0}, {1, 0} }; // 상하좌우 이동 좌표

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        for(int i = 0; i < tc; i++) {
            
            String[] input = br.readLine().split(" ");
            int M = Integer.parseInt(input[0]); // 배추밭의 가로 길이
            int N = Integer.parseInt(input[1]); // 배추밭의 세로 길이
            int K = Integer.parseInt(input[2]); // 배추가 심어져 있는 개수

            int[][] field = new int[N][M];
            boolean[][] visit = new boolean[N][M];

            // 배추가 심어진 위치 표시
            for(int k = 0; k < K; k++) {
                String[] pos = br.readLine().split(" ");
                int x = Integer.parseInt(pos[0]);
                int y = Integer.parseInt(pos[1]);
                field[y][x] = 1;
            }

            int bug = 0; // 필요한 벌레 수
            for(int r = 0; r < N; r++) {
                for(int c = 0; c < M; c++) {
                    if(!visit[r][c] && field[r][c] == 1) {
                        bfs(field, visit, c, r, M, N);
                        bug++;
                    }
                }
            }
            System.out.println(bug);
        }
    }

    public static void bfs(int[][] field, boolean[][] visit, int x, int y, int w, int h) {
        visit[y][x] = true;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});

        // 상하좌우에 인접한 배추가 있는지 체크
        while(!queue.isEmpty()) {
            int[] pos = queue.poll();
            int cx = pos[0];
            int cy = pos[1];

            for(int i = 0; i < mv.length; i++) {
                int nx = cx + mv[i][0];
                int ny = cy + mv[i][1];

                // 확인하고자 하는 위치가 배추밭의 크기를 넘어간 경우
                if(nx < 0 || nx >= w || ny < 0 || ny >= h) continue;
                
                if(!visit[ny][nx] && field[ny][nx] == 1) {
                    visit[ny][nx] = true;
                    queue.offer(new int[]{nx, ny});
                }    
            }
        }
    }
}