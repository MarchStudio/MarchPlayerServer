import java.util.ArrayList;

public class Playlist {

    public static ArrayList pl = new ArrayList<Song>();

    static void add(Song TargetSg) {
        pl.add(TargetSg);
    }

    static void remove(Song TargetSg) {
        pl.remove(TargetSg);
    }
};
