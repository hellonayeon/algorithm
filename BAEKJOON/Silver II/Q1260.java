import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

class Q1260 {

    private static int N; // 정점의 개수
    private static int[][] map; // 정점들의 연결을 표시한 행렬
    private static boolean[] visit; // 방문한 정점 표시 변수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] setter = br.readLine().split(" ");
        N = Integer.parseInt(setter[0]); // 정점의 개수
        int M = Integer.parseInt(setter[1]); // 간선의 개수
        int V = Integer.parseInt(setter[2]); // 탐색을 시작할 정점 번호

        // 행렬 초기화
        map = new int[N+1][N+1]; // 정점의 번호로 행렬에 접근하기 위해
        for(int i = 0; i < M; i++) {
            String[] v = br.readLine().split(" ");
            int v1 = Integer.parseInt(v[0]);
            int v2 = Integer.parseInt(v[1]);

            map[v1][v2] = 1;
            map[v2][v1] = 1;
        }
        
        visit = new boolean[N + 1];
        dfs(V);
        System.out.println();

        visit = new boolean[N + 1];
        bfs(V);
        System.out.println();
    }

    public static void dfs(int V) {
        System.out.print(V + " "); // 방문 시점
        visit[V] = true;

        for(int i = 1; i <= N; i++) {
            if(!visit[i] && map[V][i] == 1) {
                dfs(i);
            }
        }
    }

    public static void bfs(int V) {
        visit[V] = true;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(V);

        while(!queue.isEmpty()) {
            int cv = queue.poll(); // 방문 시점
            System.out.print(cv + " ");

            for(int i = 1; i <= N; i++) {
                if(!visit[i] && map[cv][i] == 1) {
                    visit[i] = true;
                    queue.offer(i);
                }
            }
        }
    }
}