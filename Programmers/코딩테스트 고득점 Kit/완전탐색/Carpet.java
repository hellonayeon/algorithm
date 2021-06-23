class Carpet {
    public int[] solution(int brown, int yellow) {
        int[] ans = new int[2];    

        // yellow 격자의 행과 열 수를 기준으로 brown 개수 구하기
        for(int row = 1; row <= yellow; row++) {

            if(yellow % row == 0) {
                int col = yellow / row;

                // yellow 격자의 행이 row 이고 열이 col 일 때, brwon 의 개수
                if(brown == ((col + 2) * 2 + row * 2)) {
                    ans[0] = col + 2;
                    ans[1] = row + 2;
                    break;
                }
            }  
        }
        return ans;
    }
}