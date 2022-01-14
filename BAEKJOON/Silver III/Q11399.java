import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Q11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<N; i++) {
            pq.add(Integer.parseInt(st.nextToken()));
        }

        int acc = 0;
        int sum = 0;
        while(!pq.isEmpty()) {
            int p = pq.poll();
            acc += p;
            sum += acc;
        }

        System.out.println(sum);
    }
}