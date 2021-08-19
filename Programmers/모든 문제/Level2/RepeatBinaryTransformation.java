class RepeatBinaryTransformation {
    public int[] solution(String s) {
        int[] ans = new int[2]; // 이진 변환 횟수, 제거된 0의 개수
        
        while(!s.equals("1")) {
            ans[1] += s.length();
            
            s = s.replace("0", "");
            int len = s.length();
            s = Integer.toBinaryString(len);
            
            ans[0]++;
            ans[1] -= len;
        }
        
        return ans;
    }
}