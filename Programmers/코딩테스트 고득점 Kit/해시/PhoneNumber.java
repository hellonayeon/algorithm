import java.util.Arrays;

class PhoneNumber {
    public static boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);

        for(int i = 0; i < phone_book.length - 1; i++) {
            String prefix = phone_book[i];
            if(phone_book[i+1].startsWith(prefix)) return false;
        }
        return true;
    }
}