import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Q10026 {

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int N;
    static int res1 = 0;
    static int res2 = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        char[][] map1 = new char[N][N];
        char[][] map2 = new char[N][N];

        for (int x=0; x<N; x++) {
            String row = br.readLine();
            for (int y=0; y<N; y++) {
                char color = row.charAt(y);
                map1[x][y] = color;
                
                // 적록색약은 'R', 'G' 구분 불가능
                if (color == 'G') map2[x][y] = 'R';
                else map2[x][y] = color;
            }
        }

        boolean[][] visited;
        visited = new boolean[N][N];
        for (int x=0; x<N; x++) {
            for (int y=0; y<N; y++) {
                if (!visited[x][y]) {
                    dfs(map1[x][y], x, y, map1, visited);
                    res1++;
                }
            }
        }

        visited = new boolean[N][N];
        for (int x=0; x<N; x++) {
            for (int y=0; y<N; y++) {
                if (!visited[x][y]) {
                    dfs(map2[x][y], x, y, map2, visited);
                    res2++;
                }
            }
        }

        System.out.println(res1 + " " + res2);
    }

    public static void dfs(char color, int x, int y, char[][] map, boolean[][] visited) {
        for (int k=0; k<4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny] || map[nx][ny] != color) continue;

            visited[nx][ny] = true;
            dfs(color, nx, ny, map, visited);
        }
    } 
}