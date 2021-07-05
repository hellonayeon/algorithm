import java.util.ArrayList;

class FlipNumber {
    public int[] solution(long n) {
        ArrayList<Long> list = new ArrayList<>();
        
        while(n > 0) {
            list.add(n % 10);
            n /= 10;
        }
        
        // ArrayList -> long[]
        int[] ans = new int[list.size()];
        for(int i = 0; i < list.size(); i++)
            ans[i] = list.get(i).intValue();
        
        return ans;
    }    
}
