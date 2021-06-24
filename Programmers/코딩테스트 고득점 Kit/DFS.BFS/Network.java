class Network {
    public int solution(int n, int[][] computers) {
        boolean[] visit = new boolean[n];
        int ans = 0;

        // 모든 컴퓨터들을 검사
        for(int i = 0; i < n; i++) {
            if(!visit[i]) {
                dfs(computers, visit, i);
                ans++;
            }
        }   

        return ans;
    }
    
    // 하나의 컴퓨터에 연결된 다른 모든 컴퓨터들 검사
    public void dfs(int[][] computers, boolean[] visit, int i) {        
        visit[i] = true;
        
        for(int j = 0; j < computers.length; j++)
            if(!visit[j] && i != j && computers[i][j] == 1) dfs(computers, visit, j);
    }
}
