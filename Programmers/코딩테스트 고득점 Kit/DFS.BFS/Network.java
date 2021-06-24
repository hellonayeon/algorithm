class Network {
    public int solution(int n, int[][] computers) {
        boolean[] visit = new boolean[computers.length];
        int ans = 0;

        for(int i = 0; i < computers.length; i++)
            if(!visit[i]) ans += dfs(computers, visit, i);

        return ans;
    }

    public int dfs(int[][] computers, boolean[] visit, int i) {        
        if(visit[i]) return 0;

        visit[i] = true;
        for(int j = 0; j < computers.length; j++) {
            if(i != j && computers[i][j] == 1) dfs(computers, visit, j);
        }

        return 1;
    }
}
