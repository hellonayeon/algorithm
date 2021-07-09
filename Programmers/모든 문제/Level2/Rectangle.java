// https://velog.io/@ajufresh/프로그래머스-멀쩡한-사각형-문제풀이-Java

import java.math.BigInteger;

class Rectangle {
    public long solution(int w, int h) {
        int gcd = BigInteger.valueOf(w).gcd(BigInteger.valueOf(h)).intValue();
        return ((long) w * (long) h) - ((((long) w / gcd) + ((long) h / gcd) - 1) * gcd);
    }
}
