import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
    int v;
    int w;

    public Edge(int v, int w) {
        this.v = v;
        this.w = w;
    }

    @Override
    public int compareTo(Edge o) {
        return this.w - o.w;
    }
}

class Q1753 {
    static ArrayList<ArrayList<Edge>> adj;
    static boolean[] visit;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        
        int start = Integer.parseInt(br.readLine()) - 1;

        visit = new boolean[V];
        dist = new int[V];
        
        adj = new ArrayList<>(V);
        for(int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            int w = Integer.parseInt(st.nextToken());

            adj.get(u).add(new Edge(v, w));
        }

        dijkstra(start);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < V; i++) {
            if(dist[i] == Integer.MAX_VALUE) sb.append("INF").append("\n");
            else sb.append(dist[i]).append("\n");
        }

        System.out.print(sb);
    }

    public static void dijkstra(int start){
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Edge(start, 0));
        
        dist[start] = 0;

        while (!priorityQueue.isEmpty()) {
            Edge edge = priorityQueue.poll();
            int cv = edge.v;

            if(visit[cv]) continue;

            visit[cv] = true;

            // 기준 노드[dst]와 연결된 노드들 중
            // 거리가 가장 짧은(우선순위가 높은) 노드부터 탐색
            for (Edge next : adj.get(cv)) {
                int nv = next.v;
                int nw = next.w;

                if (dist[nv] >= dist[cv] + nw) {
                    dist[nv] = dist[cv] + nw;
                    priorityQueue.add(new Edge(nv, dist[nv]));
                }
            }
        }
    }
}