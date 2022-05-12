import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.HashSet;

import java.io.FileInputStream;

class Q2383 {

    static List<Person> people;
    static Stair[] stairs;
    static PriorityQueue<Person>[] pqs;
    static int N;
    static int res;


    public static void main(String args[]) throws IOException {
        System.setIn(new FileInputStream("res/Q2383_input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            people = new ArrayList<>();
            stairs = new Stair[2];
            pqs = new PriorityQueue[2];
            pqs[0] = new PriorityQueue<>();
            pqs[1] = new PriorityQueue<>();

            N = Integer.parseInt(br.readLine());
            
            int sidx = 0;
            for (int x=0; x<N; x++) {
                st = new StringTokenizer(br.readLine());

                for (int y=0; y<N; y++) {
                    int val = Integer.parseInt(st.nextToken());
                
                    if (val == 1) {
                        people.add(new Person(x, y));
                    }
                    else if (val > 1) {
                        stairs[sidx++] = new Stair(x, y, val);
                    }
                }
            }
            
            res = Integer.MAX_VALUE;
            for (int r=0; r<people.size(); r++) {
                distribute(new HashSet<>(), new boolean[people.size()], 0, r);
            }
            
            
            sb.append("#").append(tc).append(" ").append(res).append("\n");
        }
        System.out.print(sb);
    }

    // 사람은 1번 계단 또는 2번 계단 이용 가능
    // 각 계단을 내려갈 사람들 구하기
    private static void distribute(HashSet<Integer> idxs, boolean[] distributed, int idx, int r) {
        if (r == 0) {
            getAtime(idxs);
            down();
            System.out.println("hell");
            return;
        }

        for (int i=0; i<people.size(); i++) {
            if (!distributed[i]) {
                distributed[i] = true;
                idxs.add(i);
                distribute(idxs, distributed, i, r-1);
                idxs.remove(i);
                distributed[i] = false;
            }
        }
    }

    private static void getAtime(HashSet<Integer> idxs) {
        for (int idx=0; idx<people.size(); idx++) {
            int sidx = (idxs.contains(idx)) ? 0 : 1;
            
            Person p = people.get(idx);
            p.setAtime(stairs[sidx].x, stairs[sidx].y); 
            pqs[sidx].add(p);
        }
    }

    private static void down() {
        int totalTime = Integer.MAX_VALUE;

        for (int sidx=0; sidx<2; sidx++) {
            
            // 한 쪽 계단에 사람이 몰린 경우
            if (pqs[sidx].peek() == null) {
                continue;
            }

            int time = pqs[sidx].peek().atime;
            Queue<Person> peopleOnStair = new LinkedList<>();
            Person person = pqs[sidx].poll();
            person.setDtime(time + 1); // 도착 후 1초 뒤 계단 내려가기 시작
            peopleOnStair.add(person);

            while (true) {
                if (pqs[sidx].peek() == null) {
                    break;
                }

                if (pqs[sidx].peek().atime == time) {
                    peopleOnStair.add(pqs[sidx].poll());
                }
                else {
                    break;
                }
            }
            
            while (true) {
                time++;

                // 계단 내려가기 완료 처리
                while (!peopleOnStair.isEmpty() && time - peopleOnStair.peek().dtime == stairs[sidx].len) {
                    peopleOnStair.poll();
                }

                // 모든 사람이 계단을 내려간 경우
                if (pqs[sidx].isEmpty() && peopleOnStair.isEmpty()) {
                    totalTime = Math.min(time, totalTime);
                    break;
                }

                // 계단에 사람이 들어올 수 있는지 검사
                while (!pqs[sidx].isEmpty() && peopleOnStair.size() < 3) {
                    // 1분 이상 기다린 상태라면 계단 내려가기
                    if (time - pqs[sidx].peek().atime >= 1) {
                        Person nextPerson = pqs[sidx].poll();
                        nextPerson.setDtime(time); // 계단 내려가기 시작한 시간 기록
                        peopleOnStair.add(nextPerson);
                    }
                    else {
                        break;
                    }
                }
                
            }

            res = Math.min(totalTime, res);
        }

    }


    static class Stair {
        int x;
        int y;
        int len;

        public Stair(int x, int y, int len) {
            this.x = x;
            this.y = y;
            this.len = len;
        }
    }

    static class Person implements Comparable<Person> {
        int x;
        int y;
        int atime; // 계단 앞 도착 시간
        int dtime; // 내려가기 시작한 시간

        public Person(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void setAtime(int sx, int sy) {
            atime = Math.abs(sx - x) + Math.abs(sy - y);
        }

        public void setDtime(int time) {
            dtime = time;
        }

        @Override
        public int compareTo(Person p) {
            return atime - p.atime;
        }
    }
}