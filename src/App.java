public class App {
    public static void main(String[] args) throws Exception {
        Log.print(String.format("Welcome! MarchPlayerServer Version %s.", My.Version));
        /*
        for(int i = 0; i < 2; i++){
            Song ts = new Song();
            ts.name = "N" + i;
            ts.singer = "S" + i;
            ts.url = "https://" + i + ".com";
            Playlist.add(ts);
        }
        */
        NetHttp.startHttp();
    }
}