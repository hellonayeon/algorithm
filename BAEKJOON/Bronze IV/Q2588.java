import java.io.*;

// 출처: https://st-lab.tistory.com/20

class Q2588 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int num1 = Integer.parseInt(br.readLine());
		int num2 = Integer.parseInt(br.readLine());
		
		br.close();
        
		StringBuilder sb = new StringBuilder();
        
		sb.append(num1 * (num2%10));
		sb.append('\n');
		
		sb.append(num1 * ((num2%100)/10));
		sb.append('\n');
        
		sb.append(num1 * (num2/100));
		sb.append('\n');
        
		sb.append(num1 * num2);
 
		System.out.print(sb);
    }
}