public class GCDLCM {
    public int[] solution(int n, int m) {
        int[] ans = new int[2]; // 0. 최대공약수 1. 최소공배수
        
        for(int x = 1; x <= Math.min(n, m); x++)
            if(n % x == 0 && m % x == 0) ans[0] = x;
        
        ans[1] = n * m / ans[0];
        
        return ans;
    }
}
