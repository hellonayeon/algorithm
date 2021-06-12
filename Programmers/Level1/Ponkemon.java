import java.util.HashSet;

public class Ponkemon {
    public int solution(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        
        for(Integer n : nums) set.add(n);
        
        return (set.size() < nums.length/2) ? set.size() : nums.length/2 ;
    }
}
