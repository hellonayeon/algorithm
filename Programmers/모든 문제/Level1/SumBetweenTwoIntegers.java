class SumBetweenTwoIntegers {
    public long solution(int a, int b) {
        long ans = 0;

        int n = Math.min(a, b);
        int range = Math.abs(a-b);
        for(int i = 0; i <= range; i++)
            ans += n++;   

        return ans;
    }
}
