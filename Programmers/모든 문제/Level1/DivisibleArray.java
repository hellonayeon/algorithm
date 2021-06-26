import java.util.ArrayList;
import java.util.Arrays;

class DivisibleArray {
    public int[] solution(int[] arr, int divisor) {
        
        // 나누어 떨어지는 값을 저장할 리스트
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] % divisor == 0) {
                list.add(arr[i]);
            }
        }
        
        // 나누어 떨어지는 값이 하나도 없다면
        if(list.size() == 0) { 
            int[] ans = {-1};
            return ans; 
        }
        
        // ArrayList to int[]
        int[] ans = new int[list.size()];
        
        for(int i = 0; i < list.size(); i++)
            ans[i] = list.get(i);
        
        Arrays.sort(ans);
        
        return ans;
    }
}
