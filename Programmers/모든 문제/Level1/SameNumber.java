import java.util.ArrayList;

class SameNunber {
    public int[] solution(int []arr) {

        ArrayList<Integer> list = new ArrayList<>();
        list.add(arr[0]);
        for(int i = 0; i < arr.length - 1; i++) {
            if(arr[i] == arr[i+1]) continue;
            else list.add(arr[i+1]);
        }

        int[] ans = new int[list.size()];
        for(int i = 0; i < list.size(); i++)
            ans[i] = list.get(i);

        return ans;
    }
}