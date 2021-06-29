class StringPlacement {
    public String solution(String s) {
        char[] chs = s.toCharArray();

        for(int i = 1; i < s.length(); i++) {
            char ch = chs[i];

            int j = i - 1;
            while(j >= 0 && ch > chs[j]) {
                chs[j + 1] = chs[j];
                j--;
            }

            chs[j + 1] = ch;
        }

        return String.valueOf(chs);
    }
}