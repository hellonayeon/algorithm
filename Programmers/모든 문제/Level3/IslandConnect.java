import java.util.Arrays;

class IslandConnect {
    
    int[] parent;
    
    public int solution(int n, int[][] costs) {
        // 비용이 작은 것 부터 먼저 연결하기 위해 정렬
        // 최소 신장 트리를 만들기 위한 준비
        Arrays.sort(costs, (c1, c2) -> c1[2] - c2[2]); 
        
        parent = new int[n];
        for (int i=0; i<n; i++) {
            parent[i] = i;
        }
        
        int answer = 0;
        for (int[] node : costs) {
            int from = node[0];
            int to = node[1];
            int cost = node[2];
            
            // 트리에서 두 노드가 부모가 같은 경우
            // 두 노드가 연결되면 사이클 발생
            int a = find(from);
            int b = find(to);
            
            if (a != b) {
                answer += cost;
                parent[a] = b;
            } 
        }
        return answer;
    }
    
    private int find(int node) {
        if (parent[node] == node) return node;
        return parent[node] = find(parent[node]);
    }
}