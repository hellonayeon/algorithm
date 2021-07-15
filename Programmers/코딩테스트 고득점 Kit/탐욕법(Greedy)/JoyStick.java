class JoyStick {
    public int solution(String name) {
        int cnt = 0;
        int len = name.length();
        int min = len - 1;
        
        for(int idx = 0; idx < name.length(); idx++) {
            if(name.charAt(idx) != 'A') {
                int up = name.charAt(idx) - 'A';
                int down = 'Z' - name.charAt(idx) + 1;
                
                cnt += (up < down) ? up : down;
                
                // 좌우 이동
                int next = idx + 1;
                while (next < len && name.charAt(next) == 'A')
                    next++;

                min = Math.min(min, (idx + idx) + len - next);
            }  
        }
        return cnt + min;
    }
}