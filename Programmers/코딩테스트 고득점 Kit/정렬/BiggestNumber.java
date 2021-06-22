import java.util.Arrays;
import java.util.Comparator;

class BiggestNumber {

    public static void main(String[] args) {
        int[] numbers = {383, 38};
        System.out.println(solution(numbers));
    }

    public static String solution(int[] numbers) {
        // 정수를 문자열로 변겅
        String[] nums = new String[numbers.length];

        for(int i = 0; i < numbers.length; i++)
            nums[i] = String.valueOf(numbers[i]);

        // 내림차순 정렬 ((o2 + o1).compareTo(o1 + o2))
        // 오름차순 정렬 ((o1 + o2).compareTo(o1 + o2))
        Arrays.sort(nums, new Comparator<String>(){
            @Override
            // 정렬 기준 명시
            // 두 문자열의 위치를 뒤바꿔 비교한 값 중, 더 큰 값을 리턴
            public int compare(String o1, String o2) {
                return ((o2 + o1).compareTo(o1 + o2));
            }
        });

        // [0, 0, 0, 0 .. ] 입력이 주어졌을 때, 예외처리 "0000" -> "0"
        if(nums[0].equals("0"))
            return "0";

        String ans = "";
        for(String n : nums)   
            ans += n;

        return ans;
    }
}