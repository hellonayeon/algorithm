class GymSuit {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        
        int[] student = new int[n+2];
        
        for(int i = 0; i < lost.length; i++)
            student[lost[i]]--;
        
        for(int i = 0; i <reserve.length; i++)
            student[reserve[i]]++;
        
        for(int i = student.length-2; i >= 1; i--) {
            if(student[i] == -1) {
                if(student[i+1] == 1) {
                    student[i+1]--;
                    student[i]++;
                }
                else if(student[i-1] == 1) {
                    student[i-1]--;
                    student[i]++;
                }
                else {
                    answer--;
                }
            }
        }
        
        return answer;
    }
}