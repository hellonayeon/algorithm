import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.TreeSet;
import java.util.Comparator;

class Q1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        TreeSet<String> set = new TreeSet<>(new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length()) return o1.compareTo(o2);
                else return o1.length() - o2.length();
            }
        });

        while(N-- > 0) {
            set.add(br.readLine());
        }
        
        StringBuilder sb = new StringBuilder();
        for(String w : set)
            sb.append(w).append("\n");

        System.out.print(sb);
    }
}