import java.io.*;
import java.util.PriorityQueue;

class Q1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if(num == 0) { 
                if(queue.size() == 0) sb.append(0).append("\n");
                else sb.append(queue.poll()).append("\n");
            }
            else queue.add(num);
        }

        System.out.println(sb.toString());
    }
}