import java.util.HashSet;

class FindPrime {
    public int solution(String numbers) {
        HashSet<Integer> set = new HashSet<>();
        
     	permutation("", numbers, set);
        
        int cnt = 0;
        for(int num : set) {           
            if(num==2) cnt++;
            if(num%2!=0 && isPrime(num)) cnt++;
        }        
        return cnt;
    }
	
    // 순열방식으로 모든 문자열의 조합 만들기
    // i = 0 -> "1", "12", "123..."
    // i = 1 -> "2", "21", "213", "2134" ...
    public void permutation(String prefix, String str, HashSet<Integer> set) { 
        int n = str.length();        
        if(!prefix.equals("")) {
            // 맨 앞에 0이 오는 경우를 제외
           set.add(Integer.valueOf(prefix));
        }
        
        for (int i = 0; i < n; i++){
          permutation(prefix + str.charAt(i), 
                      str.substring(0, i) + str.substring(i+1, n), set);
        }
    }
    
    // 소수 찾기
    public boolean isPrime(int n){ 
        if(n==0 || n==1) return false;
        for(int i=2; i<=(int)Math.sqrt(n); i++){
            if(n%i==0) return false;
        }
        return true;
    }
}
