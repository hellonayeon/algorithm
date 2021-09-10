class Q4673 {
    public static void main(String[] args) {        
        boolean[] chk = new boolean[10001];
        int num = 0;
        while(num < 10000) {
            int tmp = ++num;
            int sum = tmp;
            while(tmp > 0) {
                sum += tmp % 10;
                tmp /= 10;
            }
            if(sum > 10000) continue;

            chk[sum] = true;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= 10000; i++) {
            if(!chk[i]) sb.append(i).append("\n");
        }

        System.out.print(sb);
    }
}