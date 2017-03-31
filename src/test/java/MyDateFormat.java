import org.junit.Test;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Tatiana on 31.03.2017.
 */

public class MyDateFormat {
    @Test
    public void main(){
        System.out.println(getDateInShortFormat());
        System.out.println(getDateInLargeFormat());
    }
    public String getDateInShortFormat(){
        Date myNowDate = new Date();
        SimpleDateFormat formatOk = new SimpleDateFormat("dd.MM.yyyy HH:mm");//21.03.2017 18:03
        String data = formatOk.format(myNowDate);
        return data;
    }
    public String getDateInLargeFormat(){
        Date myNowDate = new Date();
        SimpleDateFormat formatOk = new SimpleDateFormat("dd День MM Месяц yyyy год Время HH:mm");//31 День 03 Месяц 2017 год Время 12:25
        String data = formatOk.format(myNowDate);
        return data;
    }
}