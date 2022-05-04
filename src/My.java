import java.util.Calendar;

public class My{

    public static boolean isInied = false;

    public static void _ini_(int httpPt, int udpPt){
        httpPort = httpPt;
        udpPort = udpPt;

        isInied = true;
    }

    public static String Version = "22.0503_dev";

    public static String TimeOfDay(){
        Calendar cal = Calendar.getInstance();
        String result = "";
        result += cal.get(Calendar.HOUR_OF_DAY) < 10 ? "0" + cal.get(Calendar.HOUR_OF_DAY) : cal.get(Calendar.HOUR_OF_DAY);
        result += ":";
        result += cal.get(Calendar.MINUTE) < 10 ? "0" + cal.get(Calendar.MINUTE) : cal.get(Calendar.MINUTE);
        result += ":";
        result += cal.get(Calendar.SECOND) < 10 ? "0" + cal.get(Calendar.SECOND) : cal.get(Calendar.SECOND);
        return result;
    }
    
    public static int httpPort = 5252;
    public static int udpPort = 5253;

    void CheckConfigFile(){
        
    }

};