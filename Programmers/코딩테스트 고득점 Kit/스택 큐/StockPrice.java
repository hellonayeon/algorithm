class StockPrice {
    class Stock {
        int price;
        int sec;
        boolean stop;
        
        public Stock(int price) {
            this.price = price;
            sec = 0;
            stop = false;
        }
        
        public void countSec(int curPrice) {
            if (!stop) {
                sec++;
            }
                
            if (price > curPrice) {
                stop = true;
            }
        }
    }
    
    
    public int[] solution(int[] prices) {
        Stock[] stocks = new Stock[prices.length];
        for (int i=0; i<prices.length; i++) {
            stocks[i] = new Stock(prices[i]);
        }
        
        for (int i=1; i<prices.length; i++) {
            int curPrice = prices[i];
            for (int j=0; j<i; j++) {
                stocks[j].countSec(curPrice);
            }
        }
        
        int[] answer = new int[stocks.length];
        for (int i=0; i<stocks.length; i++) {
            answer[i] = stocks[i].sec;
        }
        
        return answer;
    }
}