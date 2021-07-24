class Delivery {
    public int solution(int N, int[][] road, int K) {
        Graph g = new Graph(N);
        for(int[] temp:road) {
            g.input(temp[0], temp[1], temp[2]);
        }
        return g.dijkstra(1,K);
    }
}

class Graph {
    private int n; // 노드들의 수
    private int maps[][]; // 노드들간의 가중치 저장할 변수

    public Graph(int n) {
        this.n = n;
        maps = new int[n + 1][n + 1];
    }
    public void input(int i, int j, int w) {
        if(maps[i][j] != 0 ) {
            if(maps[i][j]>w){
                maps[i][j] = w;
                maps[j][i] = w;
            }
        } else {
            maps[i][j] = w;
            maps[j][i] = w;
        }
    }

    public int dijkstra(int v, int K) {
        int answer = 0;
        int distance[] = new int[n + 1]; // 최단 거리를 저장할 변수
        boolean[] check = new boolean[n + 1]; // 해당 노드를 방문했는지 체크할 변수

        // distance값 초기화.
        for (int i = 1; i < n + 1; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        // 시작노드값 초기화.
        distance[v] = 0;
        check[v] = true;

        // "시작 노드"와 연결되어있는 노드들의 distance갱신
        for (int i = 1; i < n + 1; i++) {
            if (!check[i] && maps[v][i] != 0) {
                distance[i] = maps[v][i];
            }
        }

        for (int a = 0; a < n - 1; a++) {
            // 원래는 모든 노드가 true될때까지 인데
            // 노드가 n개 있을 때 다익스트라를 위해서 반복수는 n-1번이면 된다.
            // 원하지 않으면 각각의 노드가 모두 true인지 확인하는 식으로 구현해도 된다.
            int min = Integer.MAX_VALUE;
            int min_index = -1;

            // 최소값 찾기
            for (int i = 1; i < n + 1; i++) {
                if (!check[i] && distance[i] != Integer.MAX_VALUE) {
                    if (distance[i] < min) {
                        min = distance[i];
                        min_index = i;
                    }
                }
            }

            check[min_index] = true;
            for (int i = 1; i < n + 1; i++) {
                if (!check[i] && maps[min_index][i] != 0) {
                    if (distance[i] > distance[min_index] + maps[min_index][i]) {
                        distance[i] = distance[min_index] + maps[min_index][i];
                    }
                }
            }
        }

        // 결과값 출력
        for (int i = 1; i < n + 1; i++) {
            if(distance[i] <= K) {
                answer++;
            }
        }
        return answer;

    }
}