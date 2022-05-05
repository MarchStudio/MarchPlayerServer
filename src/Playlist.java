import java.util.ArrayList;
import java.util.List;

public class Playlist {

    public static ArrayList<Song> pl = new ArrayList<Song>();

    static void add(Song TargetSg) {
        pl.add(TargetSg);
        Log.print(String.format("Song \"%s\" added.", TargetSg.toString()));
    }

    //https://host:5252/Playlist/Add/?Song.toString()

    static void add(String songSource) throws Exception {
        try {
            Song song = new Song();
            String[] source = songSource.split(";");
            song.name = source[0];
            song.singer = source[1];
            song.url = source[2];
            song.coverUrl = source[3];
            song.uploader = source[4];
            add(song);
        } catch (Exception ex) {
            ex.printStackTrace();
            Log.print(String.format("Add song from string \"%s\" failed.", songSource));
            throw new Exception();
        }
    }

    static void remove(Song TargetSg) {
        pl.remove(TargetSg);
        Log.print(String.format("Song \"%s\" removed.", TargetSg.toString()));
    }

    //https://host:5252/Playlist/Remove/?Song.toString()

    static void remove(String songSource) throws Exception {
        try {
            ArrayList<Song> Tgs = new ArrayList<Song>();
            int nums = 0;
            for (Song song : pl) {
                if (Data.MagicCompare(song.toString(), songSource)) {
                    Tgs.add(song);
                    nums++;
                }
            }
            if (nums == 0)
                throw new Exception();
            for (Song song : Tgs) {
                remove(song);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            Log.print(String.format("Remove song from string \"%s\" failed.", songSource));
            throw new Exception();
        }
    }

    static String getAllUrls() {
        String result = "";
        for (Song song : pl) {
            result += song.toString();
            result += "\n";
        }
        return result;
    }
};
