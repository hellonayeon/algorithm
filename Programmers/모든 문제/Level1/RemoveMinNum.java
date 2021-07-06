import java.util.Arrays;

class RemoveMinNum {
    public int[] solution(int[] arr) {
        if(arr.length == 1) return new int[]{-1};
        
        int[] tmp = arr.clone(); // 배열의 내용 복사 ( '=' 은 참조 복사 )
        Arrays.sort(tmp);
        int min = tmp[0];
        
        int[] ans = new int[arr.length - 1];
        int idx = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == min) continue;
            ans[idx++] = arr[i];
        }
        
        return ans;
    }    
}
