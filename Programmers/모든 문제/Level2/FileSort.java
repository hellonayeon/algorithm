import java.util.Arrays;
import java.util.Comparator;

class FileSort {
    public String[] solution(String[] files) {
        Arrays.sort(files, new Comparator<String>() {
           @Override
            public int compare(String s1, String s2) {
                String[] file1 = detach(s1);
                String[] file2 = detach(s2);

                String h1 = file1[0];
                String h2 = file2[0];

                // HEAD가 같다면
                if(h1.equals(h2)) {
                    int n1 = Integer.parseInt(file1[1]);
                    int n2 = Integer.parseInt(file2[1]);
                    return n1 - n2;
                }

                return h1.compareTo(h2);
            }
        });

        return files;
    }

    public String[] detach(String s) {
        String head = "";
        String number = "";

        int idx = 0;

        // HEAD
        for(; idx < s.length(); idx++) {
            char c = s.charAt(idx);
            if(c >= '0' && c <= '9') break;
            head += c;
        }

        // NUMBER
        for(; idx < s.length(); idx++) {
            char c = s.charAt(idx);
            if(!(c >= '0' && c <= '9')) break;
            number += c;
        }

        return new String[] {head.toUpperCase(), number};
    }
}