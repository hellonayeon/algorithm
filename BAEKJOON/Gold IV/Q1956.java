import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

class Q1956 {

    static final int INF = 400 * 10_000; // |V-1| * 10,000: (정점 개수 - 1) * 최대 거리
    static int res = INF;

    static int V;
    static int E;
    static int[][] map;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        // 배열을 무한 값으로 초기화
        map = new int[V+1][V+1];
        for (int[] row : map) {
            Arrays.fill(row, INF);
        }

        for (int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            map[from][to] = dist;
        }

        findPath();
        findMin();

        System.out.println(res);
    }

    private static void findPath() {
        for (int k=1; k<=V; k++) { // 경유 노드
            for (int i=1; i<=V; i++) { // 시작 노드
                for (int j=1; j<=V; j++) { // 종료 노드
                    map[i][j] = Math.min(map[i][k] + map[k][j], map[i][j]);
                }
            }
        }
    }

    // map[i][i]로 최소값을 찾아도 되는 이유? = map[i][i]가 사이클인 이유?
    // 예를 들어, 3을 거치는 노드 중 최소를 찾는다고 가정했을 때,
    // map[2][2] = map[2][3] + map[3][2]에 사이클이 있는 경우
    // 즉 2->3 3->2 로 돌아오는 길이 둘 다 있는 경우 INF가 아닌 거리 값 정수 2개가 더해지기 때문에 최솟값이 저장된다.
    private static void findMin() {
        for (int i=1; i<=V; i++) {
            res = Math.min(map[i][i], res);
        }

        res = (res == INF) ? -1 : res;
    }
}