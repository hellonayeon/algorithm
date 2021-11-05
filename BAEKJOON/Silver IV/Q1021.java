import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Q1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] rm = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            rm[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(rotate(rm, N));
    }

    public static int rotate(int[] rm, int N) {
        int cnt = 0;
        LinkedList<Integer> deque = new LinkedList<>();

        for(int i = 1; i <= N; i++) {
            deque.add(i);
        }

        for(int i = 0; i < rm.length; i++) {
            int pos = deque.indexOf(rm[i]);
            int size = deque.size();
            int half = (deque.size() % 2 == 0) ? size / 2 - 1 : size / 2;

            if(pos <= half) {
                for(int j = 0; j < pos; j++) {
                    deque.offerLast(deque.pollFirst());
                    cnt++;
                }
            }
            else {
                for(int j = 0; j < size - pos; j++) {
                    deque.offerFirst(deque.pollLast());
                    cnt++;
                }
            }
            deque.pollFirst();
        }

        return cnt;
    }
}