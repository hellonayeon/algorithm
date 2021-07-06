class Collatz {
    public int solution(int num) {
        return collatz((long) num, 0);
    }
    
    public int collatz(long num, int cnt) {
        if(num == 1) return cnt;
        if(cnt == 500) return -1;
        
        return (num % 2 == 0) ? collatz(num/2, cnt+1) : collatz((num * 3 + 1), cnt+1);
    }    
}
