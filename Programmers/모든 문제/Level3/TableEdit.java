import java.util.List;
import java.util.ArrayList;
import java.util.Stack;


class TableEdit {
    
    List<Row> table;
    Stack<Integer> rmRow;
    int pos;
    
    class Row {
        boolean isRemoved;
        
        public Row() {
            isRemoved = false;
        }
    }
    
    
    public String solution(int n, int k, String[] cmd) {
        table = new ArrayList<>();
        rmRow = new Stack<>();
        pos = k;
        
        for (int r=0; r<n; r++) {
            table.add(new Row());
        }
        
        for (int i=0; i<cmd.length; i++) {
            execute(cmd[i]);
        }
        
        StringBuilder sb = new StringBuilder();
        for (int r=0; r<n; r++) {
            if (table.get(r).isRemoved) {
                sb.append("X");
            }
            else {
                sb.append("O");
            }
        }
        
        return sb.toString();
    }
    
    private void execute(String cmd) {
        String[] args = cmd.split(" ");
        String action = args[0];
        
        int cnt;
        switch (action) {
            case "U":
                cnt = Integer.parseInt(args[1]);
                
                while (cnt > 0) {
                    pos--;
                    
                    // 지워진 행이라면
                    // 위치를 한 칸 더 이동시키기
                    if (table.get(pos).isRemoved) {
                        continue;
                    }
                    else {
                        cnt--;
                    }
                }
                
                break;
                
            case "D":
                cnt = Integer.parseInt(args[1]);
                while (cnt > 0) {
                    pos++;
                    
                    if (table.get(pos).isRemoved) {
                        continue;
                    }
                    else {
                        cnt--;
                    }
                }
                break;
                
            case "C":
                rmRow.push(pos);
                table.get(pos).isRemoved = true;
                
                // 지운 위치가 마지막 행이라면
                // 위치를 윗 행으로 이동
                if (pos == table.size() - 1) {
                    while (table.get(pos).isRemoved) {
                        pos--;
                    }
                }
                else {
                    int tmp = pos;
                    
                    // 위치를 아래로 이동
                    while (pos < table.size() && table.get(pos).isRemoved) {
                        pos++;
                    }
                    
                    // 아래의 행들이 모두 지워진 경우, 지운 행이 마지막 행이므로
                    // 지운 위치에서 위로 이동
                    if (pos == table.size()) {
                        pos = tmp;
                        while (table.get(pos).isRemoved) {
                            pos--;
                        }
                    } 
                }
                
                break;
                
            case "Z":
                int row = rmRow.pop();
                table.get(row).isRemoved = false;
                
                break;
        }
    }
}