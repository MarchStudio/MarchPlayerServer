import java.util.ArrayList;

public class Playlist {

    public static ArrayList<Song> pl = new ArrayList<Song>();

    static void add(Song TargetSg) {
        pl.add(TargetSg);
        Log.print(String.format("Song \"%s\" added.", TargetSg.toString()));
        SavePlaylist();
    }

    //https://host:5252/Playlist/Add/?{Song.toString()}

    static void add(String songSource) throws Exception {
        try {
            add(Song.toSong(songSource));
        } catch (Exception ex) {
            ex.printStackTrace();
            Log.print(String.format("Add song from string \"%s\" failed.", songSource));
            throw new Exception();
        }
    }

    static void remove(Song TargetSg) {
        pl.remove(TargetSg);
        Log.print(String.format("Song \"%s\" removed.", TargetSg.toString()));
        SavePlaylist();
    }

    //https://host:5252/Playlist/Remove/?{Song.toString()}

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

    static void ReadPlaylist(){
        pl = Data.ReadPlaylist();
    }

    static void SavePlaylist() {
        Data.WritePlaylist(pl);
    }
};
