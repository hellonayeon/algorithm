import java.util.Queue;
import java.util.LinkedList;
import java.util.Iterator;

class Solution {
    
    class Document {
        int priority;
        int location;
        
        public Document(int priority, int location) {
            this.priority = priority;
            this.location = location;
        }
    }
    
    public int solution(int[] priorities, int location) {
        Queue<Document> queue = new LinkedList<>();
        
        for (int i=0; i<priorities.length; i++) {
            queue.add(new Document(priorities[i], i));
        }
        
        int order = 0;
        while (!queue.isEmpty()) {
            int locDiff = findHighestPriorityLocation(queue);
            System.out.println(locDiff);
            while (locDiff-- > 0) {
                Document doc = queue.poll();
                queue.add(doc);
            }
            
            Document doc = queue.poll();
            order++;
            
            if (doc.location == location) {
                return order;
            }
        }
        
        return order;
    }
    
    private int findHighestPriorityLocation(Queue<Document> queue) {
        Iterator<Document> it = queue.iterator();
        
        Document firstDoc = it.next();
        int highestPriority = firstDoc.priority;
        int loc = 1, locDiff = 0;
        while (it.hasNext()) {
            Document doc = it.next();
            if (doc.priority > highestPriority) {
                highestPriority = doc.priority;
                locDiff = loc;
            }
            loc++;
        }
        return locDiff;
    }
}