class IDRecommendation {

    public static void main(String[] args) {
        solution(".....................BaT#*..y.abcdefghijklm");
    }

    public static String solution(String new_id) {
        String answer = "";

        StringBuilder sb = new StringBuilder(new_id.toLowerCase());
        System.out.println("1단계" + sb.toString());

        
        for(int i=0; i<sb.length(); i++) {
            char c = sb.charAt(i);

            if(!((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') 
                || c == '-' || c == '_' || c == '.' )) 
                sb.deleteCharAt(i--);
        }
        System.out.println("2단계" + sb.toString());

        int periodCount = 0;
        for(int i=0; i<sb.length(); i++) {
            char c = sb.charAt(i);

            if(c == '.') {
                periodCount++;
            }
            
            if (c != '.' || i == sb.length()-1) {
                if(periodCount > 1) {
                    sb.delete(i - periodCount + 1, i);
                    i -= periodCount - 1;
                }
                periodCount = 0;
            } 
        }
        System.out.println("3단계" + sb.toString());

        if(sb.charAt(0) == '.') sb.deleteCharAt(0);
        if(sb.length() != 0 && sb.charAt(sb.length()-1) == '.') sb.deleteCharAt(sb.length() - 1);
        System.out.println("4단계" + sb.toString());
        
        if(sb.length() == 0) sb.append("a");
        System.out.println("5단계" + sb.toString());

        if(sb.length() > 15) {
            sb = sb.delete(15, sb.length());

            if((int)sb.charAt(14) == '.')
                sb.deleteCharAt(14);
        }
        System.out.println("6단계" + sb.toString());

        if(sb.length() <= 2) {
            char c = sb.charAt(sb.length()-1);

            while(sb.length() != 3) {
                sb.append(c);
            }
        }

        System.out.println("7단계" + sb.toString());

        answer = sb.toString();

        return answer;
    }
}