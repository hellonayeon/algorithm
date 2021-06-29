class FindPrime {
    public int solution(int n) {
        boolean[] no_primes = new boolean[n + 1];
        // 에라토네스의 채
        for(int i = 2; i <= Math.sqrt(n); i++) {
            for(int j = 2; j*i <= n; j++) {
                no_primes[j*i] = true;
            }
        }
        
        int ans = 0;
        for(int i = 2; i <= n; i++)
            if(!no_primes[i]) ans++;
        
        return ans;
    }
}
