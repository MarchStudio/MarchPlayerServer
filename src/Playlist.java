import java.util.ArrayList;

public class Playlist {

    public static ArrayList<Song> pl = new ArrayList<Song>();

    static void add(Song TargetSg) {
        pl.add(TargetSg);
    }

    static void remove(Song TargetSg) {
        pl.remove(TargetSg);
    }

    static String getAllUrls(){
        String result = "";
        for (Song song : pl) {
            result += song.toString();
            result += "\n";
        }
        return result;
    }
};
