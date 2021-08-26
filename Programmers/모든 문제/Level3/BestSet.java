// 짝지은 집합이 가장 큰 수들로 구성
class BestSet {
    public int[] solution(int n, int s) {
        if(n > s) return new int[]{-1};
        
        int[] ans = new int[n];
        int val = s/n;
        int rem = s%n;
        
        for(int i = 0; i < n; i++)
            ans[i] = val;
        
        int idx = n-1;
        while(rem-- > 0) {
            ans[idx--]++;
            if(idx == 0) idx = n-1;
        }
        
        return ans;
    }
}