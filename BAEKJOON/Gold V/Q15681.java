// [출처] [백준] 15681번 - "트리와 쿼리" (Java), https://bbangson.tistory.com/54

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import java.util.ArrayList;

class Q15681 {

    static ArrayList<Integer>[] list;
    static boolean[] visit;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];
        visit = new boolean[N+1];
        dp = new int[N+1];

        for (int i=0; i<list.length; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i=1; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int U = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            list[U].add(V);
            list[V].add(U);
        }

       dfs(R);

        StringBuilder sb = new StringBuilder();
        while (Q-- > 0) {
            int query = Integer.parseInt(br.readLine());
            sb.append(dp[query]).append("\n");
        }
        System.out.println(sb);
    }

    public static int dfs(int now) {

        if (dp[now] != 0) return dp[now];
        visit[now] = true;
        int count = 1;

        for (int node : list[now]) {
            if (visit[node]) continue;
            count += dfs(node);
        }
        dp[now] = count;

        return dp[now];
    }
}
