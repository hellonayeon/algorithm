class Average {
    public double solution(int[] arr) {
        double sum = 0.0;
        for(int idx = 0; idx < arr.length; idx++)
            sum += arr[idx];
        
        return sum / arr.length;
    }    
}
