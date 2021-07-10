import java.util.ArrayList;
import java.util.Stack;
import java.util.Collections;
import java.util.Comparator;

class TravelRoute {
    
    private boolean[] visit; // 사용한 항공권을 체크하는 변수
    private ArrayList<Stack<String>> all_path = new ArrayList<>(); // 모든 경로를 저장하는 리스트
    
    public String[] solution(String[][] tickets) {
        visit = new boolean[tickets.length];
        
        Stack<String> st = new Stack<>();
        st.push("ICN"); // 항상 "ICN" 공항에서 출발
        
        dfs(tickets, st, 0);
        
        // 가능한 경로가 여러개인 경우
        // 알파벳 순서가 앞서는 경로를 판별하기 위해 정렬
        if(all_path.size() > 1) {
            Collections.sort(all_path, new Comparator<Stack<String>>() {
                // 스택의 요소들을 꺼내어 문자열 비교
                @Override
                public int compare(Stack<String> o1, Stack<String> o2) {
                    for(int i = 0; i < o1.size(); i++) {
                        String s1 = o1.get(i);
                        String s2 = o2.get(i);

                        if(!s1.equals(s2)) return s1.compareTo(s2);
                    }
                    return 0;
                }
            });
        }
        
        // Stack -> String[]
        Stack<String> best_path = all_path.get(0);
        String[] ans = new String[best_path.size()];
        for(int i = 0; i < ans.length; i++)
            ans[i] = best_path.get(i);
        
        return ans;
    }
    
    public void dfs(String[][] tickets, Stack<String> st, int visit_cnt) {
        // 모든 항공권을 사용한 경우
        // 해당 경로를 모든 경로 리스트에 저장
        if(visit_cnt == tickets.length) {
            Stack<String> path = new Stack<>();
            
            for(String city : st)
                path.push(city);
            
            all_path.add(path);
        }
        
        String from = st.peek(); // 스택의 마지막 요소 = 출발 도시
        for(int i = 0; i < tickets.length; i++) {
            // 아직 사용 안한 항공권이고, 항공권의 출발지가 현재 출발해야하는 도시와 같을 경우
            if(!visit[i] && tickets[i][0].equals(from)) {
                visit[i] = true;
                st.push(tickets[i][1]); // 다음 경로(도착지)를 스택에 삽입
                
                dfs(tickets, st, visit_cnt+1);
                
                // 계속해서 모든 경로를 탐색하기 위한 처리
                visit[i] = false;
                st.pop();
            }
        }
        
    }
}