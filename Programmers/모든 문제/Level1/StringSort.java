import java.util.Arrays;
import java.util.Comparator;

class StringSort {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                // 인덱스 n의 문자가 동일할 경우, 두 문자열에 대한 비교
                if(s1.charAt(n) == s2.charAt(n)) return s1.compareTo(s2);
                // 인덱스 n의 문자가 다를 경우, n을 기준으로 문자열 비교
                else return Character.compare(s1.charAt(n), s2.charAt(n));
            }
        });
                
        return strings;
    }
}
