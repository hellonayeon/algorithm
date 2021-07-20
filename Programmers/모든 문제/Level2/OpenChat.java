import java.util.HashMap;
import java.util.ArrayList;

class OpenChat {
    public String[] solution(String[] record) {
        // [key = uid, value = nickname]
        HashMap<String, String> map = new HashMap<>();
        ArrayList<String> log = new ArrayList<>();
        
        for(int i = 0; i < record.length; i++) {
            String[] line = record[i].split(" "); 
            
            switch(line[0]) {
                case "Enter":
                    map.put(line[1], line[2]);
                    log.add(line[1] + "님이 들어왔습니다.");
                    break;
                case "Leave":
                    log.add(line[1] + "님이 나갔습니다.");
                    break;
                case "Change":
                    map.put(line[1], line[2]);
                    break;
            }
        }
        
        String[] res = new String[log.size()];
        for(int i = 0; i < log.size(); i++) {
            int idx = log.get(i).indexOf("님");
            String uid = log.get(i).substring(0, idx);
            res[i] = log.get(i).replace(uid, map.get(uid));
        }
        
        return res;
    }
}