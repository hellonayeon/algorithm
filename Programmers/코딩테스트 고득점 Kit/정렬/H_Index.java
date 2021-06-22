import java.util.Arrays;

class H_Index {
    public int solution(int[] citations) {
        int ans = 0;
        Arrays.sort(citations);
 
        for (int i = 0; i < citations.length; i++) {
            int h = citations.length - i;
 
            if (citations[i] >= h) {
                ans = h;
                break;
            }
        }
 
        return ans;
    }
}
