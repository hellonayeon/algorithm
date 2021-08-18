class ThatSong {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int time = 0;

        m = edit(m);

        for (int inx = 0; inx < musicinfos.length; inx++) {

            String[] info = musicinfos[inx].split(",");

            int start = (60 * Integer.parseInt(info[0].substring(0, 2)) + Integer.parseInt(info[0].substring(3)));
            int end = (60 * Integer.parseInt(info[1].substring(0, 2)) + Integer.parseInt(info[1].substring(3)));
            int t = end - start;

            // 재생 시간이 이전 곡의 재생 시간보다 짧을 경우
            // 네오가 들은 멜로디가 포함되어 있다 해도 답이 될 수 없다.
            
            // [문제 조건] 
            // 조건이 일치하는 음악이 여러 개일 때에는 라디오에서 재생된 시간이 제일 긴 음악 제목을 반환한다. 
            // 재생된 시간도 같을 경우 먼저 입력된 음악 제목을 반환한다.

            // 따라서 이전에 검사한 정답 후보들 보다
            // 재생 시간이 짧은 경우에는 굳이 검사할 필요 없다. (t > time)
            if (t > time) {
                info[3] = edit(info[3]);
                StringBuffer sb = new StringBuffer();
                for (int jnx = 0; jnx < t; jnx++) {
                    sb.append(info[3].charAt(jnx % (info[3].length())));
                }
                if (sb.toString().indexOf(m) >= 0) {
                    answer = info[2];
                    time = t;
                }
            }
        }

        return answer;
    }

    // 치환해야하는 문자열이 많은 것이 아니니까 이 방법도 좋은 해결책
    public String edit(String m) {

        m = m.replaceAll("C#", "V");
        m = m.replaceAll("D#", "W");
        m = m.replaceAll("F#", "X");
        m = m.replaceAll("G#", "Y");
        m = m.replaceAll("A#", "Z");

        return m;
    }
}