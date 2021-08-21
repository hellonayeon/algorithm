import java.util.HashSet;

class RankSearch {
    public int[] solution(String[] info, String[] query) {
        int[] ans = new int[query.length];

        HashSet<Integer> nonConditions = new HashSet<>(); // 조건에 해당하지 않는 지원자
                
        String[][] infos = new String[info.length][5];
        for(int i = 0; i < info.length; i++)
            infos[i] = info[i].split(" ");    
        
        for(int i = 0; i < query.length; i++) {
            String[] con = query[i].replaceAll(" and", "").split(" "); // 각 쿼리의 조건
            
            for(int j = 0; j < con.length; j++) {
                if(con[j].equals("-")) continue;
                
                for(int k = 0; k < infos.length; k++) {
                    if(nonConditions.contains(k)) continue;
                    if(j == con.length - 1) {
                        int qs = Integer.parseInt(con[j]);
                        int s = Integer.parseInt(infos[k][j]);
                        
                        if(s < qs) nonConditions.add(k);
                        
                        continue;
                    } 
                    if(!infos[k][j].equals(con[j])) nonConditions.add(k);
                }
            }
            ans[i] = infos.length - nonConditions.size();
            nonConditions.clear();
        }
        
        return ans;
    }
}