class PrimeCount {
    public int solution(int left, int right) {
        int answer = 0;
        
        for(int n = left; n <= right; n++) {
            if(countPrime(n) % 2 == 0) answer += n;
            else answer -= n;
        }
        
        return answer;
    }
    
    public int countPrime(int num) {
        int count = 0;
        for(int i = 1; i <= num; i++)
            if(num % i == 0) count++;
        
        return count;
    }
}
