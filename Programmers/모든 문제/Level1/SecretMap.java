class SecretMap {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        int[] arr = new int[n]; // OR 연산 수행한 배열
        
        for(int idx = 0; idx < n; idx++)
            arr[idx] = arr1[idx] | arr2[idx];
        
        return decode(n, arr);
    }
    
    public String[] decode(int n, int[] arr) {
        String[] cipher_txt = new String[n];
        
        for(int idx = 0; idx < n; idx++) {
            cipher_txt[idx] = "";
            
            int dec = arr[idx];
            while(dec > 0) {
                cipher_txt[idx] = ((dec % 2 == 0) ? " " : "#") + cipher_txt[idx];
                dec /= 2;
            }
            
            if(cipher_txt[idx].length() < n) {
                int range = n - cipher_txt[idx].length();
                for(int i = 0; i < range; i++)
                    cipher_txt[idx] = " " + cipher_txt[idx];
            }
        }
        return cipher_txt;
    }
}