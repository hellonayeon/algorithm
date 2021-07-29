import java.util.Arrays;

class Lifeboat {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        
        int min = 0;
        for(int max = people.length - 1; min < max; max--) {
            if(people[min] + people[max] <= limit) min++;
        }
        
        return people.length - min;
    }
}
