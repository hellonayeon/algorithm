import java.util.PriorityQueue;
import java.util.Queue;
import java.util.LinkedList;

class DiskController {
    public int solution(int[][] jobs) {
        PriorityQueue<Task> pQ = new PriorityQueue<>();
        Queue<Task> tmpQ = new LinkedList<>();
        Queue<Task> finQ = new LinkedList<>();

        for (int[] job : jobs) {
            pQ.add(new Task(job[0], job[1]));
        }

        int time = 0;
        while (!pQ.isEmpty()) {
            Task t;

            // 현재 요청 처리가 가능한 작업 선점
            if (pQ.peek().req <= time) {
                t = pQ.poll();
            }
            // 처리 가능한 작업이 없다면, 시간 흘려보내기
            else {
                time++;
                continue;
            }

            // 현재 요청 처리 가능한 작업들 중
            // 작업 소요 시간이 가장 짧은 작업 찾기
            while (!pQ.isEmpty() && pQ.peek().req <= time) {
                Task t2 = pQ.poll();
                if (t2.proc < t.proc) {
                    tmpQ.add(t);
                    t = t2;
                } else {
                    tmpQ.add(t2);
                }
            }

            // 작업 소요시간 짧은 작업 찾기 위해 빼둔 작업들 다시 pQ 넣어두기
            while (!tmpQ.isEmpty()) {
                pQ.add(tmpQ.poll());
            }

            time += t.proc;

            t.setTotal(time);
            finQ.add(t);
        }

        double answer = 0;
        for (Task t : finQ) {
            answer += t.total;
        }
        answer /= jobs.length;

        return (int) answer;
    }

    class Task implements Comparable<Task> {
        int req;
        int proc;
        int total;

        public Task(int req, int proc) {
            this.req = req;
            this.proc = proc;
        }

        public void setTotal(int time) {
            total = time - req;
        }

        @Override
        public int compareTo(Task t) {
            return this.req - t.req;
        }
    }
}
