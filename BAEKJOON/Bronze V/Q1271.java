import java.util.Scanner;
import java.math.BigInteger;

// 첫째 줄에는 최백준 조교가 가진 돈 n과 돈을 받으러 온 생명체의 수 m이 주어진다. (1 ≤ m ≤ n ≤ 10^1000, m과 n은 10진수 정수)
// int 자료형으로 표현할 수 있는 수의 범위 = -2147483648 ~ 2147483647
// 10^1000 = infinity
// 조건에 따라서 BigInteger 객체를 사용해야한다.

class Q1271 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger n = scanner.nextBigInteger();
        BigInteger m = scanner.nextBigInteger();

        scanner.close();

        System.out.println(n.divide(m));
        System.out.println(n.remainder(m));
    }
}