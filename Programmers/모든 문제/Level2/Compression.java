import java.util.HashMap;
import java.util.ArrayList;

class Compression {
    public int[] solution(String msg) {
        ArrayList<Integer> indices = new ArrayList<>();
        HashMap<String, Integer> dic = new HashMap<>();
        
        int idx = 0;
        boolean isEnd = false;
        
        // 사전 초기화
        for(int alphabet = 'A'; alphabet <= 'Z'; alphabet++)
            dic.put(String.valueOf((char)alphabet), ++idx);
        
        for(int i = 0; i < msg.length(); i++) {
            
            String w = "" + msg.charAt(i);
        
            // while 구문 사용
            // 사전에 포함되는 단어 + 1문자까지 루프
            // * 문제 풀 떄 for 문 안에 while 문 사용 방법도 생각하기 *
            while(dic.containsKey(w)){
                i++;
                if(i == msg.length()) {
                	isEnd = true;
                	break;
                }
                w += msg.charAt(i);
            }
            
            // 마지막 문자에 대해서 따로 처리
            if(isEnd) {
            	indices.add(dic.get(w));
            	break;
            }
            
            // 사전에 포함된 단어에 대한 색인 저장
            indices.add(dic.get(w.substring(0, w.length() - 1)));
            // 사전에 포함된 단어 + 1문자는 새로운 단어로 사전에 저장
            dic.put(w, ++idx);
            
            i--; // 색인에 포함되지 않았던 마지막 한 문자부터 탐색 시작
        }
                
        int[] ans = new int[indices.size()];
        for(int i = 0; i < indices.size(); i++)
            ans[i] = indices.get(i);
        
        return ans;
    }
}