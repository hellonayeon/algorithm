import java.util.ArrayList;

class Music {
    String title; // 음악 제목
    int time; // 재생 시간
    String melodies; // 재생 시간 동안 송출된 음
    
    public Music(String[] musicinfo) {
        this.title = musicinfo[2];
        calcTime(musicinfo[0], musicinfo[1]);
        calcMelody(musicinfo[3]);
    }
    
    public Music(String m) {
        time = m.replaceAll("#","").length();
        calcMelody(m);
    }
    
    private void calcTime(String st, String et) {
        String[] t1 = st.split(":");
        String[] t2 = et.split(":");
        
        int h1 = Integer.parseInt(t1[0]);
        int h2 = Integer.parseInt(t2[0]);
        
        int m1 = Integer.parseInt(t1[1]);
        int m2 = Integer.parseInt(t2[1]);
        
        this.time = (h2 * 60 + m2) - (h1 * 60 + m1);
    }
    
    private void calcMelody(String melody) {
        int t = time;
        int next = 0;
        int len = melody.length();
        
        this.melodies = "";
        
        while(t > 0) {            
            // 한 문자 뒤에 '#'이 있을 경우 체크
            // '#'이 있는 경우 음을 소문자로 변경
            if(next < len - 1 && melody.charAt(next + 1) == '#')
                melodies += (char)(melody.charAt(next++) + 32);
            else 
                melodies += melody.charAt(next);
            
            next = (++next) % len;
            --t;
        }
        
    }
}

class ThatSong {
    public String solution(String m, String[] musicinfos) {
        ArrayList<Music> list = new ArrayList<>();
        ArrayList<Music> res = new ArrayList<>();
        
        // 네오가 기억하는 멜로디 정보를 담은 객체 생성
        Music neo = new Music(m);
        
        // 방속된 곡의 정보를 담고있는 객체 생성
        for(String music : musicinfos)
            list.add(new Music(music.split(",")));    
        
        // 네오가 들은 곡 리스트 추출
        for(Music music : list)
            if(music.melodies.contains(neo.melodies)) res.add(music); 
        
        // 조건이 일치하는 음악이 없는 경우
        if(res.size() == 0) return "(None)";
        
        Music ans = res.get(0);  
        
        if(res.size() > 1) {            
            for(int i = 1; i < res.size(); i++) {
                Music music = res.get(i);
                if(music.time > ans.time) ans = music;
            }
        }
        
        return ans.title;
    }
}