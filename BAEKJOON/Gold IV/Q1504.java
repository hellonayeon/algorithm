import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.PriorityQueue;


class Edge implements Comparable<Edge>{
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

class Q1504 {
    
    static ArrayList<ArrayList<Edge>> adj;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        dist = new int[N+1];
        adj = new ArrayList<>(N+1);
        for(int i = 0; i <= N; i++) adj.add(new ArrayList<>());

        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            // 무방향 그래프
            adj.get(a).add(new Edge(b, c));
            adj.get(b).add(new Edge(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int[] res = new int[5];
        res[0] = dijkstra(1, v1);
        res[1] = dijkstra(1, v2);
        res[2] = dijkstra(v1, v2); // v1 -> v2 == v2 -> v1
        res[3] += dijkstra(v2, N);
        res[4] += dijkstra(v1, N);

        int ans;
        if(res[0] == -1 || res[1] == -1 || res[2] == -1 || res[3] == -1 || res[4] == -1)
            ans = -1;
        else
            ans = Math.min(res[0] + res[2] + res[3], res[1] + res[2] + res[4]);
        
        System.out.println(ans);
    }

    public static int dijkstra(int start, int end) {
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));

        dist[start] = 0;

        while(!pq.isEmpty()) {
            Edge cur = pq.poll();
            int cv = cur.v;

            if(cv == end) return cur.w;
            
            // 인접한 노드들의 거리 체크
            // 무방향 그래프이지만 방문여부를 체크 안해도 되는 이유 :
            // 정점A -> 정점B 에서 정점B -> 정점A 로 되돌아간다면,
            // 거리가 길어져서 큐에 집어 넣는 작업 수행 안 하기 때문
            for(Edge next : adj.get(cv)) {
                int nv = next.v;
                int nw = next.w;
                if(dist[nv] > dist[cv] + nw) {
                    dist[nv] = dist[cv] + nw;
                    pq.offer(new Edge(nv, dist[nv]));
                }
            }
        }

        return -1;
    }
}