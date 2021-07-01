import java.util.ArrayList;
import java.util.Collections;

class TravelRoute {

    private boolean[] visit;
    private ArrayList<String> all_path = new ArrayList<>(); // 모든 가능한 경로 리스트

    public String[] solution(String[][] tickets) {
        visit = new boolean[tickets.length];

        dfs(tickets, "ICN", "ICN", 0);
        Collections.sort(all_path);

        return all_path.get(0).split(",");
    }

    public void dfs(String[][] tickets, String from, String path, int visit_cnt) {
        if(visit_cnt == tickets.length)  {
            all_path.add(path);
            return;
        }

        for(int i = 0; i < tickets.length; i++) {
            if(!visit[i] && tickets[i][0].equals(from)) {
                visit[i] = true;
                dfs(tickets, tickets[i][1], (path + "," + tickets[i][1]), visit_cnt + 1);
                visit[i] = false; // 계속해서 모든 경로를 탐색하기 위해
            }
        }
    }
}