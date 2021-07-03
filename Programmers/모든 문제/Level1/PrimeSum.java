class PrimeSum {
    public int solution(int n) {
        int ans = 0;
        for(int div = 1; div <= n / 2; div++) {
            if(n % div == 0) ans += div;
        }
        return ans + n;
    }    
}
