import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

class Q11279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i ++) {
            int num = Integer.parseInt(br.readLine());

            if (num == 0) {
                if(queue.size() == 0) sb.append(0).append("\n");
                else sb.append(queue.poll()).append("\n");
            }
            else queue.add(num);
        }

        System.out.print(sb.toString());
    }
}