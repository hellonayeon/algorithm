import java.util.Stack;

class TableEdit {
    
    LinkedList table;
    Stack<Node> rmRow;
    Node cur;

    public String solution(int n, int k, String[] cmd) {
        table = new LinkedList();
        rmRow = new Stack<>();
        
        cur = table.init(n);
        while (cur.idx != k) {
            cur = cur.next;
        }
        
        for (int i=0; i<cmd.length; i++) {
            execute(cmd[i]);
        }
        
        StringBuilder answer = new StringBuilder("O".repeat(n));
        while (!rmRow.empty()) {
            answer.setCharAt(rmRow.pop().idx, 'X');
        }

        return answer.toString();
    }
    
    private void execute(String cmd) {
        String[] args = cmd.split(" ");
        String action = args[0];
        
        int cnt;
        switch (action) {
            case "U":
                cnt = Integer.parseInt(args[1]);
                while (cnt-- > 0) {
                    cur = cur.prev;
                }
                break;
                
            case "D":
                cnt = Integer.parseInt(args[1]);
                while (cnt-- > 0) {
                    cur = cur.next;
                }
                break;
                
            case "C":
                rmRow.push(cur);
                cur.remove();
                cur = cur.hasNext() ? cur.next : cur.prev;
                break;
                
            case "Z":
                rmRow.pop().restore();
                break;
        }
    }
    
    class LinkedList {
        // head 노드 반환
        public Node init(int n) {
            Node head = new Node(-1); // node.prev null pointer 예방
            Node prev = head;
            Node tail = null;

            for (int idx=0; idx<n; idx++) {
                tail = new Node(idx);
                prev.next = tail;
                tail.prev = prev;
                prev = tail;
            }
            tail.next = new Node(-1); // node.next null pointer 예방
            
            return head.next;
        }
    }
    
    class Node {
        int idx;
        Node prev;
        Node next;
        
        public Node(int idx) {
            this.idx = idx;    
        }

        public boolean hasNext() {
            return next.idx != -1;
        }

        public void remove() {
            prev.next = next;
            next.prev = prev;
        }

        public void restore() {
            prev.next = this;
            next.prev = this;
        }
    }  
}