class Harshad {
    public boolean solution(int x) {   
        int tmp = x;
        int sum = 0; // 자릿수 합
        while(tmp > 0) {
            sum += tmp % 10;
            tmp /= 10;
        }
        
        return (x % sum == 0) ? true : false;
    }    
}
