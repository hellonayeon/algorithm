// [월간 코드 챌린지 시즌2] 5월 문제 해설 https://prgms.tistory.com/57
class DifferentBit {
    public long[] solution(long[] numbers) {
        long[] answer = numbers.clone();
        for(int i = 0; i< answer.length; i++){
            answer[i]++;
            answer[i] += (answer[i]^numbers[i])>>>2;
        }
        return answer;
    }    
}
