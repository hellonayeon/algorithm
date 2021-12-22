import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import java.util.PriorityQueue;


class Q10825 {

    static class Student implements Comparable<Student> {
        String name;
        int kor;
        int en;
        int math;

        public Student(String name, int kor, int en, int math) {
            this.name = name;
            this.kor = kor;
            this.en = en;
            this.math = math;
        }

        @Override
        public int compareTo(Student o) {
            if(this.kor == o.kor) {
                if(this.en == o.en) {
                    if(this.math == o.math) {
                        return this.name.compareTo(o.name);
                    }
                    return o.math - this.math;
                }

                return this.en - o.en;
            }

            return o.kor - this.kor;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Student> pq = new PriorityQueue<>();
        while(N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            pq.offer(new Student(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        
        StringBuilder builder = new StringBuilder();
        while(!pq.isEmpty()) {
            Student student = pq.poll();
            builder.append(student.name).append("\n");
        }

        System.out.println(builder);
    }
}