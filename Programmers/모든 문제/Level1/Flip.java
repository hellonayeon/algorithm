class Flip {
    public static int solution(int n) {
        int answer = 0;

        StringBuilder sb = new StringBuilder();
        while(n != 0) {
            sb.append(n%3);
            n /= 3;
        }
        sb.reverse();
        
        int mul = 1;
        for(int i = 0; i < sb.length(); i++) {
            answer += Character.getNumericValue(sb.charAt(i)) * mul;
            mul *= 3;
        }    
        
        return answer;
    }
}
