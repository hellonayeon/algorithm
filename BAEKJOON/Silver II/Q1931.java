/* 활동 선택 문제 */
/* 문제에서 주어진 '특이한 조건'을 포함하는 입력 케이스를 생각해보자 */
/* 시작과 동시에 종료되는 회의(시작시간 == 종료시간)와 일반적인 회의(시작시간 != 종료시간)가 같이 있는 경우에 원하는 출력 값이 나오는지 확인해보기 */ // line 25 주석 참고

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Q1931 {

    static class Meeting implements Comparable<Meeting> {
        int start; // 회의 시작 시간
        int end; // 회의 종료 시간

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting o) {
            // 종료 시간 같을 경우, '시작 시간' 기준으로 오름차순 정렬
            // 이전 방식에서는 '회의 시간' 오름차순 정렬
            // 예외) (8, 8) (4, 8) 이 입력됐을 때, (8, 8)이 (4, 8) 보다 우선순위가 높다. (회의 진행시간이 더 짧기 때문에)
            //      그래서 (4, 8)이 선택되지 않아 원하는 값이 안나온다.
            if(this.end == o.end) {
                return this.start - o.start;
            }
            
            return this.end - o.end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Meeting> pq = new PriorityQueue<>();

        StringTokenizer st = null;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            pq.add(new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        int cnt = 1;
        Meeting cur = pq.poll();
        while(!pq.isEmpty()) {
            Meeting nxt = pq.poll();
            if(nxt.start < cur.end) continue;

            cur = nxt;
            cnt++;
        }

        System.out.println(cnt);
    }
}