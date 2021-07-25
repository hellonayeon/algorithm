import java.util.Arrays;

class Minimum
{
    public int solution(int []A, int []B)
    {
        Arrays.sort(A);
        Arrays.sort(B);

        int len = A.length;
        int min = 0;
        for(int idx = 0; idx < A.length; idx++)
            min += A[idx] * B[len-idx-1];

        return min;
    }
}