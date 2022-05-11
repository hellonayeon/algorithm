import java.util.Stack;

class TableEdit {
    
    LinkedList table;
    Stack<Node> rmRow;

    public String solution(int n, int k, String[] cmd) {
        table = new LinkedList();
        rmRow = new Stack<>();
        
        Node prev = null;
        for (int r=0; r<n; r++) {
            Node node = new Node(r);
            table.insert(prev, node);
            prev = node;
        }
        table.select(k);
        
        for (int i=0; i<cmd.length; i++) {
            execute(cmd[i]);
        }
        
        return table.search(n);
    }
    
    private void execute(String cmd) {
        String[] args = cmd.split(" ");
        String action = args[0];
        
        int cnt;
        Node node;
        switch (action) {
            case "U":
                cnt = Integer.parseInt(args[1]);
                table.up(cnt);
                break;
                
            case "D":
                cnt = Integer.parseInt(args[1]);
                table.down(cnt);
                break;
                
            case "C":
                node = table.getCur();
                rmRow.push(node);
                table.delete(node);
                break;
                
            case "Z":
                node = rmRow.pop();
                table.restore(node);
                break;
        }
    }
    
    class LinkedList {
        Node head, tail, cur;
        
        public LinkedList() {
            head = tail = cur = null;
        }
        
        public void insert(Node prev, Node nnode) {
            if (head == null) {
                head = tail = nnode;
            }
            else {
                tail.next = nnode;
                tail = nnode;
                nnode.prev = prev;
            }
        }
        
        public void select(int k) {
            cur = head;
            while (cur.val != k) {
                cur = cur.next;
            }
        }
        
        public void delete(Node dnode) {
            // 처음 노드를 삭제하는 경우
            if (head.val == dnode.val) {
                head.next.prev = null;
                head = cur = head.next;
            }
            // 마지막 노드를 삭제하는 경우
            else if (tail.val == dnode.val) {
                tail.prev.next = null;
                tail = cur = tail.prev;
            }
            // 중간 노드를 삭제하는 경우
            else {
                dnode.prev.next = dnode.next;
                dnode.next.prev = dnode.prev;
                cur = dnode.next;
            }
        }
        
        // 노드 복구 ('Z' 수행)
        public void restore(Node rnode) {
            // 처음 노드 복구
            if (rnode.prev == null) {
                head.prev = rnode;
                rnode.next = head;
                head = rnode;
            }
            // 마지막 노드 복구
            else if (rnode.next == null) {
                rnode.prev = tail;
                tail.next = rnode;
                tail = rnode;
            }
            // 중간 노드 복구
            else {
                rnode.prev.next = rnode;
                rnode.next.prev = rnode;
            }
        }
        
        public void up(int cnt) {
            while (cnt-- > 0) {
                cur = cur.prev;
            }
        }
        
        public void down(int cnt) {
            while (cnt-- > 0) {
                cur = cur.next;
            }
        }
        
        public Node getCur() {
            return cur;
        }
        
        public String search(int n) {
            StringBuilder sb = new StringBuilder();
            Node tmp = head;
            for (int r=0; r<n; r++) {
                if (tmp == null) {
                    // 마지막 노드가 삭제되어 없는 경우 (tmp.next = null)
                    sb.append("X");
                }
                else if (tmp.val == r) {
                    sb.append("O");
                    tmp = tmp.next;
                }
                else {
                    sb.append("X");
                }
            }
            return sb.toString();
        }
    }
    
    class Node {
        int val;
        Node prev;
        Node next;
        
        public Node(int val) {
            this.val = val;    
        }
    }  
}