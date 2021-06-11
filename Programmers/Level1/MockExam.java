class MockExam {
    public static int[] solution(int[] answers) {
        int[] answer = {};
        
       int[][] a = {
            { 1, 2, 3, 4, 5 },
            { 2, 1, 2, 3, 2, 4, 2, 5 },
            { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 }
       };
        
        int[] hit = new int[3];
        for(int i=0; i<3; i++) {
            for(int j=0; j<answer.length; j++) {
                if(a[i][j % a[i].length] == answer[j]) hit[i]++;
            }
        }

        int max = Math.max(hit[0], Math.max(hit[1], hit[2]));
        int len = 0;
        for(int i=0; i<3; i++) {
            if(max == hit[i]) { len++; }
        }

        answer = new int[len];
        for(int i=0, idx=0; i<3; i++) {
            if(max == hit[i]) { answer[idx++] = i+1; }
        }
        
        return answer;
    }
}