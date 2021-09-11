import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.Collections;

class User implements Comparable<User>{
    int age;
    String name;
    int joinOrder;

    public User(String info, int joinOrder) {
        String[] infos = info.split(" ");
        this.age = Integer.parseInt(infos[0]);
        this.name = infos[1];
        this.joinOrder = joinOrder;
    }

    @Override
    public int compareTo(User u) {
        if(this.age == u.age) return this.joinOrder - u.joinOrder;

        return this.age - u.age;
    }
}

class Q10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<User> userList = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            User user = new User(br.readLine(), i+1);
            userList.add(user);
        }

        Collections.sort(userList);

        StringBuilder sb = new StringBuilder();
        for(User u : userList) {
            sb.append(u.age).append(" ").append(u.name).append("\n");
        }

        System.out.print(sb);
    }
}