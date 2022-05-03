import java.util.Calendar;

public class My{

    public static String Version = "22.0503_dev";

    public static String TimeOfDay(){
        Calendar cal = Calendar.getInstance();
        String result = "";
        result += cal.get(Calendar.HOUR_OF_DAY);
        result += ":";
        result += cal.get(Calendar.MINUTE);
        result += ":";
        result += cal.get(Calendar.SECOND);
        return result;
    }

};