import java.util.Arrays;
import java.util.HashSet;

class AddTwoNumbers {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        
        HashSet<Integer> set = new HashSet<>();
        
        for(int i = 0; i < numbers.length - 1; i++) {
            for(int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }

        answer = new int[set.size()];
        int idx = 0;
        for(int num : set)
            answer[idx++] = num;

        Arrays.sort(answer);
        
        return answer;
    }
}
