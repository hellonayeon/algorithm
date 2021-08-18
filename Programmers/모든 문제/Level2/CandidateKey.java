import java.util.ArrayList;
import java.util.HashSet;

class CandidateKey {
        
    ArrayList<String> combList = new ArrayList<>(); // 가능한 후보키 조합의 열 번호 리스트
    ArrayList<String> candidateKey = new ArrayList<>();
    int keyCnt = 0;
    
    int row;
    int col;
    
    public int solution(String[][] relation) {
        row = relation.length;
        col = relation[0].length;
        
        // 가능한 후보키 조합 구하기
        // 최소 1개 ~ 최대 col개
        for(int cnt = 1; cnt <= col; cnt++)
            comb(cnt, 0, 0, "", new boolean[col]);

        for(int k = 0; k < combList.size(); k++) {
            String cols = combList.get(k);
            if(!isUnique(cols)) continue;
            
            char[] indices = cols.toCharArray();
            
            HashSet<String> set = new HashSet<>();
            
            for(int r = 0; r < row; r++) {
                String str = "";
                for(int i = 0; i < indices.length; i++) {
                    int c = indices[i] - '0';
                    str += relation[r][c];
                }
                set.add(str);
            }

            if(set.size() == row) candidateKey.add(cols);
        }
        
        return candidateKey.size(); 
    }
    
    public void comb(int combCnt, int cnt, int start, String keyComb, boolean[] chk) {
        if(cnt == combCnt) {
            combList.add(keyComb);
            return;
        }
        
        for(int c = start; c < col; c++) {
            if(!chk[c]) {
                chk[c] = true;
                comb(combCnt, cnt+1, c+1, keyComb + c, chk);
                chk[c] = false;
            }
        } 
    }
    
    // 최소성을 만족하는지 검사
    // 만약, (1, 3) 컬럼이 후보키라면 (1, 2, 3) 컬럼은 최소성을 만족 못 하므로 후보키 불가
    // "123".contains("13") 일 경우 제대로 체크 불가능
    public boolean isUnique(String cols) {
        HashSet<Integer> colSet = new HashSet<>();
        for(char c : cols.toCharArray()) 
            colSet.add(c - '0');
        
        for(String key : candidateKey) {
            HashSet<Integer> keySet = new HashSet<>();
            for(char c : key.toCharArray())
                keySet.add(c - '0');
            
            if(colSet.containsAll(keySet)) return false;
        }
        
        return true;
    }
}