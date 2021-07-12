import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

class Q11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                int n1 = Math.abs(o1);
                int n2 = Math.abs(o2);

                if(n1 == n2) return o1 > o2 ? 1 : -1;
                return n1 - n2; // compare func
            }
        });

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if(num == 0) {
                if(queue.isEmpty()) sb.append(0).append("\n");
                else sb.append(queue.poll()).append("\n"); 
            }
            else queue.add(num);
        }

        System.out.print(sb.toString());
    }
}