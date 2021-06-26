class SumBetweenTwoIntegers {
    public long solution(int a, int b) {
        long n1 = Math.min(a, b);
        long n2 = a + b - n1;
        // 등차수열의 합
        return (n2 - n1 + 1) * (n1 + n2) / 2;
    }
}
