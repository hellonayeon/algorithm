import java.text.SimpleDateFormat;
import java.util.Date;

class Q10699 {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        System.out.println(sdf.format(date));
    }
}