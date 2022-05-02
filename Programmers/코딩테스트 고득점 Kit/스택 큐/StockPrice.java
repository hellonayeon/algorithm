class StockPrice {
    public int[] solution(int[] prices) {
        int len = prices.length;
        int[] answer = new int[len];
        
        for (int i=0; i<len; i++) {
            for (int j=i+1; j<len; j++) {
                answer[i]++;
                if (prices[j] < prices[i]) {
                    break;
                }
            }
        }
        
        return answer;
    }
}