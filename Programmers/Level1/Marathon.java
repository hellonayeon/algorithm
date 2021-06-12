import java.util.HashMap;
import java.util.Map;

class Marathon {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < participant.length; i++) {
            String key = participant[i];

            if(map.containsKey(key))
                map.put(key, map.get(key) + 1);

            else
                map.put(key, 1);
        }


        for(int i = 0; i < completion.length; i++) {
            String key = completion[i];

            if(map.get(key) != 1)
                map.put(key, map.get(key) - 1);

            else
                map.remove(key);

        }

        answer = map.keySet().iterator().next();

        return answer;
    }
}