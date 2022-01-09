import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import java.util.PriorityQueue;
import java.util.ArrayList;

class Dijkstra {

    static int v;
    static int e;
    static ArrayList<ArrayList<Edge>> graph;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        
        graph = new ArrayList<ArrayList<Edge>>();
        dist = new int[v+1];

        for(int i=0; i<=v; i++) {
            graph.add(new ArrayList<Edge>());
            dist[i] = Integer.MAX_VALUE;
        }

        // 시작 정점
        int start = Integer.parseInt(br.readLine());

        // 간선 정보 저장
        for(int i=0; i<e; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(from).add(new Edge(to, weight));
        }

        dijkstra(start);

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=v; i++) {
            sb.append(dist[i]).append("\n");
        }

        System.out.println(sb);
    }

    public static void dijkstra(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()) {
            Edge cur = pq.poll();
            
            // 방문하고자 하는 정점까지의 간선의 가중치가
            // 현재 최단거리 리스트에 저장되있는 가중치보다 크다면 방문X
            // why? 이미 최단거리로 방문해서, 최단거리 리스트에 최솟값이 들어가 있기 때문
            if(dist[cur.to] < cur.weight) continue;

            for(int i=0; i<graph.get(cur.to).size(); i++) {
                Edge nxt = graph.get(cur.to).get(i);
                int to = nxt.to;
                int weight = nxt.weight + cur.weight;

                if(weight < dist[to]) {
                    dist[to] = weight;
                    pq.add(new Edge(to, weight));
                }
            }
        }
    }

    static class Edge implements Comparable<Edge> {
        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }
}